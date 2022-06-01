package cn.twopair.view.handler;

import cn.twopair.dao.DaoUtil;
import cn.twopair.pojo.User;
import cn.twopair.util.Check;
import cn.twopair.view.window.LoginView;
import cn.twopair.view.window.MainView;
import cn.twopair.view.window.RegisterView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName LoginHandler
 * @Description TODO
 * @Author ljjtpcn
 * @Date 2022/5/10 上午11:23
 * @Version 1.0
 **/
public class LoginHandler implements ActionListener {
    private final LoginView loginView;

    public LoginHandler(LoginView loginView) {
        this.loginView = loginView;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String text = button.getText();
        String loginText = "登录";
        String registerText = "注册";
        if (loginText.equals(text)) {
            // 判空！
            if (Check.isEmpty(loginView.getUserNameField().getText(), loginView.getPassWordField().getText())) {
                JOptionPane.showMessageDialog(loginView, "请输入账号密码！", "WARNING", JOptionPane.WARNING_MESSAGE);
                loginView.getInputCode().setText("");
                loginView.getPicture(loginView.getAuthCode(), loginView.getCodePanel());
            } else {
                // 效验验证码准确性
                String code = loginView.getInputCode().getText().toLowerCase();
                if (!code.equals(loginView.getCode().toLowerCase())) {
                    JOptionPane.showMessageDialog(loginView, "验证码错误！", "ERROR", JOptionPane.ERROR_MESSAGE);
                    loginView.getInputCode().setText("");
                    loginView.getPicture(loginView.getAuthCode(), loginView.getCodePanel());
                } else {
                    if (login()) {
                        JOptionPane.showMessageDialog(loginView, "登录成功！");
                        new MainView(loginView.getUserNameField().getText());
                        loginView.dispose();
                    } else {
                        JOptionPane.showMessageDialog(loginView, "密码错误", "ERROR", JOptionPane.ERROR_MESSAGE);
                        loginView.getInputCode().setText("");
                        loginView.getPicture(loginView.getAuthCode(), loginView.getCodePanel());
                    }
                }
            }

        } else if (registerText.equals(text)) {
            loginView.dispose();
            new RegisterView();
        }
    }


    private boolean login() {
        //获取登录信息
        String id = loginView.getUserNameField().getText();
        String password = loginView.getPassWordField().getText();

        //发送请求并返回登录结果
        User user = new User(id, password, "", "");
        return DaoUtil.login(user);
    }
}
