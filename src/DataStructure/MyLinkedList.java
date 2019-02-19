package DataStructure;

/**
 * @program: exam
 * @description: MyLinkedList
 * @author: Zhaoziqi
 * @create: 2018-06-20 19:16
 **/
public class MyLinkedList {
    public static Node created(int[] arr) {
        Node node0 = new Node().setValue(arr[0]);
        Node head = node0;
        Node node1 = null;
        for (int i = 1; i < arr.length; i++) {
            node1 = new Node().setValue(arr[i]);
            node0.next = node1;
            node0 = node1;
        }
        node0.next = null;

        return head;
    }

    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.getValue() + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static Node reverse(Node head) {
        if (head == null || head.next == null) return head;
        Node n0 = head;
        Node n1 = head.next;
        Node n2 = n1.next;
        head.next = null;
        while (n1.next != null) {
            n2 = n1.next;
            n1.next = n0;
            n0 = n1;
            n1 = n2;
        }
        n1.next = n0;
        return n1;
    }
    public static Node ReReverse(Node head){
        if (head.next == null){
            return head;
        }
return null;
    }








    /**
     * 0 -> 1 -> 2 -> null
     *
     * @Description: myReverse
     * @Param: [head]
     * @return: DataStructure.Node
     * @Author: Stelawliet
     * @Date: 18/6/25
     */
    public static Node myReverse(Node head) {

        if (head == null) return null;
        if (head.next == null) return head;

        Node reverseNode = myReverse(head.next);

        head.next.next = head;

        head.next = null;

        return reverseNode;
    }

    public static void main(String[] args) {
        Node head = created(new int[]{1, 2, 3});
        print(head);
        head = myReverse(head);
        print(head);
    }
}
