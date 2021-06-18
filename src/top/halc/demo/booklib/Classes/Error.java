package top.halc.demo.booklib.Classes;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Error{
	public Error() {
		JFrame errorInfo=new JFrame("提示");
		errorInfo.setVisible(true);//窗口可见
		errorInfo.setSize(300,200);
		errorInfo.setLocation(600, 200);
		Container con1=errorInfo.getContentPane();//生成容器添加组件
		con1.setLayout(new GridLayout(6,1));//GridLayout网格布局，几行几列
		JLabel title=new JLabel("密码或用户名输入错误!");
		title.setFont(new Font("微软雅黑",Font.BOLD, 20));
		con1.add(title);
	}
}