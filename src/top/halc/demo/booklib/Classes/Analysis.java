package top.halc.demo.booklib.Classes;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 用于显示结束类型分析的GUI
 */
public class Analysis{
	public Analysis() {
		JFrame analysis=new JFrame("借阅数据统计界面");
		analysis.setVisible(true);
		analysis.setSize(600,700);
		analysis.setLocation(700, 200);
		Container con1=analysis.getContentPane();
		con1.setLayout(new GridLayout(6,1));
		JLabel title1=new JLabel("借出最多的书的类型：");
		JLabel title2=new JLabel("男生最喜欢的书的类型：");
		JLabel title3=new JLabel("女生最喜欢的书的类型：");
		JLabel title4=new JLabel("本月收益：");
		con1.add(title1);
		con1.add(title2);
		con1.add(title3);
		con1.add(title4);
	}
}