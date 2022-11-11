package heap;

import linkedlist.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SortKLists {
    public static void main(String[] args) {
        int N = 3;

        // array to store head of linkedlist
        ListNode[] a = new ListNode[N];

        // Linkedlist1
        ListNode head1 = new ListNode(1);
        a[0] = head1;
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(5);
        head1.next.next.next = new ListNode(7);

        // Limkedlist2
        ListNode head2 = new ListNode(2);
        a[1] = head2;
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(6);
        head2.next.next.next = new ListNode(8);

        // Linkedlist3
        ListNode head3 = new ListNode(0);
        a[2] = head3;
        head3.next = new ListNode(9);
        head3.next.next = new ListNode(10);
        head3.next.next.next = new ListNode(11);

        SortKLists res = new SortKLists();
        ListNode out = res.mergeKLists(a);
        res.printList(out);

    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new NodeComparator());
        ListNode head = new ListNode(0);
        ListNode last = head;
        for (ListNode node : lists) {
            if (node != null)
                queue.add(node);
        }
        if (queue.isEmpty()) {
            return null;
        }
        while (!queue.isEmpty()) {
            ListNode temp = queue.poll();
            if (temp.next != null)
                queue.add(temp.next);
            last.next = temp;
            last = last.next;
        }
        return head.next;
    }

    public void printList(ListNode head) {
        ListNode current = head;
        System.out.println("list print start");
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
        System.out.println("list node  print end");
    }

    class NodeComparator implements Comparator<ListNode> {
        public int compare(ListNode node1, ListNode node2) {
            if (node1.val > node2.val)
                return 1;
            else if (node1.val < node2.val)
                return -1;
            else
                return 0;
        }
    }
}
