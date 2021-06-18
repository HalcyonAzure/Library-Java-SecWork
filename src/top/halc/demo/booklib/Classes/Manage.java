package top.halc.demo.booklib.Classes;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class Manage{
	public Manage() {
		JFrame manageSystem=new JFrame("管理系统");
		manageSystem.setVisible(true);
		// 窗口可见
		manageSystem.setSize(300,300);
		manageSystem.setLocation(900, 200);


		Container manageCon=manageSystem.getContentPane();
		// 生成一个容器准备添加组件
		manageCon.setLayout(new GridLayout(6,2));
		// GridLayout实现网格布局 几行几列。

		// 图书管理的显示界面
		JPanel title = new JPanel();
		JLabel libTitle=new JLabel("图书管理");
		title.add(libTitle);
		manageCon.add(title);

		// 借阅系统数据查看按钮
		JPanel infoShow = new JPanel();
		JButton borrowShow = new JButton("添加书籍");
		borrowShow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new AddBook();
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				} catch (ClassNotFoundException classNotFoundException) {
					classNotFoundException.printStackTrace();
				}
			}
		});
		infoShow.add(borrowShow);

		// 租借信息查看
		JButton userShow = new JButton("删除书籍");
		userShow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new DeleteBook();
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				} catch (ClassNotFoundException classNotFoundException) {
					classNotFoundException.printStackTrace();
				}
			}
		});
		infoShow.add(userShow);

		manageCon.add(infoShow);

		JPanel libSearch = new JPanel();
		JButton libButton=new JButton("书库");
		libButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new BookLibrary();
				}
				catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		libSearch.add(libButton);
		manageCon.add(libSearch);
	}
}