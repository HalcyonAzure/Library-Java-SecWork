package top.halc.demo.booklib.Classes;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class ShowMenuOptions extends JFrame {
    /**
     * 对主菜单的GUI进行编辑操作
     */
    public ShowMenuOptions() {
        // 主菜单的框架

        setLayout(new BorderLayout());
        JFrame menuFrame = new JFrame("图书管理系统");
        menuFrame.setVisible(false);
        menuFrame.setSize(800, 400);
        menuFrame.setLocation(700, 200);
        // 设定关闭软件以后默认退出
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container menuContainer = menuFrame.getContentPane();
        // 获取当前窗口的内容窗格，并且设置窗格的格式内容
        //GridLayout网格布局，几行几列。
        GridLayout gridLayout = new GridLayout(6,1,1,1);
        menuContainer.setLayout(gridLayout);

        // 创建一个版面用于展示登入系统的信息
        JPanel menuTitle = new JPanel();
        JLabel loginInTitle = new JLabel("图书管理系统");
        loginInTitle.setFont(new Font("微软雅黑", Font.BOLD, 20));

        // 将版面加入菜单当中，并填充容器
        menuTitle.add(loginInTitle);
        menuContainer.add(menuTitle);

        // 生成用户名版面
        JPanel userNamePanel = new JPanel();
        JLabel userNameString = new JLabel("用户名");
        //在版面内添加用户名信息
        userNamePanel.add(userNameString);
        TextField idS = new TextField(20);
        //将版面添加到容器和界面当中
        userNamePanel.add(idS);
        menuContainer.add(userNamePanel);

        // 生成密码填充版面，和用户名面板同理
        JPanel passwdPanel = new JPanel();
        JLabel passwdString = new JLabel("密码");
        passwdPanel.add(passwdString);
        // 创建的为密码输入框
        JPasswordField passwordS = new JPasswordField(15);
        // 用*代替输入的密码
        passwordS.setEchoChar('*');
        // 添加内容
        passwdPanel.add(passwordS);
        menuContainer.add(passwdPanel);

        // 创建登入容器
        JPanel loginInPanel = new JPanel();
        JButton loginButton = new JButton("登陆");
        loginInPanel.add(loginButton);
        // 给按钮加个监听器，点击按钮切换窗口
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String adminUser = idS.getText();
                String adminPassword = passwordS.getText();
                // 管理员的账号密码均为admin
                if (adminUser.equals("admin") && adminPassword.equals("admin")) {
                    new Manage();
                } else {
                    new Error();
                    System.out.println("密码或用户名错误");
                }
            }
        });

        // 退出按钮
        JButton exit = new JButton("退出");
        loginInPanel.add(exit);
        menuContainer.add(loginInPanel);
        exit.addActionListener(new ActionListener() {
            // 给按钮加个监听器，点击按钮关闭窗口
            @Override
            public void actionPerformed(ActionEvent e) {
                menuFrame.setVisible(false);
                menuFrame.dispose();
                System.exit(0);
            }
        });

        // 借书还书界面
        JPanel bookLib = new JPanel();
        JButton logLib = new JButton("借、还书界面");
        logLib.addActionListener(new ActionListener() {
            // 给按钮加个监听器，点击按钮切换到顾客窗口
            @Override
            public void actionPerformed(ActionEvent e) {
                new Customer();
            }
        });
        bookLib.add(logLib);
        menuContainer.add(bookLib);

        // 关于按钮
        JPanel aboutLib = new JPanel();
        JButton about = new JButton("关于");
        about.addActionListener(new ActionListener() {
            // 给按钮加个监听器，点击按钮切换到顾客窗口
            @Override
            public void actionPerformed(ActionEvent e) {
                new About();
            }
        });
        aboutLib.add(about);
        menuContainer.add(aboutLib);

        menuFrame.pack();
        menuFrame.setVisible(true);
    }
}