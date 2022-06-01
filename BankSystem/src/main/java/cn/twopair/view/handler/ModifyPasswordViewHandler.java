package cn.twopair.view.handler;

import cn.twopair.dao.DaoUtil;
import cn.twopair.view.window.LoginView;
import cn.twopair.view.window.MainView;
import cn.twopair.view.window.ModifyPasswordView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName ModifyPasswordViewHandler
 * @Description TODO
 * @Author ljjtpcn
 * @Date 2022/5/31 下午5:20
 * @Version 1.0
 **/
public class ModifyPasswordViewHandler implements ActionListener {

    private ModifyPasswordView modifyPasswordView;
    private MainView mainView;

    public ModifyPasswordViewHandler(ModifyPasswordView modifyPasswordView, MainView mainView) {
        this.modifyPasswordView = modifyPasswordView;
        this.mainView = mainView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String text = button.getText();

        if ("确定".equals(text)) {
            if (DaoUtil.modifyUserPassword(mainView.getUser(), modifyPasswordView.getUserPasswordText().getText())) {
                JOptionPane.showMessageDialog(modifyPasswordView, "修改成功！请重新登录！");
                new LoginView();
                modifyPasswordView.dispose();
                mainView.dispose();
            } else {
                JOptionPane.showMessageDialog(modifyPasswordView, "修改失败！");
            }
        } else if ("取消".equals(text)) {
            modifyPasswordView.dispose();
        }
    }
}
