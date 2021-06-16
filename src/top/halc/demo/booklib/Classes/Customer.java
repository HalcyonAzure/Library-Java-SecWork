package top.halc.demo.booklib.Classes;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;

public class Customer{
	public Customer() {
		// 创建用户界面的框架
		JFrame customer=new JFrame("用户界面");
			customer.setVisible(true);//窗口可见
			customer.setSize(600,400);
			customer.setLocation(900, 200);

		// 生成容器并且添加对应的组件
		Container customerCon=customer.getContentPane();
		// 生成容器添加组件
		GridLayout gridLayout = new GridLayout(5,1,2,2);
		// GridLayout网格布局，几行几列。
		customerCon.setLayout(gridLayout);
		//最开始的标题头，设定为最上面
		JLabel title=new JLabel("欢迎光临");
			title.setFont(new Font("微软雅黑",Font.BOLD, 20));
			title.setSize(40,20);
			customerCon.add(title);
		//添加组件

		JButton bookLib=new JButton("书库");
//		JLabel bookPanel = new JLabel(bookLib);
		bookLib.addActionListener(new ActionListener(){//给按钮加个监听器，点击按钮切换到读者界面
			public void actionPerformed(ActionEvent e){
				try {
					new BookLibrary();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
		}});

		JButton exitButtion=new JButton("退出");
		exitButtion.addActionListener(new ActionListener(){//给按钮加个监听器，点击按钮关闭窗口
			public void actionPerformed(ActionEvent e){
				customer.setVisible(false);
		        customer.dispose();
		        System.exit(0);
		}});
		JLabel nameSearch=new JLabel("书名查询");
		TextField bookName=new TextField(20);
		JButton search=new JButton("搜索");
		JLabel orderSearch=new JLabel("序号查询");
		TextField bh=new TextField(20);
		JButton otherSearch=new JButton("搜索");

		customerCon.add(exitButtion);
		customerCon.add(title);
		customerCon.add(nameSearch);
		customerCon.add(bookName);
		customerCon.add(search);
		customerCon.add(orderSearch);
		customerCon.add(bh);
		customerCon.add(otherSearch);
	}
}