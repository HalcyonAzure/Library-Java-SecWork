package top.halc.demo.booklib.Classes;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class DeleteBook {
	public DeleteBook() throws SQLException, ClassNotFoundException {
		JFrame f=new JFrame("删除书本");
		f.setVisible(true);
		f.setSize(400,100);
		f.setLocation(400, 200);
		Container con1=f.getContentPane();
		con1.setLayout(new GridLayout(1,1));
		JPanel pan1=new JPanel();
		JPanel pan2=new JPanel();
		JLabel j1=new JLabel("书名");//书名 序号 类型 租借费用 该书本数 借阅次数
		TextField t1=new TextField(20);
		JButton b1=new JButton("删除");
		pan1.add(j1);
		pan1.add(t1);
		pan1.add(b1);
		con1.add(pan1);
		pan2.add(b1);
		con1.add(pan2);
		b1.addActionListener(new ActionListener()
	     	{
			public void actionPerformed(ActionEvent e)
			{
	 			String bookName = t1.getText();
				try
				{
					String driverName="com.mysql.cj.jdbc.Driver";
					String dbURL="jdbc:mysql://your.server.ip:3306/runoob";;
					String userName="RUNOOB";
					String userPwd="123456";
					String sql = "delete from Blibrary where 书名=?;";
					Class.forName(driverName);
					Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
					PreparedStatement ps = dbConn.prepareStatement(sql);
                    ps.setString(1, bookName);
					int rows = ps.executeUpdate();
				}
				catch(ClassNotFoundException e1)
				{
					e1.printStackTrace();
				}
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
	         }
	     });
	}
}