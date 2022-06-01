CREATE TABLE card
(
    id         int AUTO_INCREMENT COMMENT '编号'
        PRIMARY KEY,
    cardNumber varchar(128)              NULL COMMENT '银行卡号',
    ofIdNumber varchar(128)              NULL COMMENT '所属账户身份证号码',
    password   varchar(128)              NULL COMMENT '卡密码',
    startTime  datetime                  NULL COMMENT '开户时间',
    money      double                    NULL COMMENT '金额',
    type       varchar(128) DEFAULT '活期' NULL COMMENT '卡类型',
    status     tinyint(1)   DEFAULT 1    NULL COMMENT '卡状态'
)
    AUTO_INCREMENT = 6;

INSERT INTO bank.card (id, cardNumber, ofIdNumber, password, startTime, money, type, status) VALUES (1, '123456', 'test', '123456', '2022-05-26 18:07:51', 6054.12, '1', 1);
INSERT INTO bank.card (id, cardNumber, ofIdNumber, password, startTime, money, type, status) VALUES (6, '8888888820220531879', 'ljj', 'aaa', '2022-05-31 20:40:14', 4801, '活期', 1);
INSERT INTO bank.card (id, cardNumber, ofIdNumber, password, startTime, money, type, status) VALUES (7, '8888888820220601297', 'ccsu', '123', '2022-06-01 09:02:50', 1100, '活期', 1);
INSERT INTO bank.card (id, cardNumber, ofIdNumber, password, startTime, money, type, status) VALUES (8, '8888888820220601868', 'ccsu', '123', '2022-06-01 09:03:57', 111, '活期', 1);
INSERT INTO bank.card (id, cardNumber, ofIdNumber, password, startTime, money, type, status) VALUES (9, '8888888820220601647', 'ccsu', '123', '2022-06-01 09:04:02', 111, '活期', 1);
