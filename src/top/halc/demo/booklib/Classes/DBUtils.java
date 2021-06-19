package top.halc.demo.booklib.Classes;

import java.sql.*;
import java.util.ResourceBundle;

public class DBUtils {

    private static String DriverClass;
    private static String url;
    private static String user;
    private static String password;
    // ��̬�����   ��ֻҪ���أ�ֱ��ִ��
    // ���ǽ������ļ����أ�
    static{
        ResourceBundle rb  = ResourceBundle.getBundle("dbinfo");
        // ���и�ֵ������
        DriverClass   = rb.getString("com.mysql.cj.jdbc.Driver");
        url  = rb.getString("jdbc:mysql://your.server.ip:3306/runoob");
        user = rb.getString("RUNOOB");
        password = rb.getString("123456");
        try {
            Class.forName(DriverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    // ��������������    // yi :�õ����ӵķ���
    public static Connection getConnection() throws Exception{

        return  DriverManager.getConnection(url,user,password);

    }
    // �� �� �ر���Դ
    public static void closeAll(ResultSet rs,Statement stmt,Connection conn)
    {
        if(rs!=null)
        {
            try{
                rs.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }


        if(stmt!=null)
        {
            try{
                stmt.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }


        if(conn!=null)
        {
            try{
                conn.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

    }



}