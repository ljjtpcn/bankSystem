package cn.twopair.view.handler;


import cn.twopair.dao.DaoUtil;
import cn.twopair.pojo.Log;
import cn.twopair.util.Check;
import cn.twopair.view.window.AddView;
import cn.twopair.view.window.MainView;

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

public class AddHandler implements ActionListener {

    private final AddView addView;
    private final MainView mainView;

    public AddHandler(AddView addView, MainView mainView) {
        this.addView = addView;
        this.mainView = mainView;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String text = button.getText();

        if ("确定".equals(text)) {
            if (Check.isEmpty(addView.getMoneyText().getText(), addView.getCardNumberText().getText())) {
                JOptionPane.showMessageDialog(addView, "请检查是否有缺项未填");
            } else {
                Log log = new Log("", addView.getCardNumberText().getText(),
                        null, Double.valueOf(addView.getMoneyText().getText()),
                        "存入", addView.getRemarkText().getText(), addView.getUser());
                if (!Check.checkPassword(log.getCardNumber(), addView.getCardPasswordText().getText())) {
                    JOptionPane.showMessageDialog(addView, "密码错误", "ERROR",
                                                    JOptionPane.ERROR_MESSAGE);
                } else {
                    if (DaoUtil.saveMoney(log)) {
                        mainView.reloadTable(mainView.getUser());
                        JOptionPane.showMessageDialog(addView, "存款成功！");
                    } else {
                        JOptionPane.showMessageDialog(addView, "存款失败！");
                    }
                }
            }

        } else if ("取消".equals(text)) {
            addView.dispose();
        }
    }

}
