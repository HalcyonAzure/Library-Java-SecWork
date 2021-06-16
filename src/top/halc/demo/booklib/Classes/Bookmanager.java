package top.halc.demo.booklib.Classes;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Bookmanager{
	public Bookmanager() {
		JFrame f=new JFrame("书籍管理界面");
		f.setVisible(true);
		f.setSize(600,700);
		f.setLocation(1000, 200);
		Container con1=f.getContentPane();//生成容器添加组件
		con1.setLayout(new GridLayout(6,1));//GridLayout网格布局，几行几列
		JLabel title=new JLabel("对书库进行操作");
		title.setFont(new Font("宋体",Font.BOLD, 20));
		JButton b1=new JButton("添加书籍");
		b1.addActionListener(new ActionListener(){//给按钮加个监听器，点击按钮关闭窗口
			public void actionPerformed(ActionEvent e){
				try {
					new Addbook();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
		}});
		JButton b2=new JButton("删除书籍");
		b2.addActionListener(new ActionListener(){//给按钮加个监听器，点击按钮关闭窗口
			public void actionPerformed(ActionEvent e){
				try {
					new Deletebook();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
		}});
		JButton b3=new JButton("书库");
		b3.addActionListener(new ActionListener(){//给按钮加个监听器，点击按钮关闭窗口
			public void actionPerformed(ActionEvent e){
				try {
					new BookLibrary();
				}
				catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
		}});
		con1.add(title);
		con1.add(b1);
		con1.add(b2);
		con1.add(b3);
	}
}