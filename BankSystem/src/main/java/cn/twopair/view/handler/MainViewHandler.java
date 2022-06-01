package cn.twopair.view.handler;


import cn.twopair.view.window.*;

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

public class MainViewHandler implements ActionListener {

    private MainView mainView;

    public MainViewHandler(MainView mainView) {
        this.mainView = mainView;
    }


    @SuppressWarnings("AlibabaUndefineMagicConstant")
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String text = button.getText();
        if ("卡号交易信息查询".equals(text)) {
            String op = mainView.getSearchTextField().getText();
            if ("exit".equals(op)) {
                int result = JOptionPane.showConfirmDialog(
                        mainView,
                        "确定退出登录?",
                        "警告",
                        JOptionPane.YES_NO_CANCEL_OPTION
                );
                if (result == JOptionPane.YES_OPTION) {
                    new LoginView();
                    mainView.dispose();
                }
            } else {
                mainView.reloadTable(mainView.getUser(), mainView.getSearchTextField().getText());
                System.out.println(mainView.getSearchTextField().getText());
                mainView.getSearchTextField().setText("");
            }
        } else if ("存款业务".equals(text)) {
            new AddView(mainView);
        } else if ("取款业务".equals(text)) {
            new WithdrawalView(mainView);
        } else if ("转账业务".equals(text)) {
            new TransferView(mainView);
        } else if ("开卡业务".equals(text)) {
            new AddCardNumberView(mainView);
        } else if ("用户密码修改".equals(text)) {
            new ModifyPasswordView(mainView);
        }
    }


}
