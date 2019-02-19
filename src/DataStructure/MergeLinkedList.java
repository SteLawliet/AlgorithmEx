package DataStructure;

/**
 * @program: exam
 * @description:
 * @author: Zhaoziqi
 * @create: 2018-08-04 22:25
 **/
public class MergeLinkedList {

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode getLinkList(int[] a) {
        ListNode head0 = new ListNode(-1);
        ListNode p = head0;
        ListNode node = null;
        for (int i : a) {
            node = new ListNode(i);
            p.next = node;
            p = node;
        }
        return head0.next;
    }

    public static ListNode Merge(ListNode list1, ListNode list2) {

        ListNode head = null;
        ListNode mergeNode = null;
        while (list1 != null && list2 != null) {
            if (head == null) {
                head = new ListNode(0);
                mergeNode = head;
            }
            if (list1.val <= list2.val) {
                mergeNode.val = list1.val;
                list1 = list1.next;
            } else {
                mergeNode.val = list2.val;
                list2 = list2.next;
            }
            mergeNode.next = new ListNode(0);
            mergeNode = mergeNode.next;
        }
        while (list1 != null) {
            if (head == null) {
                head = new ListNode(0);
                mergeNode = head;
            }
            mergeNode.val = list1.val;
            list1 = list1.next;
            if (list1 != null)
                mergeNode.next = new ListNode(0);
            mergeNode = mergeNode.next;
        }
        while (list2 != null) {
            if (head == null) {
                head = new ListNode(0);
                mergeNode = head;
            }
            mergeNode.val = list2.val;
            list2 = list2.next;
            if (list2 != null)
                mergeNode.next = new ListNode(0);
            mergeNode = mergeNode.next;
        }
        return head;
    }

    public static ListNode Merge0(ListNode list1, ListNode list2) {

        ListNode head = null;
        ListNode mergeNode = null;
        while (list1 != null && list2 != null) {
            if (head == null) {
                head = new ListNode(0);
                mergeNode = head;
            }
            if (list1.val <= list2.val) {
                mergeNode.val = list1.val;
                list1 = list1.next;
            } else {
                mergeNode.val = list2.val;
                list2 = list2.next;
            }
            mergeNode.next = new ListNode(0);
            mergeNode = mergeNode.next;
        }
        while (list1 != null) {
            if (head == null) {
                head = new ListNode(0);
                mergeNode = head;
            }
            mergeNode.val = list1.val;
            list1 = list1.next;
            if (list1 != null)
                mergeNode.next = new ListNode(0);
            mergeNode = mergeNode.next;
        }
        while (list2 != null) {
            if (head == null) {
                head = new ListNode(0);
                mergeNode = head;
            }
            mergeNode.val = list2.val;
            list2 = list2.next;
            if (list2 != null)
                mergeNode.next = new ListNode(0);
            mergeNode = mergeNode.next;
        }
        return head;
    }


    public static ListNode merge0(ListNode list1, ListNode list2) {
        ListNode head0 = new ListNode(-1);
        ListNode p = head0;
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                p.next = list1;
//                if (list1.next != null) {
                    p = list1;
//                }
                list1 = list1.next;

            } else {
                p.next = list2;
//                if (list2.next != null) {
                    p = list2;
//                }
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            p.next = list1;
        }

        if (list2 != null) {
            p.next = list2;
        }
        return head0.next;
    }

    public static void main(String[] args) {
        ListNode n1 = getLinkList(new int[]{1, 3});
        ListNode n01 = getLinkList(new int[]{2, 4});
        ListNode merge = merge0(n1, n01);

    }
}

