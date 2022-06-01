package cn.twopair.util;

import cn.twopair.dao.DaoUtil;
import cn.twopair.service.Services;
import org.apache.ibatis.session.SqlSession;

/**
 * @ClassName EmptyCheck
 * @Description TODO
 * @Author ljjtpcn
 * @Date 2022/5/25 下午6:33
 * @Version 1.0
 **/
public class Check {
    
    /**
     * @Param: texts
     * @Description: 检测字符串是否为空
     * @Return: boolean
     * @Author: 李佳骏
     * @Date: 2022/5/25 下午8:54
     */
    public static boolean isEmpty(String... texts) {
        for (String text : texts) {
            if (text == null || "".equals(text.trim())) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean checkPassword(String cardNumber, String inputPassword){
        SqlSession sqlSession = DaoUtil.getSqlSession();
        Services services = sqlSession.getMapper(Services.class);
        String cardPassword = services.getCardPassword(cardNumber);
        return cardPassword != null && cardPassword.equals(inputPassword);
    }
}
