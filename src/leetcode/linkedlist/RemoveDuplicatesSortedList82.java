package leetcode.linkedlist;

import linkedlist.ListNode;

public class RemoveDuplicatesSortedList82 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l33 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l44 = new ListNode(4);

        ListNode l5 = new ListNode(5);
        //ListNode l6= new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l33;
        l33.next=l4;
        l4.next = l44;
        l44.next=l5;
        RemoveDuplicatesSortedList82 r = new RemoveDuplicatesSortedList82();
        ListNode listNode = r.deleteDuplicates(l1);
        System.out.println(listNode);

        ListNode l11 = new ListNode(1);
        ListNode l111 = new ListNode(1);
        ListNode l1111 = new ListNode(1);
        ListNode l22 = new ListNode(2);
        ListNode l333 = new ListNode(3);
        l11.next=l111;
        l111.next=l1111;
        //l1111.next=l22;
        //l22.next=l333;
        listNode = r.deleteDuplicates(l11);
        System.out.println(listNode);
        //l5.next=l6;
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return null;
        ListNode prev= new ListNode(0);
        ListNode next=head.next, curr=head;
        while(next!=null){

            if(next.val==curr.val){

                while(next!=null && next.val==curr.val){
                    next=next.next;
                }
                prev.next= next;
                if(curr==head){
                    head=next;
                }
            }
            else {
                prev = curr;

            }
            curr=next;
            next = next!=null?next.next:null;
        }
        return head;

    }
}
