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
		JFrame f=new JFrame("�鼮�������");
		f.setVisible(true);
		f.setSize(600,700);
		f.setLocation(1000, 200);
		Container con1=f.getContentPane();//��������������
		con1.setLayout(new GridLayout(6,1));//GridLayout���񲼾֣����м���
		JLabel title=new JLabel("�������в���");
		title.setFont(new Font("����",Font.BOLD, 20));
		JButton b1=new JButton("����鼮");
		b1.addActionListener(new ActionListener(){//����ť�Ӹ��������������ť�رմ���
			public void actionPerformed(ActionEvent e){
				try {
					new Addbook();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
		}});
		JButton b2=new JButton("ɾ���鼮");
		b2.addActionListener(new ActionListener(){//����ť�Ӹ��������������ť�رմ���
			public void actionPerformed(ActionEvent e){
				try {
					new Deletebook();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
		}});
		JButton b3=new JButton("���");
		b3.addActionListener(new ActionListener(){//����ť�Ӹ��������������ť�رմ���
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