package top.halc.demo.booklib.Classes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Book {
    private String name;  // ����
    private String type;  // ����
    private int exist; // �������
    private int cost;  // �鱾����
    private int borrowTime;  // ���Ĵ���
}
