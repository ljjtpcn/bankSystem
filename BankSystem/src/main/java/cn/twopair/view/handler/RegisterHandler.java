package cn.twopair.view.handler;

import cn.twopair.dao.DaoUtil;
import cn.twopair.pojo.User;
import cn.twopair.util.Check;
import cn.twopair.view.window.LoginView;
import cn.twopair.view.window.RegisterView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @description:
 * @author: 李佳骏
 * @date: 2021-12-11 16:52
 * @version: 1.0
 * @email: ljjtpcn@163.com
 */

public class RegisterHandler implements ActionListener {

    private final RegisterView registerView;

    public RegisterHandler(RegisterView registerView) {
        this.registerView = registerView;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String text = button.getText();
        String cancelText = "取消";
        String registerText = "注册";
        if (registerText.equals(text)) {
            if (register()) {
                JOptionPane.showMessageDialog(registerView, "注册成功！请关闭注册页面登录");
            } else {
                JOptionPane.showMessageDialog(registerView, "注册失败！ 请重新注册！", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else if (cancelText.equals(text)) {
            registerView.dispose();
            new LoginView();
        }
    }

    private boolean register() {
        //获取注册信息
        String id = registerView.getUsernameText().getText();
        char[] s = registerView.getPasswordText().getPassword();
        String password = String.valueOf(s);
        String phone = registerView.getPhoneText().getText();
        String sex = null;
        if (registerView.getMaleButton().isSelected()) {
            sex = "男";
        } else if (registerView.getFemaleButton().isSelected()) {
            sex = "女";
        }

        //前台效验数据合法性
        if (Check.isEmpty(id, password, phone)) {
            return false;
        } else {
            //发送请求并返回注册结果
            User user = new User(id, password, sex, phone);
            return DaoUtil.regist(user);
        }

    }


}
