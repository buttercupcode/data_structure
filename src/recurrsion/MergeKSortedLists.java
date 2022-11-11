package recurrsion;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparing(listNode -> listNode.val));

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode finalList = dummy;
        for (ListNode list : lists) {
            if (list != null)
                priorityQueue.add(list);
        }
        while (!priorityQueue.isEmpty()) {
            ListNode currentSmallest = priorityQueue.poll();
            if (currentSmallest.next != null)
                priorityQueue.add(currentSmallest.next);
            finalList.next = currentSmallest;
            finalList = finalList.next;
        }
        return dummy.next;
    }

    class ListNode {
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
