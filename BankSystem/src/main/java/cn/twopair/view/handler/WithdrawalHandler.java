package cn.twopair.view.handler;


import cn.twopair.dao.DaoUtil;
import cn.twopair.pojo.Log;
import cn.twopair.util.Check;
import cn.twopair.view.window.MainView;
import cn.twopair.view.window.WithdrawalView;

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

public class WithdrawalHandler implements ActionListener {

    private final WithdrawalView withdrawalView;
    private final MainView mainView;

    public WithdrawalHandler(WithdrawalView withdrawalView, MainView mainView) {
        this.withdrawalView = withdrawalView;
        this.mainView = mainView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String text = button.getText();

        if ("确定".equals(text)) {
            if (Check.isEmpty(withdrawalView.getMoneyText().getText(), withdrawalView.getCardNumberText().getText())) {
                JOptionPane.showMessageDialog(withdrawalView, "请检查是否有缺项未填");
            } else {
                Log log = new Log("", withdrawalView.getCardNumberText().getText(),
                        null, Double.valueOf(withdrawalView.getMoneyText().getText()),
                        "取出", withdrawalView.getRemarkText().getText(), withdrawalView.getUser());
                if (!Check.checkPassword(log.getCardNumber(), withdrawalView.getCardPasswordText().getText())) {
                    JOptionPane.showMessageDialog(withdrawalView, "密码错误", "ERROR",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    if (DaoUtil.getMoney(log)) {
                        mainView.reloadTable(mainView.getUser());
                        JOptionPane.showMessageDialog(withdrawalView, "取款成功！");
                    } else {
                        JOptionPane.showMessageDialog(withdrawalView, "取款失败！");
                    }
                }
            }

        } else if ("取消".equals(text)) {
            withdrawalView.dispose();
        }

    }
}
