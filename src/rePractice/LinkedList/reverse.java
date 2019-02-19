package rePractice.LinkedList;

/**
 * @program: exam
 * @description:
 * @author: Zhaoziqi
 * @create: 2018-08-07 21:57
 **/
public class reverse {
    static class Node{
        int val;
        Node next;

        Node(int v){
            val = v;
        }
    }
    public static Node getLinked(int[] a){
        Node pre = new Node(-1);
        Node p = pre;
        for (int i : a) {
            p.next = new Node(i);
            p = p.next;
        }
        return pre.next;
    }

//    0 <- 1-2
    public static Node reverse0(Node head){
        Node pre = null;
        Node next = null;
        while (head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return  pre;
    }
    public static Node reverse1(Node head){
        if (head==null||head.next==null){
            return head;
        }
        Node node = reverse1(head.next);
        head.next.next = head;
        head.next=null;
        return node;
    }

    public static void main(String[] args) {
        Node linked = getLinked(new int[]{0, 1, 2, 3, 4, 5});
        Node node = reverse1(linked);

    }
}
