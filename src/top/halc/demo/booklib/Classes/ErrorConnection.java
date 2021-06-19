package top.halc.demo.booklib.Classes;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

public class ErrorConnection{
    public ErrorConnection() {
        JFrame errorInfo=new JFrame("提示");
        errorInfo.setVisible(true);//窗口可见
        errorInfo.setSize(300,300);
        errorInfo.setLocation(600, 200);
        JPanel center = new JPanel();
        Container con1=errorInfo.getContentPane();//生成容器添加组件
        con1.setLayout(new GridLayout(6,4));//GridLayout网格布局，几行几列
        JLabel title=new JLabel("数据库连接失败！");
        title.setFont(new Font("微软雅黑",Font.BOLD, 20));
        center.add(title);
        con1.add(center);

    }
}