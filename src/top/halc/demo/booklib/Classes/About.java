package top.halc.demo.booklib.Classes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;

public class About {

    private static final String APPLICATION = "食堂管理系统";
    private static final String VERSION = "Ver 1.0.0";
    private static final String TIME = "2021.6.16";
    private static final String NAME = "";
    private static final String SCHOOL_ID = "";
    private static final String CLASS = "";

    /**
     * 重载方法，创建对应的窗口
     * 其中用常量表示信息
     */
    public About(){
            JFrame about = new JFrame("作者信息");
            about.setVisible(true);
            about.setSize(400,500);
            about.setLocation(600,250);

            JPanel aboutInfo = new JPanel();
            JLabel info = new JLabel("<html>"+APPLICATION+" "+VERSION+"<br>"+NAME+"<br>"+SCHOOL_ID+"<br>"+CLASS+"<br>"+TIME+"</html>");
            info.setFont(new Font("微软雅黑",Font.BOLD,15));
            aboutInfo.add(info);
            about.add(aboutInfo);

            about.pack();
            about.setVisible(true);
        }
}
