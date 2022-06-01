package cn.twopair.view.window;


import cn.twopair.dao.DaoUtil;
import cn.twopair.res.TableDTO;
import cn.twopair.util.BulkImportUtil;
import cn.twopair.util.DimensionUtil;
import cn.twopair.util.SetIconUtil;
import cn.twopair.view.handler.MainViewHandler;
import cn.twopair.view.window.table.MainViewTable;
import cn.twopair.view.window.table.MainViewTableModel;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * @description:
 * @author: 李佳骏
 * @date: 2021-12-12 9:35
 * @version: 1.0
 * @email: ljjtpcn@163.com
 */
@Getter
@Setter
public class MainView extends JFrame {

    JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 25));
    JButton openCardButton = new JButton("开卡业务");
    JButton modifyUserPasswordButton = new JButton("用户密码修改");
    //JButton statisticsButton = new JButton("统计查询");
    JButton searchButton = new JButton("卡号交易信息查询");
    JButton saveButton = new JButton("存款业务");
    JButton transferButton = new JButton("转账业务");
    JButton withdrawalButton = new JButton("取款业务");

    JTextField searchTextField = new JTextField(20);
    MainViewTable mainViewTable = new MainViewTable();

    //当前页
    private int pageNow = 1;
    //每页显示行数
    private int pageSize = 10;
    //当前用户名,方便查询对应收支记录
    private String user;


    MainViewHandler mainViewHandler;

    public MainView(String user) {
        super("银行理财系统");
        this.user = user;
        Container root = getContentPane();
        Rectangle bounds = DimensionUtil.getBounds();
        pageSize = Math.floorDiv(bounds.height, 50);
        //监听器
        mainViewHandler = new MainViewHandler(this);

        layoutNorth(root);
        layoutCenter(root, user);
        layoutSouth(root);


        //设置图标
        URL imgUrl = LoginView.class.getClassLoader().getResource("img/logo.png");
        assert imgUrl != null;
        setIconImage(new ImageIcon(imgUrl).getImage());
        //根据屏幕大小设置主界面大小
        setBounds(bounds);
        //设置窗体完全充满整个屏幕的可见大小
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        extracted();
        setResizable(true);
        setVisible(true);
    }

    private void extracted() {
        openCardButton.setContentAreaFilled(false);
        openCardButton.setBorderPainted(false);
        modifyUserPasswordButton.setContentAreaFilled(false);
        modifyUserPasswordButton.setBorderPainted(false);
        searchButton.setContentAreaFilled(false);
        searchButton.setBorderPainted(false);
        //statisticsButton.setContentAreaFilled(false);
        //statisticsButton.setBorderPainted(false);
        saveButton.setContentAreaFilled(false);
        saveButton.setBorderPainted(false);
        transferButton.setContentAreaFilled(false);
        transferButton.setBorderPainted(false);
        withdrawalButton.setContentAreaFilled(false);
        withdrawalButton.setBorderPainted(false);
    }

    private void layoutNorth(Container root) {


        searchButton.addActionListener(mainViewHandler);

        BulkImportUtil.add(northPanel, saveButton, withdrawalButton, transferButton,
                searchTextField, searchButton,
                openCardButton, modifyUserPasswordButton);

        //图标
        SetIconUtil.setIcon(saveButton, "img/add.png");
        SetIconUtil.setIcon(withdrawalButton, "img/modify.png");
        SetIconUtil.setIcon(transferButton, "img/delete.png");
        SetIconUtil.setIcon(searchButton, "img/search.png");
        SetIconUtil.setIcon(openCardButton, "img/income.png");
        SetIconUtil.setIcon(modifyUserPasswordButton, "img/expend.png");
        //SetIconUtil.setIcon(statisticsButton, "img/statistics.png");

        //字体
        Font font = new Font("楷体", Font.BOLD, 20);
        BulkImportUtil.setFont(font, saveButton, withdrawalButton, transferButton,
                searchButton,
                openCardButton, modifyUserPasswordButton);
        searchTextField.setFont(new Font("楷体", Font.BOLD, 25));

        //增删改查监听
        saveButton.addActionListener(mainViewHandler);
        transferButton.addActionListener(mainViewHandler);
        withdrawalButton.addActionListener(mainViewHandler);
        openCardButton.addActionListener(mainViewHandler);
        modifyUserPasswordButton.addActionListener(mainViewHandler);
        //statisticsButton.addActionListener(mainViewHandler);

        //设置回车默认button
        getRootPane().setDefaultButton(searchButton);

        root.add(northPanel, BorderLayout.NORTH);

    }

    private void layoutCenter(Container root, String user) {
        TableDTO tableDTO = getVectors(user);
        MainViewTableModel mainViewTableModel = MainViewTableModel.assembleModel(tableDTO.getData());

        //JTable关联model
        mainViewTable.setModel(mainViewTableModel);
        //设置表格渲染方式
        mainViewTable.renderRuler();
        JScrollPane jScrollPane = new JScrollPane(mainViewTable);
        root.add(jScrollPane, BorderLayout.CENTER);
    }


    private TableDTO getVectors(String user) {
        return DaoUtil.getTableDataByIdNumber(user);
    }

    private TableDTO getVectors(String user, String cardNumber) {
        System.out.println(45444444);
        return DaoUtil.getTableDataByCardNumber(user, cardNumber);
    }

    private void layoutSouth(Container root) {
        BulkImportUtil.add(southPanel);
        root.add(southPanel, BorderLayout.SOUTH);
    }


    //刷新查询
    public void reloadTable(String user) {
        TableDTO dto = getVectors(user);
        MainViewTableModel.updateModel(dto.getData());
        mainViewTable.renderRuler();
    }

    public void reloadTable(String user, String cardNumber) {
        System.out.println("33333333333333");
        TableDTO dto = getVectors(user, cardNumber);
        MainViewTableModel.updateModel(dto.getData());
        mainViewTable.renderRuler();
    }

}
