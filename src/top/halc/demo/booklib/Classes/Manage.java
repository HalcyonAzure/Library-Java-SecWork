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
		JFrame f=new JFrame("����ϵͳ");
		f.setVisible(true);//���ڿɼ�
		f.setSize(300,400);
		f.setLocation(900, 200);
		Container con1=f.getContentPane();//����һ������	,����������
		con1.setLayout(new GridLayout(7,1));//GridLayoutʵ�����񲼾� ���м��С�
		JButton b1=new JButton("ͼ�����");
		JButton b2=new JButton("�������ݲ鿴");
		JButton b3=new JButton("�����Ϣ�鿴");
		JButton b4=new JButton("���");
		con1.add(b1);
		con1.add(b2);
		con1.add(b3);
		con1.add(b4);
		b1.addActionListener(new ActionListener(){//����ť�Ӹ��������������ť�رմ���
			public void actionPerformed(ActionEvent e){
				new Bookmanager();
		}});
		b2.addActionListener(new ActionListener(){//����ť�Ӹ��������������ť�رմ���
			public void actionPerformed(ActionEvent e){
				new Analysis();
		}});
		b3.addActionListener(new ActionListener(){//����ť�Ӹ��������������ť�رմ���
			public void actionPerformed(ActionEvent e){
				new Customer_Information();
		}});
		b4.addActionListener(new ActionListener(){//����ť�Ӹ��������������ť�رմ���
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