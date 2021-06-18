package top.halc.demo.booklib.Classes;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class Manage{
	public Manage() {
		JFrame manageSystem=new JFrame("����ϵͳ");
		manageSystem.setVisible(true);
		// ���ڿɼ�
		manageSystem.setSize(300,300);
		manageSystem.setLocation(900, 200);


		Container manageCon=manageSystem.getContentPane();
		// ����һ������׼��������
		manageCon.setLayout(new GridLayout(6,2));
		// GridLayoutʵ�����񲼾� ���м��С�

		// ͼ��������ʾ����
		JPanel title = new JPanel();
		JLabel libTitle=new JLabel("ͼ�����");
		title.add(libTitle);
		manageCon.add(title);

		// ����ϵͳ���ݲ鿴��ť
		JPanel infoShow = new JPanel();
		JButton borrowShow = new JButton("����鼮");
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

		// �����Ϣ�鿴
		JButton userShow = new JButton("ɾ���鼮");
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
		JButton libButton=new JButton("���");
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