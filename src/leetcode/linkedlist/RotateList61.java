package leetcode.linkedlist;

import linkedlist.ListNode;

public class RotateList61 {
    public static void main(String[] args) {
        RotateList61 r = new RotateList61();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        //ListNode l6= new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode l = r.rotateRight(l1, 2);
        System.out.println(l);
    }

    public ListNode rotateRight(ListNode head, int k) {
        int size = size(head);
        k = k % size;
        if (k == 0) return head;
        int diff = size - k;
        ListNode curr = head;
        while (diff > 1) {
            curr = curr.next;
            diff--;
        }
        ListNode prev = curr;
        ListNode newHead = curr.next;

        while (curr.next != null) {
            curr = curr.next;
        }
        prev.next = null;
        curr.next = head;

        return newHead;


    }

    private int size(ListNode head) {
        int size = 0;
        ListNode curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        return size;
    }
}
