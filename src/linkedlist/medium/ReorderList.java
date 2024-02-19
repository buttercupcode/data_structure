package linkedlist.medium;

import linkedlist.ListNode;

public class ReorderList {
    public static void main(String[] args) {
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
        //l5.next=l6;
        ReorderList rl = new ReorderList();
        rl.reorderList(l1);
        ListNode current = l1;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode previous = null, current = slow.next, next;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        slow.next = null;
        ListNode h2 = previous;
        ListNode h1 = head;
        current = head;
        while (h1 != null && h2 != null) {
            h1 = h1.next;
            current.next = h2;
            h2 = h2.next;
            current = current.next;
            current.next = h1;
            current = h1;

        }

    }
}
