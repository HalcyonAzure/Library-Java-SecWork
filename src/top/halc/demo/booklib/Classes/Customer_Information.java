package top.halc.demo.booklib.Classes;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JFrame;

public class Customer_Information{
	public Customer_Information() {
		JFrame f=new JFrame("������Ϣ�������");
		f.setVisible(true);
		f.setSize(600,300);
		f.setLocation(1000, 200);
		Container con1=f.getContentPane();//��������������
		con1.setLayout(new GridLayout(6,1));//GridLayout���񲼾֣����м���
	}
}