package top.halc.demo.booklib.Classes;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.sql.*;

/**
 * ��ʾ���ݿ��е��鱾����
 */
public class BookLibrary {
	/**
	 * �������ݿⲢ�ҵ������е�����
	 * @throws SQLException ���ݿⷢ������
	 * @throws ClassNotFoundException �Ҳ�����Ӧ����
	 */
	public BookLibrary() throws SQLException, ClassNotFoundException {
		String driverName="com.mysql.cj.jdbc.Driver";
		String dbURL="jdbc:mysql://lt.halc.top:3306/runoob";
		String userName="RUNOOB";
		String userPwd="123456";
		// �������ݿ�Ĳ�����ֵ
		Class.forName(driverName);
		Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
		Statement stmt=dbConn.createStatement();
		// stmt���������ݿ�ʱ����ִ��sql���Ķ���
		String cmdStr="select * from Blibrary";
		// cmdStr�Ǵ������ݿ�ʹ�õ�ָ��
		ResultSet rs=stmt.executeQuery(cmdStr);
		// �������ݿ��е����ݣ��������ݿ�ָ��
		int count=0;
		while(rs.next()){
			count++;
		}  // ��¼�鱾����
		rs=stmt.executeQuery(cmdStr);
		Object[][] info = new Object[count][10]; // �����鱾��Ӧ����ʱ��������Object
		count = 0;
		while(rs.next()){
		info[count][0] = rs.getString(1);
		info[count][1] = rs.getString(2);
		info[count][2] = rs.getString(3);
		info[count][3] = rs.getString(4);
		info[count][4] = rs.getString(5);
		info[count][5] = rs.getString(6);
		count++;
		}  // ��������ͬ�Ĳ���ȫ������

		// ������ݿ��ı���
		String[] title = {"����","���","����","������","���鱾��","���Ĵ���"};
		JFrame tc=new JFrame("���");
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