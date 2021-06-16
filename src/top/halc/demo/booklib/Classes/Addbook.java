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
 * �����ݿ��е��鱾�����鱾�����
 */
public class Addbook {
	/**
	 * ��ʾ����鱾��GUI���֣������ڴ����ʱ�򷵻ض�Ӧ���¼�
	 * @throws SQLException ���ݿⷢ������
	 * @throws ClassNotFoundException �Ҳ�����Ӧ����
	 */
	public Addbook() throws SQLException, ClassNotFoundException {
	JFrame f=new JFrame("�����鱾");

	f.setVisible(true);//���ڿɼ�
	f.setSize(600,700);
	f.setLocation(600,200);

	Container con1=f.getContentPane();//��������������
	con1.setLayout(new GridLayout(6,1));//GridLayout���񲼾֣����м���
	JPanel pan1= new JPanel();
	JPanel pan2=new JPanel();
	JLabel j1=new JLabel("����");//���� ��� ���� ������ ���鱾�� ���Ĵ���
	TextField t1=new TextField(20); 
	JLabel j2=new JLabel("���");
	TextField t2=new TextField(5); 
	JLabel j3=new JLabel("����");
	TextField t3=new TextField(5); 
	JLabel j4=new JLabel("������");
	TextField t4=new TextField(5); 
	JLabel j5=new JLabel("���鱾��");
	TextField t5=new TextField(5);
	JLabel j6=new JLabel("���Ĵ���");
	TextField t6=new TextField(5);
	JButton b1=new JButton("���");
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
			 * �������ݿ�
			 * @param e �ԽӰ�ť�������ݿ�
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
	 			// �������ݿ�
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