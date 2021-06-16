package top.halc.demo.booklib.Classes;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;

public class Customer{
	public Customer() {
		// �����û�����Ŀ��
		JFrame customer=new JFrame("�û�����");
			customer.setVisible(true);//���ڿɼ�
			customer.setSize(600,400);
			customer.setLocation(900, 200);

		// ��������������Ӷ�Ӧ�����
		Container customerCon=customer.getContentPane();
		// ��������������
		GridLayout gridLayout = new GridLayout(5,1,2,2);
		// GridLayout���񲼾֣����м��С�
		customerCon.setLayout(gridLayout);
		//�ʼ�ı���ͷ���趨Ϊ������
		JLabel title=new JLabel("��ӭ����");
			title.setFont(new Font("΢���ź�",Font.BOLD, 20));
			title.setSize(40,20);
			customerCon.add(title);
		//������

		JButton bookLib=new JButton("���");
//		JLabel bookPanel = new JLabel(bookLib);
		bookLib.addActionListener(new ActionListener(){//����ť�Ӹ��������������ť�л������߽���
			public void actionPerformed(ActionEvent e){
				try {
					new BookLibrary();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
		}});

		JButton exitButtion=new JButton("�˳�");
		exitButtion.addActionListener(new ActionListener(){//����ť�Ӹ��������������ť�رմ���
			public void actionPerformed(ActionEvent e){
				customer.setVisible(false);
		        customer.dispose();
		        System.exit(0);
		}});
		JLabel nameSearch=new JLabel("������ѯ");
		TextField bookName=new TextField(20);
		JButton search=new JButton("����");
		JLabel orderSearch=new JLabel("��Ų�ѯ");
		TextField bh=new TextField(20);
		JButton otherSearch=new JButton("����");

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