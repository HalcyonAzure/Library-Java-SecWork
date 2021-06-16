package top.halc.demo.booklib.Classes;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class ShowMenuOptions extends JFrame {
    /**
     * �����˵���GUI���б༭����
     */
    public ShowMenuOptions() {
        // ���˵��Ŀ��

        setLayout(new BorderLayout());
        JFrame menuFrame = new JFrame("ͼ�����ϵͳ");
        menuFrame.setVisible(false);
        menuFrame.setSize(800, 400);
        menuFrame.setLocation(700, 200);
        // �趨�ر�����Ժ�Ĭ���˳�
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container menuContainer = menuFrame.getContentPane();
        // ��ȡ��ǰ���ڵ����ݴ��񣬲������ô���ĸ�ʽ����
        //GridLayout���񲼾֣����м��С�
        GridLayout gridLayout = new GridLayout(6,1,1,1);
        menuContainer.setLayout(gridLayout);

        // ����һ����������չʾ����ϵͳ����Ϣ
        JPanel menuTitle = new JPanel();
        JLabel loginInTitle = new JLabel("ͼ�����ϵͳ");
        loginInTitle.setFont(new Font("΢���ź�", Font.BOLD, 20));

        // ���������˵����У����������
        menuTitle.add(loginInTitle);
        menuContainer.add(menuTitle);

        // �����û�������
        JPanel userNamePanel = new JPanel();
        JLabel userNameString = new JLabel("�û���");
        //�ڰ���������û�����Ϣ
        userNamePanel.add(userNameString);
        TextField idS = new TextField(20);
        //��������ӵ������ͽ��浱��
        userNamePanel.add(idS);
        menuContainer.add(userNamePanel);

        // �������������棬���û������ͬ��
        JPanel passwdPanel = new JPanel();
        JLabel passwdString = new JLabel("����");
        passwdPanel.add(passwdString);
        // ������Ϊ���������
        JPasswordField passwordS = new JPasswordField(15);
        // ��*�������������
        passwordS.setEchoChar('*');
        // �������
        passwdPanel.add(passwordS);
        menuContainer.add(passwdPanel);

        // ������������
        JPanel loginInPanel = new JPanel();
        JButton loginButton = new JButton("��½");
        loginInPanel.add(loginButton);
        // ����ť�Ӹ��������������ť�л�����
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String adminUser = idS.getText();
                String adminPassword = passwordS.getText();
                // ����Ա���˺������Ϊadmin
                if (adminUser.equals("admin") && adminPassword.equals("admin")) {
                    new Manage();
                } else {
                    new Error();
                    System.out.println("������û�������");
                }
            }
        });

        // �˳���ť
        JButton exit = new JButton("�˳�");
        loginInPanel.add(exit);
        menuContainer.add(loginInPanel);
        exit.addActionListener(new ActionListener() {
            // ����ť�Ӹ��������������ť�رմ���
            @Override
            public void actionPerformed(ActionEvent e) {
                menuFrame.setVisible(false);
                menuFrame.dispose();
                System.exit(0);
            }
        });

        // ���黹�����
        JPanel bookLib = new JPanel();
        JButton logLib = new JButton("�衢�������");
        logLib.addActionListener(new ActionListener() {
            // ����ť�Ӹ��������������ť�л����˿ʹ���
            @Override
            public void actionPerformed(ActionEvent e) {
                new Customer();
            }
        });
        bookLib.add(logLib);
        menuContainer.add(bookLib);

        // ���ڰ�ť
        JPanel aboutLib = new JPanel();
        JButton about = new JButton("����");
        about.addActionListener(new ActionListener() {
            // ����ť�Ӹ��������������ť�л����˿ʹ���
            @Override
            public void actionPerformed(ActionEvent e) {
                new About();
            }
        });
        aboutLib.add(about);
        menuContainer.add(aboutLib);

        menuFrame.pack();
        menuFrame.setVisible(true);
    }
}