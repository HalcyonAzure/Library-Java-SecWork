package top.halc.demo.booklib.Classes;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * ������ʾ�������ͷ�����GUI
 */
public class Analysis{
	public Analysis() {
		JFrame analysis=new JFrame("��������ͳ�ƽ���");
		analysis.setVisible(true);
		analysis.setSize(600,700);
		analysis.setLocation(700, 200);
		Container con1=analysis.getContentPane();
		con1.setLayout(new GridLayout(6,1));
		JLabel title1=new JLabel("�������������ͣ�");
		JLabel title2=new JLabel("������ϲ����������ͣ�");
		JLabel title3=new JLabel("Ů����ϲ����������ͣ�");
		JLabel title4=new JLabel("�������棺");
		con1.add(title1);
		con1.add(title2);
		con1.add(title3);
		con1.add(title4);
	}
}