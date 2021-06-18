package top.halc.demo.booklib.Classes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;

public class Customer {
    public Customer() {
        // 创建用户界面的框架
        JFrame customer = new JFrame("用户界面");
        customer.setVisible(true);//窗口可见
        customer.setSize(420, 250);
        customer.setLocation(900, 200);

        // 生成容器并且添加对应的组件
        Container customerCon = customer.getContentPane();
        // 生成容器添加组件
        GridLayout gridLayout = new GridLayout(6, 1, 2, 2);
        // GridLayout网格布局，几行几列。
        customerCon.setLayout(gridLayout);
        // 最开始的标题头，设定为最上面
        JPanel titlePanel = new JPanel();
        JLabel title = new JLabel("欢迎光临");
        title.setFont(new Font("微软雅黑", Font.BOLD, 20));
        title.setSize(40, 20);
        titlePanel.add(title);
        customerCon.add(titlePanel);


        // 添加两个框，一个是搜索书本，一个是搜索用户
        // 书本的Panel
        JPanel bookSearchPanel = new JPanel();
        JButton bookSearch = new JButton("书本搜索");
        bookSearchPanel.add(bookSearch);
        TextField bookName = new TextField(20);
        bookSearchPanel.add(bookName);
        customerCon.add(bookSearchPanel);

        // 用户的Panel
        JPanel userSearchPanel = new JPanel();
        JButton userSearch = new JButton("用户搜索");
        userSearchPanel.add(userSearch);
        TextField userName = new TextField(20);
        userSearchPanel.add(userName);
        customerCon.add(userSearchPanel);

        // 添加书库的按钮，打开以后直接查阅书籍，和退出共用同一个bookPanel
        JPanel bookPanel = new JPanel();
        JButton bookLib = new JButton("书库");
        bookPanel.add(bookLib);
        bookLib.addActionListener(new ActionListener() {//给按钮加个监听器，点击按钮切换到读者界面
            public void actionPerformed(ActionEvent e) {
                try {
                    new BookLibrary();
                } catch (ClassNotFoundException | SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        // 退出的按钮，按了以后回退上一个界面
        JButton exitButton = new JButton("退出");
        bookPanel.add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            // 给按钮加个监听器，点击按钮关闭窗口
            public void actionPerformed(ActionEvent e) {
                customer.setVisible(false);
                customer.dispose();
                System.exit(0);
            }
        });
        customerCon.add(bookPanel);


//		JLabel nameSearch=new JLabel("书名查询");
//		TextField bookName=new TextField(20);
//		JButton search=new JButton("搜索");
//		JLabel orderSearch=new JLabel("序号查询");
//		TextField bh=new TextField(20);
//		JButton otherSearch=new JButton("搜索");


    }
}