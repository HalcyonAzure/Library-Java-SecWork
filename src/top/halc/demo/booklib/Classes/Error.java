package top.halc.demo.booklib.Classes;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Error{
	public Error() {
		JFrame f=new JFrame("��ʾ");
		f.setVisible(true);//���ڿɼ�
		f.setSize(300,200);
		f.setLocation(600, 200);
		Container con1=f.getContentPane();//��������������
		con1.setLayout(new GridLayout(6,1));//GridLayout���񲼾֣����м���
		JLabel title=new JLabel("������û����������!");
		title.setFont(new Font("����",Font.BOLD, 20));
		con1.add(title);
	}
}