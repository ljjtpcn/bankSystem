package cn.twopair.view.handler;


import cn.twopair.dao.DaoUtil;
import cn.twopair.util.Check;
import cn.twopair.view.window.AddCardNumberView;
import cn.twopair.view.window.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * @description:
 * @author: 李佳骏
 * @date: 2021-12-11 16:52
 * @version: 1.0
 * @email: ljjtpcn@163.com
 */

public class AddCardNumberViewHandler implements ActionListener {

    private final AddCardNumberView addCardNumberView;
    private final MainView mainView;

    public AddCardNumberViewHandler(AddCardNumberView addCardNumberView, MainView mainView) {
        this.addCardNumberView = addCardNumberView;
        this.mainView = mainView;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String text = button.getText();

        if ("确定".equals(text)) {
            if (Check.isEmpty(addCardNumberView.getMoneyText().getText())) {
                JOptionPane.showMessageDialog(addCardNumberView, "请检查是否有缺项未填");
            } else {
                HashMap<String, Object> res = DaoUtil.openCard(mainView.getUser(), addCardNumberView.getCardPasswordText().getText(), addCardNumberView.getMoneyText().getText());
                if ((int)res.get("flag") != 0) {
                    mainView.reloadTable(mainView.getUser());
                    addCardNumberView.getCardNumberText().setText(String.valueOf(res.get("cardNumber")));
                    JOptionPane.showMessageDialog(addCardNumberView, "开卡成功！");
                } else {
                    JOptionPane.showMessageDialog(addCardNumberView, "开卡失败！, 卡超过三张");
                }
            }

        } else if ("取消".equals(text)) {
            addCardNumberView.dispose();
        }
    }

}
