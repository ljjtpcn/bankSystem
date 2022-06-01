package cn.twopair.view.handler;


import cn.twopair.dao.DaoUtil;
import cn.twopair.pojo.Log;
import cn.twopair.util.Check;
import cn.twopair.view.window.MainView;
import cn.twopair.view.window.TransferView;

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

public class TransferHandler implements ActionListener {

    private final TransferView transferView;
    private final MainView mainView;

    public TransferHandler(TransferView transferView, MainView mainView) {
        this.transferView = transferView;
        this.mainView = mainView;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String text = button.getText();

        if ("确定".equals(text)) {
            if (Check.isEmpty(transferView.getMoneyText().getText(), transferView.getCardNumberText().getText())) {
                JOptionPane.showMessageDialog(transferView, "请检查是否有缺项未填");
            } else {
                Log log = new Log("", transferView.getCardNumberText().getText(),
                        null, Double.valueOf(transferView.getMoneyText().getText()),
                        "转账", transferView.getSendText().getText(), transferView.getUser());
                if (!Check.checkPassword(transferView.getSendText().getText(), transferView.getCardPasswordText().getText())) {
                    JOptionPane.showMessageDialog(transferView, "密码错误", "ERROR",
                                                    JOptionPane.ERROR_MESSAGE);
                } else {
                    if (DaoUtil.transferMoney(log, transferView.getSendText().getText())) {
                        mainView.reloadTable(mainView.getUser());
                        JOptionPane.showMessageDialog(transferView, "转账成功！");
                    } else {
                        JOptionPane.showMessageDialog(transferView, "转账失败！");
                    }
                }
            }

        } else if ("取消".equals(text)) {
            transferView.dispose();
        }
    }

}
