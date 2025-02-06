package leetcode;


import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedList23 {
    public static void main(String[] args) {
        MergeKSortedList23 m = new MergeKSortedList23();
        List<List<Integer>> lists = List.of(List.of(1, 4, 5), List.of(1, 3, 4), List.of(2, 6));
        ListNode[] listNode = m.prepData(lists);
        ListNode out = m.mergeKLists(listNode);
        System.out.println(out);


    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> p = new PriorityQueue<>(Comparator.comparingInt(l -> l.val));
        ListNode head = new ListNode();
        ListNode res = head;

        for (ListNode l : lists)
            p.offer(l);

        while (!p.isEmpty()) {
            ListNode n = p.poll();
            if (n.next != null) {
                ListNode k = n.next;
                p.offer(k);
            }
            res.next = n;
            res = res.next;

        }
        return head.next;
    }

    public ListNode[] prepData(List<List<Integer>> lists) {
        ListNode[] listsInt = new ListNode[lists.size()];
        int i = 0;
        for (List<Integer> list : lists) {
            ListNode head = new ListNode();
            ListNode res = head;
            for (Integer integer : list) {
                res.next = new ListNode(integer);
                res = res.next;
            }
            listsInt[i++] = head.next;
        }
        return listsInt;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
