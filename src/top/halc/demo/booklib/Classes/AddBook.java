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
public class AddBook {
    /**
     * ��ʾ����鱾��GUI���֣������ڴ����ʱ�򷵻ض�Ӧ���¼�
     *
     * @throws SQLException           ���ݿⷢ������
     * @throws ClassNotFoundException �Ҳ�����Ӧ����
     */
    public AddBook() throws SQLException, ClassNotFoundException {

        JFrame addBookFrame = new JFrame("�����鱾");

        addBookFrame.setVisible(true);//���ڿɼ�
        addBookFrame.setSize(600, 200);
        addBookFrame.setLocation(600, 200);

        Container con1 = addBookFrame.getContentPane();
        // ��������������
        con1.setLayout(new GridLayout(2, 3));
        // GridLayout���񲼾֣����м���

        //��һ�������� ���� ��� ����
        JPanel bookNamePanel = new JPanel();
        JLabel bookName = new JLabel("����");
        TextField nameString = new TextField(5);
        bookNamePanel.add(bookName);
        bookNamePanel.add(nameString);
        con1.add(bookNamePanel);

        JPanel bookNumberPanel = new JPanel();
        JLabel bookNumber = new JLabel("���");
        TextField numberString = new TextField(5);
        bookNumberPanel.add(bookNumber);
        bookNumberPanel.add(numberString);
        con1.add(bookNumberPanel);

        JPanel bookTypePanel = new JPanel();
        JLabel bookType = new JLabel("����");
        TextField typeString = new TextField(5);
        bookTypePanel.add(bookType);
        bookTypePanel.add(typeString);
        con1.add(bookTypePanel);


        JPanel bookCostPanel = new JPanel();
        JLabel bookCost = new JLabel("������");
        TextField costString = new TextField(5);
        bookCostPanel.add(bookCost);
        bookCostPanel.add(costString);
        con1.add(bookCostPanel);

        JPanel bookExistPanel = new JPanel();
        JLabel bookExist = new JLabel("���鱾��");
        TextField existString = new TextField(5);
        bookExistPanel.add(bookExist);
        bookExistPanel.add(existString);
        con1.add(bookExistPanel);

        JPanel bookBorrowTimePanel = new JPanel();
        JLabel bookBorrowTime = new JLabel("���Ĵ���");
        TextField borrowTimeString = new TextField(5);
        bookBorrowTimePanel.add(bookBorrowTime);
        bookBorrowTimePanel.add(borrowTimeString);
        con1.add(bookBorrowTimePanel);

        JPanel addBook = new JPanel();
        JButton b1 = new JButton("���");
        addBook.add(b1);
        con1.add(addBook);

        b1.addActionListener(new ActionListener() {
            /**
             * �������ݿ�
             * @param e �ԽӰ�ť�������ݿ�
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
                // �������ݿ�
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