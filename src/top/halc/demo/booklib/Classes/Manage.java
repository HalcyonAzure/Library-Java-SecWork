package top.halc.demo.booklib.Classes;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
public class Manage{
	public Manage() {
		JFrame f=new JFrame("管理系统");
		f.setVisible(true);//窗口可见
		f.setSize(300,400);
		f.setLocation(900, 200);
		Container con1=f.getContentPane();//生成一个容器	,才能添加组件
		con1.setLayout(new GridLayout(7,1));//GridLayout实现网格布局 几行几列。
		JButton b1=new JButton("图书管理");
		JButton b2=new JButton("借阅数据查看");
		JButton b3=new JButton("租借信息查看");
		JButton b4=new JButton("书库");
		con1.add(b1);
		con1.add(b2);
		con1.add(b3);
		con1.add(b4);
		b1.addActionListener(new ActionListener(){//给按钮加个监听器，点击按钮关闭窗口
			public void actionPerformed(ActionEvent e){
				new Bookmanager();
		}});
		b2.addActionListener(new ActionListener(){//给按钮加个监听器，点击按钮关闭窗口
			public void actionPerformed(ActionEvent e){
				new Analysis();
		}});
		b3.addActionListener(new ActionListener(){//给按钮加个监听器，点击按钮关闭窗口
			public void actionPerformed(ActionEvent e){
				new Customer_Information();
		}});
		b4.addActionListener(new ActionListener(){//给按钮加个监听器，点击按钮关闭窗口
			public void actionPerformed(ActionEvent e){
				try {
					new BookLibrary();
				}
				catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
		}});
	}
}