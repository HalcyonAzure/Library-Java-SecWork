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

/**
 * 对数据库中的书本进行书本的添加
 */
public class Addbook {
	/**
	 * 显示添加书本的GUI布局，并且在错误的时候返回对应的事件
	 * @throws SQLException 数据库发生问题
	 * @throws ClassNotFoundException 找不到对应的类
	 */
	public Addbook() throws SQLException, ClassNotFoundException {
	JFrame f=new JFrame("增加书本");

	f.setVisible(true);//窗口可见
	f.setSize(600,700);
	f.setLocation(600,200);

	Container con1=f.getContentPane();//生成容器添加组件
	con1.setLayout(new GridLayout(6,1));//GridLayout网格布局，几行几列
	JPanel pan1= new JPanel();
	JPanel pan2=new JPanel();
	JLabel j1=new JLabel("书名");//书名 序号 类型 租借费用 该书本数 借阅次数
	TextField t1=new TextField(20); 
	JLabel j2=new JLabel("序号");
	TextField t2=new TextField(5); 
	JLabel j3=new JLabel("类型");
	TextField t3=new TextField(5); 
	JLabel j4=new JLabel("租借费用");
	TextField t4=new TextField(5); 
	JLabel j5=new JLabel("该书本数");
	TextField t5=new TextField(5);
	JLabel j6=new JLabel("借阅次数");
	TextField t6=new TextField(5);
	JButton b1=new JButton("添加");
	pan1.add(j1);
	pan1.add(t1);
	pan1.add(j2);
	pan1.add(t2);
	pan1.add(j3);
	pan1.add(t3);
	pan1.add(j4);
	pan1.add(t4);
	pan1.add(j5);
	pan1.add(t5);
	pan1.add(j6);
	pan1.add(t6);
	pan1.add(b1);
	con1.add(pan1);
	pan2.add(b1);
	con1.add(pan2);

	 	b1.addActionListener(new ActionListener()
	 	{
			/**
			 * 连接数据库
			 * @param e 对接按钮连接数据库
			 */
	 		public void actionPerformed(ActionEvent e)
	 		{
	 			String bookName = t1.getText(); 
	 			String bookId = t2.getText();
	 			String bookType = t3.getText();
	 			String moneyCost = t4.getText();
	 			int moneyCostInt= Integer.parseInt(moneyCost);
	 			String bookNumber = t5.getText();
	 			int bookNumberInt= Integer.parseInt(bookNumber);
	 			String bookBorrowTime = t6.getText();
	 			int bookBorrowTimeInt= Integer.parseInt(bookBorrowTime);
	 			// 连接数据库
                 try
                 {
					 String driverName="com.mysql.cj.jdbc.Driver";
					 String dbURL="jdbc:mysql://lt.halc.top:3306/runoob";;
					 String userName="RUNOOB";
					 String userPwd="123456";
           		     String sql = "insert into Blibrary values(?,?,?,?,?,?);";
           		     Class.forName(driverName);
           		     Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
                     PreparedStatement ps = dbConn.prepareStatement(sql);
                     ps.setString(1, bookName);
                     ps.setString(2, bookId);
                     ps.setString(3, bookType);
                     ps.setInt(4, moneyCostInt);
                     ps.setInt(5, bookNumberInt);
                     ps.setInt(6, bookBorrowTimeInt);
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