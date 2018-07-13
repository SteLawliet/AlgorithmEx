package DataStructure;

/**
 * @program: exam
 * @description:
 * @author: Zhaoziqi
 * @create: 2018-06-16 22:20
 **/
public class LinkNode {
   public static Node reverse(Node head){
       if (head.next==null){
           return head ;
       }
       Node reversNode = reverse(head.next);
       head.next.next = head;
       head.next=null;
       return reversNode;
   }

    public static void main(String[] args) {
        Node created = MyLinkedList.created(new int[]{1, 2, 3, 4,});
        MyLinkedList.print(created);
         created = reverse(created);
        MyLinkedList.print(created);
    }
}


