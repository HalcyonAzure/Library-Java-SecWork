package top.halc.demo.booklib.Classes;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Error{
	public Error() {
		JFrame errorInfo=new JFrame("��ʾ");
		errorInfo.setVisible(true);//���ڿɼ�
		errorInfo.setSize(300,200);
		errorInfo.setLocation(600, 200);
		Container con1=errorInfo.getContentPane();//��������������
		con1.setLayout(new GridLayout(6,1));//GridLayout���񲼾֣����м���
		JLabel title=new JLabel("������û����������!");
		title.setFont(new Font("΢���ź�",Font.BOLD, 20));
		con1.add(title);
	}
}