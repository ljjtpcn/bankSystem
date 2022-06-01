package cn.twopair.view.window;

import cn.twopair.util.BulkImportUtil;
import cn.twopair.util.SetIconUtil;
import cn.twopair.view.handler.ModifyPasswordViewHandler;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * @ClassName ModifyPasswordView
 * @Description TODO
 * @Author ljjtpcn
 * @Date 2022/5/31 下午5:18
 * @Version 1.0
 **/

@Setter
@Getter
public class ModifyPasswordView extends JDialog {
    //顶部组件
    private JLabel titleLabel;    //创建标题文本域
    private JPanel northJPanel;

    //密码组件
    private JLabel userPasswordLabel;    //密码标签
    private JTextField userPasswordText;    //密码文本框

    //底部
    private JButton sureButton;    //确定按钮。
    private JButton cancelButton;    //取消按钮。
    private JPanel centerJPanel;
    private JPanel southJPanel;

    private String user;

    public ModifyPasswordView(MainView mainView) {

        super(mainView, "用户密码修改", true);
        ModifyPasswordViewHandler modifyPasswordViewHandler = new ModifyPasswordViewHandler(this, mainView);
        this.user = mainView.getUser();
        Container c = this.getContentPane();

        this.setLayout(new BorderLayout());
        this.setSize(600, 600);//设置大小。
        c.setBackground(Color.WHITE);//设置背景颜色。

        //设置顶部
        northJPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 35));
        titleLabel = new JLabel("用户密码修改");
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


        //创建"密码"标签
        userPasswordLabel = new JLabel("新密码：");
        SetIconUtil.setIcon(userPasswordLabel, "img/type.png");
        userPasswordLabel.setBounds(90, 109, 140, 20);    //设置"密码"标签位置。
        userPasswordLabel.setFont(new Font("隶书", Font.BOLD, 20));
        centerJPanel.add(userPasswordLabel);    //添加"类型"标签。
        //创建"密码"文本域
        userPasswordText = new JTextField(26);
        userPasswordText.setBounds(175, 105, 260, 30);    //设置"密码"文本域位置。
        userPasswordText.grabFocus();//获得光标。
        centerJPanel.add(userPasswordText);    //添加"密码"文本域。


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
        BulkImportUtil.setFont(font, sureButton, cancelButton, userPasswordText);

        //设置左上角
        URL imgLogo = LoginView.class.getClassLoader().getResource("img/logo2.png");
        assert imgLogo != null;
        Image image = new ImageIcon(imgLogo).getImage();
        setIconImage(image);

        //设置窗口不可拉伸
        setResizable(false);
        getRootPane().setDefaultButton(sureButton);
        //设置监听
        sureButton.addActionListener(modifyPasswordViewHandler);
        cancelButton.addActionListener(modifyPasswordViewHandler);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
