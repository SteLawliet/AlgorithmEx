package ArraysEx;


/**
 * @program: exam
 * @description:
 * @author: Zhaoziqi
 * @create: 2018-08-03 20:11
 **/
public class ReverseLink {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    private static ListNode getLinkList(int[] a){

        ListNode head0 = new ListNode(-1);
        ListNode head = head0;
        ListNode node=null;
        for (int i = 0; i < a.length; i++) {
            node = new ListNode(a[i]);
            head.next = node;
            head = node;
        }
        return head0.next;
    }
    private static ListNode getLinkList0(int[] a){

        return  null;
    }

    private static ListNode getLinkList0(int[] a,int i){

        if (a.length-1==i){
            return null;
        }

        return null;
    }



        private static ListNode ReverseList(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode n = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return n;
    }

    //null<-0 <- 1 - s2
    //
    private static ListNode reverse(ListNode head) {
        ListNode next = head.next;
        ListNode last = next.next;
        head.next=null;
        while (last!= null) {
            next.next = head;
            head = next;
            next = last;
            last = last.next;
        }
        next.next = head;
        return next;
    }


    public static void main(String[] args) {
        ListNode linkList = getLinkList(new int[]{1, 2, 3, 4, 5, 6});
        ListNode n = reverse(linkList);


    }
}
