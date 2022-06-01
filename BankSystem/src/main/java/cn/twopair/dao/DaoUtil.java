package cn.twopair.dao;

import cn.twopair.pojo.Log;
import cn.twopair.pojo.User;
import cn.twopair.res.TableDTO;
import cn.twopair.service.Services;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

/**
 * @author ljjtpcn
 */
public class DaoUtil {
    static String resource = "mybatis-config.xml";
    static InputStream inputStream;

    static {
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }


    /**
     * @Param: user
     * @Description: 传入user 注册信息注册
     * @Return: boolean
     * @Author: 李佳骏
     * @Date: 2022/5/25 下午6:16
     */
    public static boolean regist(User user) {
        SqlSession sqlSession = DaoUtil.getSqlSession();
        try {
            HashMap<String, Object> params = new HashMap<>();
            params.put("sex", user.getSex());
            params.put("id", user.getIdNumber());
            params.put("password", user.getPassword());
            params.put("phone", user.getPhone());
            Services services = sqlSession.getMapper(Services.class);
            services.regist(params);
            //事务提交
            sqlSession.commit();
            return (Boolean) params.get("flag");
        } catch (Exception exception) {
            //异常回滚
            sqlSession.rollback();
            return false;
        } finally {
            sqlSession.close();
        }

    }

    /**
     * @Param: user
     * @Description: 传入user 登录信息注册
     * @Return: boolean
     * @Author: 李佳骏
     * @Date: 2022/5/25 下午7:07
     */
    public static boolean login(User user) {
        try (SqlSession sqlSession = DaoUtil.getSqlSession()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("id", user.getIdNumber());
            params.put("password", user.getPassword());
            Services services = sqlSession.getMapper(Services.class);
            services.login(params);

            return (Boolean) params.get("flag");
        } catch (Exception exception) {
            return false;
        }
    }


    /**
     * @Param: idNumber 身份证号码
     * @Description: 查询身份证号码对应的所有交易记录数据
     * @Return: cn.twopair.res.TableDTO
     * @Author: 李佳骏
     * @Date: 2022/5/26 上午10:56
     */
    public static TableDTO getTableDataByIdNumber(String idNumber) {
        TableDTO tableDTO = new TableDTO();
        try (SqlSession sqlSession = DaoUtil.getSqlSession()) {
            Vector<Vector<Object>> data = new Vector<>();
            Services services = sqlSession.getMapper(Services.class);
            List<Log> dataList = services.getTableDataByIdNumber(idNumber);
            for (Log log : dataList) {
                var id = log.getId();
                var cardNumber = log.getCardNumber();
                var date = log.getDealTime();
                var money = log.getMoney();
                var type = log.getType();
                var comment = log.getComment();

                Vector<Object> row = addRowData(id, cardNumber, date, money, type, comment);
                data.add(row);
            }
            tableDTO.setData(data);
            tableDTO.setTotalCount(data.size());
            return tableDTO;
        } catch (Exception exception) {
            return new TableDTO();
        }
    }

    public static TableDTO getTableDataByCardNumber(String idNumber, String cardNumber) {
        TableDTO tableDTO = new TableDTO();
        try (SqlSession sqlSession = DaoUtil.getSqlSession()) {
            Vector<Vector<Object>> data = new Vector<>();
            Services services = sqlSession.getMapper(Services.class);
            List<Log> dataList = services.getTableDataByCardNumber(idNumber, cardNumber);
            for (Log log : dataList) {
                var id = log.getId();
                var date = log.getDealTime();
                var money = log.getMoney();
                var type = log.getType();
                var comment = log.getComment();

                Vector<Object> row = addRowData(id, cardNumber, date, money, type, comment);
                data.add(row);
            }
            tableDTO.setData(data);
            tableDTO.setTotalCount(data.size());
            System.out.println("!!!!!" + data.size());
            return tableDTO;
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("dadadadad");
            return new TableDTO();
        }
    }

    private static Vector<Object> addRowData(String id, String cardNumber, Date date, Double money, String type, String comment) {
        Vector<Object> rowData = new Vector<>();
        rowData.add(id);
        rowData.add(cardNumber);
        rowData.add(date);
        rowData.add(money);
        rowData.add(type);
        rowData.add(comment);

        return rowData;
    }

    /**
     * @Param: log
     * @Description: 存钱
     * @Return: boolean
     * @Author: 李佳骏
     * @Date: 2022/5/26 下午6:02
     */
    public static boolean saveMoney(Log log) {
        SqlSession sqlSession = DaoUtil.getSqlSession();
        try {
            HashMap<String, Object> params = new HashMap<>();
            params.put("user", log.getUser());
            params.put("cardNumber", log.getCardNumber());
            params.put("money", log.getMoney());
            params.put("comment", log.getComment());
            Services services = sqlSession.getMapper(Services.class);
            services.bankSavings(params);
            //事务提交
            sqlSession.commit();
            return (Boolean) params.get("flag");
        } catch (Exception exception) {
            //异常回滚
            sqlSession.rollback();
            return false;
        } finally {
            sqlSession.close();
        }
    }

    /**
     * @Param: log
     * @Description: 取钱
     * @Return: boolean
     * @Author: 李佳骏
     * @Date: 2022/5/26 下午6:02
     */
    public static boolean getMoney(Log log) {
        SqlSession sqlSession = DaoUtil.getSqlSession();
        try {
            HashMap<String, Object> params = new HashMap<>();
            params.put("user", log.getUser());
            params.put("cardNumber", log.getCardNumber());
            params.put("money", log.getMoney());
            params.put("comment", log.getComment());
            Services services = sqlSession.getMapper(Services.class);
            services.bankGets(params);
            //事务提交
            sqlSession.commit();
            return (Boolean) params.get("flag");
        } catch (Exception exception) {
            //异常回滚
            sqlSession.rollback();
            return false;
        } finally {
            sqlSession.close();
        }
    }

    public static String getCardPassword(String cardNumber) {
        SqlSession sqlSession = DaoUtil.getSqlSession();
        Services services = sqlSession.getMapper(Services.class);
        String password = services.getCardPassword(cardNumber);
        sqlSession.close();
        return password;
    }


    public static boolean transferMoney(Log log, String sendCardNumber) {
        SqlSession sqlSession = DaoUtil.getSqlSession();
        try {
            HashMap<String, Object> params = new HashMap<>();
            params.put("sendCardNumber", sendCardNumber);
            params.put("acceptCardNumber", log.getCardNumber());
            params.put("money", log.getMoney());
            Services services = sqlSession.getMapper(Services.class);
            services.transfer(params);
            //事务提交
            sqlSession.commit();
            return (Boolean) params.get("flag");
        } catch (Exception exception) {
            //异- 常回滚
            sqlSession.rollback();
            return false;
        } finally {
            sqlSession.close();
        }
    }

    public static HashMap<String, Object> openCard(String user, String password, String moneyString) {
        SqlSession sqlSession = DaoUtil.getSqlSession();
        HashMap<String, Object> params = new HashMap<>();
        params.put("flag", "default");
        try {
            params.put("user", user);
            params.put("password", password);
            params.put("money", Double.valueOf(moneyString));
            Services services = sqlSession.getMapper(Services.class);
            services.openCard(params);
            //事务提交
            sqlSession.commit();
            return params;
        } catch (Exception exception) {
            //异常回滚
            sqlSession.rollback();
            return params;
        } finally {
            sqlSession.close();
        }
    }

    public static boolean modifyUserPassword(String user, String newPassword) {
        SqlSession sqlSession = DaoUtil.getSqlSession();
        try {
            HashMap<String, Object> params = new HashMap<>();
            params.put("user", user);
            params.put("newPassword", newPassword);
            Services services = sqlSession.getMapper(Services.class);
            services.modifyUserPassword(params);
            //事务提交
            sqlSession.commit();
            return (Boolean) params.get("flag");
        } catch (Exception exception) {
            //异常回滚
            sqlSession.rollback();
            return false;
        } finally {
            sqlSession.close();
        }
    }
}
