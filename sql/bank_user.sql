CREATE TABLE user
(
    id       int AUTO_INCREMENT COMMENT '编号'
        PRIMARY KEY,
    idNumber varchar(128) NULL COMMENT '身份证号码',
    password varchar(128) NULL COMMENT '客户密码',
    sex      varchar(128) NULL COMMENT '性别',
    phone    varchar(128) NULL COMMENT '电话号码'
)
    AUTO_INCREMENT = 5;

INSERT INTO bank.user (id, idNumber, password, sex, phone) VALUES (1, 'test', 'test', '男', '110');
INSERT INTO bank.user (id, idNumber, password, sex, phone) VALUES (5, 'ljj', 'bbb', '男', '18974221207');
INSERT INTO bank.user (id, idNumber, password, sex, phone) VALUES (6, 'ccsu', 'test', '女', '110');
