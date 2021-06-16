package top.halc.demo.booklib.Application;
import java.sql.*;

import top.halc.demo.booklib.Classes.ShowMenuOptions;
public class Main {
	public static void main(String [] args)
	{
		String driverName="com.mysql.cj.jdbc.Driver";
		String dbURL="jdbc:mysql://lt.halc.top:3306/runoob";
		String userName="RUNOOB";
		String userPwd="123456";
		try
		{
			Class.forName(driverName);
			Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
			System.out.println("连接成功");
			new ShowMenuOptions();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.print("连接失败");
		}
	}
}