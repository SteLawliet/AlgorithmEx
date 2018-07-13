package DataStructure;

import java.util.ArrayList;

/**
 * @program: exam
 * @description:
 * @author: Zhaoziqi
 * @create: 2018-06-20 19:18
 **/
public class Node {
    public Node next;
    ArrayList l = new ArrayList();
    private int value;


    public Node(int value) {
        this.value = value;
    }

    public Node() {
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public Node setValue(int value) {
        this.value = value;
        return this;

    }

}