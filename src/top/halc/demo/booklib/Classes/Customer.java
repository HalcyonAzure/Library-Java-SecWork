package top.halc.demo.booklib.Classes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;

public class Customer {
    public Customer() {
        // �����û�����Ŀ��
        JFrame customer = new JFrame("�û�����");
        customer.setVisible(true);//���ڿɼ�
        customer.setSize(420, 250);
        customer.setLocation(900, 200);

        // ��������������Ӷ�Ӧ�����
        Container customerCon = customer.getContentPane();
        // ��������������
        GridLayout gridLayout = new GridLayout(6, 1, 2, 2);
        // GridLayout���񲼾֣����м��С�
        customerCon.setLayout(gridLayout);
        // �ʼ�ı���ͷ���趨Ϊ������
        JPanel titlePanel = new JPanel();
        JLabel title = new JLabel("��ӭ����");
        title.setFont(new Font("΢���ź�", Font.BOLD, 20));
        title.setSize(40, 20);
        titlePanel.add(title);
        customerCon.add(titlePanel);


        // ���������һ���������鱾��һ���������û�
        // �鱾��Panel
        JPanel bookSearchPanel = new JPanel();
        JButton bookSearch = new JButton("�鱾����");
        bookSearchPanel.add(bookSearch);
        TextField bookName = new TextField(20);
        bookSearchPanel.add(bookName);
        customerCon.add(bookSearchPanel);

        // �û���Panel
        JPanel userSearchPanel = new JPanel();
        JButton userSearch = new JButton("�û�����");
        userSearchPanel.add(userSearch);
        TextField userName = new TextField(20);
        userSearchPanel.add(userName);
        customerCon.add(userSearchPanel);

        // ������İ�ť�����Ժ�ֱ�Ӳ����鼮�����˳�����ͬһ��bookPanel
        JPanel bookPanel = new JPanel();
        JButton bookLib = new JButton("���");
        bookPanel.add(bookLib);
        bookLib.addActionListener(new ActionListener() {//����ť�Ӹ��������������ť�л������߽���
            public void actionPerformed(ActionEvent e) {
                try {
                    new BookLibrary();
                } catch (ClassNotFoundException | SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        // �˳��İ�ť�������Ժ������һ������
        JButton exitButton = new JButton("�˳�");
        bookPanel.add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            // ����ť�Ӹ��������������ť�رմ���
            public void actionPerformed(ActionEvent e) {
                customer.setVisible(false);
                customer.dispose();
                System.exit(0);
            }
        });
        customerCon.add(bookPanel);


//		JLabel nameSearch=new JLabel("������ѯ");
//		TextField bookName=new TextField(20);
//		JButton search=new JButton("����");
//		JLabel orderSearch=new JLabel("��Ų�ѯ");
//		TextField bh=new TextField(20);
//		JButton otherSearch=new JButton("����");


    }
}