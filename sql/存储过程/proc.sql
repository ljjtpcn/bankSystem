-- 登录功能
DROP PROCEDURE IF EXISTS login;
CREATE PROCEDURE login(IN _idNumber varchar(128), IN _password varchar(128), OUT flag boolean)
BEGIN
    IF (_password = (SELECT password FROM user WHERE user.idNumber = _idNumber)) THEN
        SET flag = 1;
    ELSE
        SET flag = 0;
    END IF;
END;

-- 注册功能
DROP PROCEDURE IF EXISTS register;
CREATE PROCEDURE register(IN _idNumber varchar(128), IN _password varchar(128), IN _sex varchar(128),
                          IN _phone varchar(128), OUT flag tinyint(1))
BEGIN
    IF (EXISTS(SELECT * FROM user WHERE _idNumber = user.idNumber)) THEN
        SET flag = 0;
    ELSE
        INSERT INTO user VALUES (NULL, _idNumber, _password, _sex, _phone);
        SET flag = 1;
    END IF;
END;

-- 修改账号密码功能
DROP PROCEDURE IF EXISTS modify_user_password;
CREATE PROCEDURE modify_user_password(_idNumber varchar(128), _newPassword varchar(128), OUT flag boolean)
BEGIN
    SET flag = 0;
    UPDATE user SET password = _newPassword WHERE idNumber = _idNumber;
    SET flag = 1;
END;

-- 开卡业务
DROP PROCEDURE IF EXISTS open_card;
CREATE PROCEDURE open_card(_ofIdNumber VARCHAR(128), _password VARCHAR(128), _money DOUBLE,
                           OUT _cardNumber VARCHAR(128),
                           OUT flag integer)
BEGIN
    DECLARE cnt INT;
    DECLARE rand INT DEFAULT 100;
    SELECT COUNT(*) INTO cnt FROM card WHERE card.ofIdNumber = _ofIdNumber;
    IF (cnt >= 3) THEN
        SET flag = 0; -- 满3张卡
    ELSE
        -- 生成 3 位的随机数
        SELECT CEILING(RAND() * 900 + 100) INTO rand;
        SET _cardNumber = CONCAT('88888888', DATE_FORMAT(DATE(NOW()), '%Y%m%d'), rand);
        INSERT INTO card(cardNumber, ofIdNumber, password, startTime, money, type, status)
        VALUES (_cardNumber, _ofIdNumber, _password, TIMESTAMP(NOW()), _money, '活期', 1);
        SET flag = 1;
    END IF;
END;

-- 存款业务
DROP PROCEDURE IF EXISTS bank_savings;
CREATE PROCEDURE bank_savings(_user varchar(128), _cardNumber varchar(128), _money double, _comment varchar(128),
                              OUT flag boolean)
BEGIN
    SET flag = 0;
    UPDATE card SET money = money + _money WHERE cardNumber = _cardNumber;
    INSERT INTO log VALUES (NULL, _cardNumber, TIMESTAMP(NOW()), _money, '存入', _comment, _user);
    SET flag = 1;
END;

-- 取款业务
DROP PROCEDURE IF EXISTS bank_withdraw;
CREATE PROCEDURE bank_withdraw(_user varchar(128), _cardNumber varchar(128), _money double, _comment varchar(128),
                               OUT flag boolean)
BEGIN
    DECLARE cur_money double DEFAULT 0;
    SELECT money INTO cur_money FROM card WHERE cardNumber = _cardNumber;
    IF (cur_money - 1 < _money) THEN
        SET flag = 0;
    ELSE
        UPDATE card SET money = money - _money WHERE cardNumber = _cardNumber;
        INSERT INTO log VALUES (NULL, _cardNumber, TIMESTAMP(NOW()), _money, '取出', _comment, _user);
        SET flag = 1;
    END IF;
END;

-- 转账业务
DROP PROCEDURE IF EXISTS transfer;
CREATE PROCEDURE transfer(_sendCardNumber varchar(128), _acceptCardNumber varchar(128), _money double,
                          OUT flag boolean)
BEGIN
    DECLARE sendMoney double DEFAULT 0;
    DECLARE acceptMoney double DEFAULT 0;
    DECLARE sendIdNumber varchar(128);
    DECLARE acceptIdNumber varchar(128);
    SELECT money INTO sendMoney FROM card WHERE cardNumber = _sendCardNumber;
    SELECT money INTO acceptMoney FROM card WHERE cardNumber = _acceptCardNumber;
    SELECT ofIdNumber INTO sendIdNumber FROM card WHERE cardNumber = _sendCardNumber;
    SELECT ofIdNumber INTO acceptIdNumber FROM card WHERE cardNumber = _acceptCardNumber;
    IF (sendMoney - 1 < _money) THEN
        SET flag = 0;
    ELSE
        UPDATE card SET money = money - _money WHERE cardNumber = _sendCardNumber;
        UPDATE card SET money = money + _money WHERE cardNumber = _acceptCardNumber;
        INSERT INTO log VALUES (NULL, _sendCardNumber, TIMESTAMP(NOW()), _money, '取出', '转账', sendIdNumber);
        INSERT INTO log VALUES (NULL, _acceptCardNumber, TIMESTAMP(NOW()), _money, '存入', '转账', acceptIdNumber);
        SET flag = 1;
    END IF;
END;

-- 修改卡号密码功能
DROP PROCEDURE IF EXISTS modify_card_password;
CREATE PROCEDURE modify_card_password(_cardNumber varchar(128), _newPassword varchar(128), OUT flag boolean)
BEGIN
    SET flag = 0;
    UPDATE card SET password = _newPassword WHERE _cardNumber = cardNumber;
    SET flag = 1;
END;