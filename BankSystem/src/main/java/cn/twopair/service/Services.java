package cn.twopair.service;

import cn.twopair.pojo.Log;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName Services
 * @Description 服务类接口
 * @Author ljjtpcn
 * @Date 2022/5/25 下午5:19
 * @Version 1.0
 **/
public interface Services {
    /**
     * @Param: params
     * @Description: 用户注册服务 map中应含有key[sex, id, password] -> [身份证号（注册账号）， 密码（注册密码）,性别， 手机号码]
     * @Return: void 通过key[flag] 的值判断是否注册成功，true为注册成功
     * @Author: 李佳骏
     * @Date: 2022/5/25 下午5:29
     */
    void regist(HashMap<String, Object> params);


    /**
     * @Param: params 参数
     * @Description: 用户登录服务 map中应含有key[ id, password] -> [ 身份证号（登录账号）， 密码（登录密码）]
     * @Return: void 通过key[flag] 的值判断是否登录成功，true为登录成功
     * @Author: 李佳骏
     * @Date: 2022/5/25 下午5:31
     */
    void login(HashMap<String, Object> params);


    /**
     * @Param: idNumber 身份证号码
     * @Description: 查询身份证号码对应的所有交易记录
     * @Return: java.util.List<cn.twopair.pojo.Log>
     * @Author: 李佳骏
     * @Date: 2022/5/26 上午10:27
     */
    List<Log> getTableDataByIdNumber(String idNumber);


    /**
     * @Param: user
     * @Param: card
     * @Description: 查询user名下银行卡号为card的交易记录
     * @Return: java.util.List<cn.twopair.pojo.Log>
     * @Author: 李佳骏
     * @Date: 2022/6/1 下午2:07
     */
    List<Log> getTableDataByCardNumber(@Param("user") String user, @Param("card") String card);


    /**
     * @Param: params
     * @Description: TODO
     * @Return: void 通过key[flag] 的值判断是否存款成功
     * @Author: 李佳骏
     * @Date: 2022/5/26 下午6:46
     */
    void bankSavings(HashMap<String, Object> params);

    /**
     * @Param: params
     * @Description: 取款操作
     * @Return: void
     * @Author: 李佳骏
     * @Date: 2022/6/1 下午2:06
     */
    void bankGets(HashMap<String, Object> params);


    /**
     * @Param: cardNumber
     * @Description: 返回传入的卡号密码
     * @Return: java.lang.String
     * @Author: 李佳骏
     * @Date: 2022/6/1 下午2:04
     */
    String getCardPassword(String cardNumber);


    /**
     * @Param: params
     * @Description: 转账操作
     * @Return: void
     * @Author: 李佳骏
     * @Date: 2022/6/1 下午2:05
     */
    void transfer(HashMap<String, Object> params);


    /**
     * @Param: params
     * @Description: 开卡业务
     * @Return: void
     * @Author: 李佳骏
     * @Date: 2022/6/1 下午2:03
     */
    void openCard(HashMap<String, Object> params);


    /**
     * @Param: params
     * @Description: 修改用户密码
     * @Return: void
     * @Author: 李佳骏
     * @Date: 2022/6/1 下午2:04
     */
    void modifyUserPassword(HashMap<String, Object> params);
}
