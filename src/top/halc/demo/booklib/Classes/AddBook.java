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
public class AddBook {
    /**
     * 显示添加书本的GUI布局，并且在错误的时候返回对应的事件
     *
     * @throws SQLException           数据库发生问题
     * @throws ClassNotFoundException 找不到对应的类
     */
    public AddBook() throws SQLException, ClassNotFoundException {

        JFrame addBookFrame = new JFrame("增加书本");

        addBookFrame.setVisible(true);//窗口可见
        addBookFrame.setSize(600, 200);
        addBookFrame.setLocation(600, 200);

        Container con1 = addBookFrame.getContentPane();
        // 生成容器添加组件
        con1.setLayout(new GridLayout(2, 3));
        // GridLayout网格布局，几行几列

        //第一个面板添加 书名 序号 类型
        JPanel bookNamePanel = new JPanel();
        JLabel bookName = new JLabel("书名");
        TextField nameString = new TextField(5);
        bookNamePanel.add(bookName);
        bookNamePanel.add(nameString);
        con1.add(bookNamePanel);

        JPanel bookNumberPanel = new JPanel();
        JLabel bookNumber = new JLabel("序号");
        TextField numberString = new TextField(5);
        bookNumberPanel.add(bookNumber);
        bookNumberPanel.add(numberString);
        con1.add(bookNumberPanel);

        JPanel bookTypePanel = new JPanel();
        JLabel bookType = new JLabel("总类");
        TextField typeString = new TextField(5);
        bookTypePanel.add(bookType);
        bookTypePanel.add(typeString);
        con1.add(bookTypePanel);


        JPanel bookCostPanel = new JPanel();
        JLabel bookCost = new JLabel("租借费用");
        TextField costString = new TextField(5);
        bookCostPanel.add(bookCost);
        bookCostPanel.add(costString);
        con1.add(bookCostPanel);

        JPanel bookExistPanel = new JPanel();
        JLabel bookExist = new JLabel("该书本数");
        TextField existString = new TextField(5);
        bookExistPanel.add(bookExist);
        bookExistPanel.add(existString);
        con1.add(bookExistPanel);

        JPanel bookBorrowTimePanel = new JPanel();
        JLabel bookBorrowTime = new JLabel("借阅次数");
        TextField borrowTimeString = new TextField(5);
        bookBorrowTimePanel.add(bookBorrowTime);
        bookBorrowTimePanel.add(borrowTimeString);
        con1.add(bookBorrowTimePanel);

        JPanel addBook = new JPanel();
        JButton b1 = new JButton("添加");
        addBook.add(b1);
        con1.add(addBook);

        b1.addActionListener(new ActionListener() {
            /**
             * 连接数据库
             * @param e 对接按钮连接数据库
             */
            public void actionPerformed(ActionEvent e) {
                String bookName = nameString.getText();
                String bookId = numberString.getText();
                String bookType = typeString.getText();
                String moneyCost = costString.getText();
                int moneyCostInt = Integer.parseInt(moneyCost);
                String bookNumber = existString.getText();
                int bookNumberInt = Integer.parseInt(bookNumber);
                String bookBorrowTime = borrowTimeString.getText();
                int bookBorrowTimeInt = Integer.parseInt(bookBorrowTime);
                // 连接数据库
                try {
                    String driverName = "com.mysql.cj.jdbc.Driver";
                    String dbURL = "jdbc:mysql://lt.halc.top:3306/runoob";
                    String userName = "RUNOOB";
                    String userPwd = "123456";
                    String sql = "insert into Blibrary values(?,?,?,?,?,?);";
                    Class.forName(driverName);
                    Connection dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
                    PreparedStatement ps = dbConn.prepareStatement(sql);
                    ps.setString(1, bookName);
                    ps.setString(2, bookId);
                    ps.setString(3, bookType);
                    ps.setInt(4, moneyCostInt);
                    ps.setInt(5, bookNumberInt);
                    ps.setInt(6, bookBorrowTimeInt);
                    int rows = ps.executeUpdate();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}