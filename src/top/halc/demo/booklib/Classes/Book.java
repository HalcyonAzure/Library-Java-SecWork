package top.halc.demo.booklib.Classes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Book {
    private String name;  // 书名
    private String type;  // 类型
    private int exist; // 存货数量
    private int cost;  // 书本花费
    private int borrowTime;  // 借阅次数
}
