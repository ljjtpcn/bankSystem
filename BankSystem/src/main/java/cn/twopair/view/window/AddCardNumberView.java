package cn.twopair.view.window;

import cn.twopair.util.BulkImportUtil;
import cn.twopair.util.CheckUtil;
import cn.twopair.util.SetIconUtil;
import cn.twopair.view.handler.AddCardNumberViewHandler;
import cn.twopair.view.handler.special.DateHandler;
import cn.twopair.view.handler.special.MoneyHandler;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * @ClassName AddCardNumberView
 * @Description TODO
 * @Author ljjtpcn
 * @Date 2022/5/31 下午4:25
 * @Version 1.0
 **/

@Getter
@Setter
public class AddCardNumberView extends JDialog {
    //顶部组件
    private JLabel titleLabel;    //创建标题文本域
    private JPanel northJPanel;

    //卡号组件
    private JLabel cardNumberLabel;    //卡号标签
    private JTextField cardNumberText;    //卡号文本框

    //密码组件
    private JLabel cardPasswordLabel;    //密码标签
    private JTextField cardPasswordText;    //密码文本框

    //金额组件
    private JLabel moneyLabel;    //金钱标签。
    private JTextField moneyText;    //金钱文本框
    //日期组件
    private JLabel dateLabel;    //日期标签。
    private JTextField dateText;    //日期文本框

    //底部
    private JButton sureButton;    //确定按钮。
    private JButton cancelButton;    //取消按钮。
    private JPanel centerJPanel;
    private JPanel southJPanel;


    MoneyHandler moneyHandler = new MoneyHandler();
    DateHandler dateHandler = new DateHandler();

    private String user;
    String nowDateString = CheckUtil.getNowDateString();

    public AddCardNumberView(MainView mainView) {

        super(mainView, "存款业务", true);
        AddCardNumberViewHandler addCardNumberViewHandler = new AddCardNumberViewHandler(this, mainView);
        this.user = mainView.getUser();
        Container c = this.getContentPane();

        this.setLayout(new BorderLayout());
        this.setSize(600, 600);//设置大小。
        c.setBackground(Color.WHITE);//设置背景颜色。

        //设置顶部
        northJPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 35));
        titleLabel = new JLabel("开卡业务");
        titleLabel.setFont(new Font("楷书", Font.BOLD, 28));
        northJPanel.setBackground(new Color(81, 171, 211));
        northJPanel.add(titleLabel);
        c.add(northJPanel, BorderLayout.NORTH);

        //设置中间
        //设置JPanel容器
        centerJPanel = new JPanel(null);
        centerJPanel.setBackground(new Color(135, 206, 235));
        //设置单选框
        //设置文字标签


        //创建"卡号"标签
        cardNumberLabel = new JLabel("卡号：");
        SetIconUtil.setIcon(cardNumberLabel, "img/type.png");
        cardNumberLabel.setBounds(90, 30, 140, 40);    //设置"卡号"标签位置。
        cardNumberLabel.setFont(new Font("隶书", Font.BOLD, 20));
        centerJPanel.add(cardNumberLabel);    //添加"卡号"标签。
        //创建"卡号"文本域
        cardNumberText = new JTextField(26);
        cardNumberText.setBounds(175, 30, 260, 40);    //设置"卡号"文本域位置。
        cardNumberText.grabFocus();//获得光标。
        cardNumberText.setEditable(false);
        centerJPanel.add(cardNumberText);    //添加"卡号"文本域。

        //创建"密码"标签
        cardPasswordLabel = new JLabel("密码：");
        SetIconUtil.setIcon(cardPasswordLabel, "img/type.png");
        cardPasswordLabel.setBounds(90, 109, 140, 20);    //设置"密码"标签位置。
        cardPasswordLabel.setFont(new Font("隶书", Font.BOLD, 20));
        centerJPanel.add(cardPasswordLabel);    //添加"类型"标签。
        //创建"密码"文本域
        cardPasswordText = new JTextField(26);
        cardPasswordText.setBounds(175, 105, 260, 30);    //设置"密码"文本域位置。
        cardPasswordText.grabFocus();//获得光标。
        centerJPanel.add(cardPasswordText);    //添加"密码"文本域。

        //创建"金额"标签
        moneyLabel = new JLabel("金额：");
        SetIconUtil.setIcon(moneyLabel, "img/money.png");
        moneyLabel.setBounds(90, 164, 150, 20);
        moneyLabel.setFont(new Font("隶书", Font.BOLD, 20));
        centerJPanel.add(moneyLabel);    //添加"金额"标签。
        //创建"金额"文本域
        moneyText = new JTextField(30);
        moneyText.setBounds(175, 160, 260, 30);
        centerJPanel.add(moneyText);

        //创建"日期"标签
        dateLabel = new JLabel("日期：");
        SetIconUtil.setIcon(dateLabel, "img/date.png");
        dateLabel.setBounds(90, 229, 150, 20);    //设置"日期"标签位置。
        dateLabel.setFont(new Font("隶书", Font.BOLD, 20));
        centerJPanel.add(dateLabel);    //添加"日期"标签。
        //创建"日期"文本域
        dateText = new JTextField(25);
        dateText.setBounds(175, 225, 260, 30);    //设置"日期"文本域位置。
        dateText.setText(nowDateString);
        centerJPanel.add(dateText); //添加"日期"文本域。

        c.add(centerJPanel, BorderLayout.CENTER);

        //底部、创建确定按钮
        southJPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 180, 35));
        sureButton = new JButton("确定");    //创建"注册"按钮
        SetIconUtil.setIcon(sureButton, "img/sure32.png");
        southJPanel.setBackground(new Color(81, 171, 211));
        southJPanel.add(sureButton);
        //创建取消按钮
        cancelButton = new JButton("取消");    //创建"取消"按钮。
        SetIconUtil.setIcon(cancelButton, "img/cancel.png");
        southJPanel.add(cancelButton);
        c.add(southJPanel, BorderLayout.SOUTH);
        sureButton.setContentAreaFilled(false);
        sureButton.setBorderPainted(false);
        cancelButton.setContentAreaFilled(false);
        cancelButton.setBorderPainted(false);
        //统一设置字体
        Font font = new Font("楷体", Font.PLAIN, 20);
        BulkImportUtil.setFont(font, cardNumberText, moneyText, dateText,
                sureButton, cancelButton, cardPasswordText);

        //设置左上角
        URL imgLogo = LoginView.class.getClassLoader().getResource("img/logo2.png");
        assert imgLogo != null;
        Image image = new ImageIcon(imgLogo).getImage();
        setIconImage(image);

        //设置窗口不可拉伸
        setResizable(false);
        getRootPane().setDefaultButton(sureButton);
        //设置监听
        sureButton.addActionListener(addCardNumberViewHandler);
        cancelButton.addActionListener(addCardNumberViewHandler);
        moneyText.addKeyListener(moneyHandler);
        dateText.addKeyListener(dateHandler);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }
}
