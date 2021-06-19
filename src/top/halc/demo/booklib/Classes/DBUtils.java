package top.halc.demo.booklib.Classes;

import java.sql.*;
import java.util.ResourceBundle;

public class DBUtils {

    private static String DriverClass;
    private static String url;
    private static String user;
    private static String password;
    // 静态代码块   类只要加载，直接执行
    // 就是将配置文件加载；
    static{
        ResourceBundle rb  = ResourceBundle.getBundle("dbinfo");
        // 进行赋值操作；
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


    // 创建两个方法：    // yi :得到连接的方法
    public static Connection getConnection() throws Exception{

        return  DriverManager.getConnection(url,user,password);

    }
    // 二 ： 关闭资源
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