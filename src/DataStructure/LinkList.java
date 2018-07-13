package DataStructure;

import java.util.ArrayList;

/**
 * @program: exam
 * @description:
 * @author: Zhaoziqi
 * @create: 2018-06-16 22:20
 **/
public class LinkList {
    public static Node createLinkList(int[] arr) {
        Node head = new Node();
        Node nextNode = null;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                head.setValue(arr[i]);
                if (arr.length == 1) {
                    head.next = null;
                    break;
                }
                head.next = new Node();
                nextNode = head.next;
            } else if (i == arr.length - 1) {
                nextNode.setValue(arr[i]);
                nextNode.next = null;
            } else {
                nextNode.setValue(arr[i]);
                nextNode.next = new Node();
                nextNode = nextNode.next;
            }
        }
        return head;
    }


    public static void printLink(Node head) {
        while (head != null) {
            System.out.print(head.getValue() + " ");
            head = head.next;
        }
        System.out.println();
    }

    /**
     * @Description: main
     * @Param: [args]
     * @return: void
     * @Author: Stelawliet
     * @Date: 18/6/24
     */
    public static void main(String[] args) {
        Node node = createLinkList(new int[]{1, 2, 3, 4,7,7,7,76,5,5});
        printLink(node);
        node = reverse(node);
        printLink(node);
    }

    public static Node reverse(Node head) {
        Node thisNode = head;
        Node nextNode = thisNode.next;
        Node tempNode = nextNode.next;
        nextNode.next = thisNode;
        while (tempNode != null) {
            thisNode = nextNode;
            nextNode = tempNode;
            tempNode = tempNode.next;
            nextNode.next = thisNode;
        }
        nextNode.next = thisNode;
        head.next = null;
        return nextNode;
    }

    public Node createLinkList() {
        return new Node().next = null;
    }
}


