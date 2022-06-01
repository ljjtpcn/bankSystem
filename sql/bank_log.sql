CREATE TABLE log
(
    id         int AUTO_INCREMENT COMMENT '编号'
        PRIMARY KEY,
    cardNumber varchar(128) NULL COMMENT '交易卡号',
    dealTime   datetime     NULL COMMENT '交易日期',
    money      double       NULL COMMENT '交易金额',
    type       varchar(128) NULL COMMENT '交易类型',
    comment    varchar(128) NULL COMMENT '备注',
    user       varchar(128) NULL COMMENT '用户'
)
    AUTO_INCREMENT = 38;

INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (3, '123456', '2022-05-26 00:00:00', 123, '存入', '3131231231', 'test');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (4, '123456', '2022-05-26 00:00:00', 1, '存入', '3131231231', 'test');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (5, '123456', '2022-05-26 00:00:00', 22.4, '存入', '哈哈哈哈或或或或', 'test');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (6, '123456', '2022-05-26 00:00:00', 11.11, '存入', '测试存款密码', 'test');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (7, '123456', '2022-05-26 00:00:00', 57.51, '取出', '13', 'test');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (8, '123456', '2022-05-26 00:00:00', 57.51, '取出', '13', 'test');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (9, '123456', '2022-05-26 00:00:00', 0.49, '取出', '312', 'test');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (10, '123456', '2022-05-26 20:24:40', 8, '存入', '测试日期格式', 'test');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (11, '123456', '2022-05-26 20:28:36', 50, '取出', '测试取款', 'test');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (12, '123456', '2022-05-26 20:30:14', 10, '存入', '发工资', 'test');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (13, '123456', '2022-05-26 20:30:47', 9, '取出', '测试最低剩1元', 'test');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (14, '123456', '2022-05-26 21:06:15', 100, '存入', '发工资', 'test');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (15, '123456', '2022-05-26 21:07:30', 1, '取出', '买对象', 'test');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (16, '123456', '2022-05-26 21:08:17', 99, '取出', '买对象', 'test');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (17, '123456', '2022-05-26 21:08:39', 1000, '存入', '暴富', 'test');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (18, '123456', '2022-05-26 21:09:09', 20.88, '取出', '嘎嘎嘎', 'test');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (19, '123456', '2022-05-26 21:09:23', 250, '取出', '嘤嘤嘤', 'test');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (20, '123456', '2022-05-26 21:09:49', 123, '取出', 'Ｏ(≧口≦)Ｏ', 'test');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (21, '123456', '2022-05-26 21:09:53', 2, '取出', 'Ｏ(≧口≦)Ｏ', 'test');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (22, '123456', '2022-05-26 21:09:55', 2, '取出', 'Ｏ(≧口≦)Ｏ', 'test');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (23, '123456', '2022-05-26 21:09:58', 2, '取出', 'Ｏ(≧口≦)Ｏ', 'test');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (24, '123456', '2022-05-26 21:10:47', 12, '取出', '达达1', 'test');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (25, '123456', '2022-05-26 21:10:50', 12, '取出', '达达2', 'test');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (26, '123456', '2022-05-26 21:10:53', 12, '取出', '达达3', 'test');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (27, '123456', '2022-05-26 21:10:55', 12, '取出', '达达4', 'test');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (28, '123456', '2022-05-26 21:10:58', 12, '取出', '达达5', 'test');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (29, '123456', '2022-05-26 21:11:02', 12, '取出', '达达6', 'test');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (30, '123456', '2022-05-26 21:11:10', 12, '取出', '达达7', 'test');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (31, '123456', '2022-05-26 21:11:12', 12, '取出', '达达8', 'test');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (32, '123456', '2022-05-26 21:11:14', 12, '取出', '达达9', 'test');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (33, '123456', '2022-05-26 21:11:16', 12, '取出', '达达13', 'test');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (34, '123456', '2022-05-26 21:11:19', 12, '取出', '达达1331', 'test');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (35, '123456', '2022-05-26 21:11:21', 12, '取出', '达达133131', 'test');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (36, '123456', '2022-05-31 16:24:16', 4, '取出', '转账', 'test');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (38, '8888888820220531879', '2022-05-31 20:41:34', 150, '存入', '发工资了', 'ljj');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (39, '8888888820220531879', '2022-05-31 20:42:38', 1, '取出', '转账', 'ljj');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (40, '123456', '2022-05-31 20:42:38', 1, '存入', '转账', 'test');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (41, '8888888820220531879', '2022-05-31 20:43:23', 20, '取出', '啊哈哈哈', 'ljj');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (42, '8888888820220531879', '2022-05-31 20:46:12', 228, '取出', '找对象留一块钱吃泡面', 'ljj');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (43, '8888888820220531879', '2022-05-31 20:47:10', 10000, '存入', '抱大腿了', 'ljj');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (44, '8888888820220531879', '2022-05-31 20:49:07', 5200, '取出', '转账', 'ljj');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (45, '123456', '2022-05-31 20:49:07', 5200, '存入', '转账', 'test');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (46, '8888888820220601297', '2022-06-01 09:04:49', 1000, '存入', '存款', 'ccsu');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (47, '8888888820220601297', '2022-06-01 09:05:23', 500, '取出', '取款', 'ccsu');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (48, '8888888820220601297', '2022-06-01 09:07:13', 400, '取出', '转账', 'ccsu');
INSERT INTO bank.log (id, cardNumber, dealTime, money, type, comment, user) VALUES (49, '123456', '2022-06-01 09:07:13', 400, '存入', '转账', 'test');
