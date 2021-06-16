package top.halc.demo.booklib.Classes;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.sql.*;

/**
 * 显示数据库中的书本类型
 */
public class BookLibrary {
	/**
	 * 连接数据库并且导出其中的数据
	 * @throws SQLException 数据库发生问题
	 * @throws ClassNotFoundException 找不到对应的类
	 */
	public BookLibrary() throws SQLException, ClassNotFoundException {
		String driverName="com.mysql.cj.jdbc.Driver";
		String dbURL="jdbc:mysql://lt.halc.top:3306/runoob";
		String userName="RUNOOB";
		String userPwd="123456";
		// 传入数据库的参数数值
		Class.forName(driverName);
		Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
		Statement stmt=dbConn.createStatement();
		// stmt是连接数据库时用于执行sql语句的对象
		String cmdStr="select * from Blibrary";
		// cmdStr是传入数据库使用的指令
		ResultSet rs=stmt.executeQuery(cmdStr);
		// 导出数据库中的数据，传入数据库指令
		int count=0;
		while(rs.next()){
			count++;
		}  // 记录书本总数
		rs=stmt.executeQuery(cmdStr);
		Object[][] info = new Object[count][10]; // 创建书本对应的临时容器数组Object
		count = 0;
		while(rs.next()){
		info[count][0] = rs.getString(1);
		info[count][1] = rs.getString(2);
		info[count][2] = rs.getString(3);
		info[count][3] = rs.getString(4);
		info[count][4] = rs.getString(5);
		info[count][5] = rs.getString(6);
		count++;
		}  // 将容器不同的参数全部导出

		// 添加数据库表的标题
		String[] title = {"书名","序号","类型","租借费用","该书本数","借阅次数"};
		JFrame tc=new JFrame("书库");
		LayoutManager manager=null;
		manager=new FlowLayout();
		tc.setLayout(manager);
		JTable jt=new JTable(info,title);
		JTableHeader jth=new JTableHeader();
		jth=jt.getTableHeader();
		JScrollPane jsc=new JScrollPane();
		jsc.setSize(500,570);
		jsc.getViewport().add(jt);
		tc.add(jsc);
		tc.setSize(500,500);
		tc.setVisible(true);
		stmt.close();
		dbConn.close();
	}
}