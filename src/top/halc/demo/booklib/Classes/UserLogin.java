package top.halc.demo.booklib.Classes;

import java.sql.*;

public class UserLogin {

    public User findUser(User login)
    {
        String name = login.getName();
        String pwd = login.getPassword();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User u  =null;
        try{
            String driverName = "com.mysql.cj.jdbc.Driver";
            String dbURL = "jdbc:mysql://your.server.ip:3306/runoob";
            String userName = "RUNOOB";
            String userPwd = "123456";
            Class.forName(driverName);
            conn = DriverManager.getConnection(dbURL, userName, userPwd);
            String Sql = "select * from users where 用户名=? and 密码=?"; // 预编译

            stmt = conn.prepareStatement(Sql);
            // 给问号赋值
            stmt.setString(1,name);
            stmt.setString(2,pwd);

            rs  = stmt.executeQuery();
            if(rs.next())
            {
                u  =  new User();
                u.setName(rs.getString(1));
                u.setPassword(rs.getString(2));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return u;
    }
}
