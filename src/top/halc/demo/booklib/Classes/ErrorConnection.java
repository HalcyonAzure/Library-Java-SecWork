package top.halc.demo.booklib.Classes;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

public class ErrorConnection{
    public ErrorConnection() {
        JFrame errorInfo=new JFrame("��ʾ");
        errorInfo.setVisible(true);//���ڿɼ�
        errorInfo.setSize(300,300);
        errorInfo.setLocation(600, 200);
        JPanel center = new JPanel();
        Container con1=errorInfo.getContentPane();//��������������
        con1.setLayout(new GridLayout(6,4));//GridLayout���񲼾֣����м���
        JLabel title=new JLabel("���ݿ�����ʧ�ܣ�");
        title.setFont(new Font("΢���ź�",Font.BOLD, 20));
        center.add(title);
        con1.add(center);

    }
}