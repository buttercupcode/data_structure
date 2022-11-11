package recurrsion;

import linkedlist.ListNode;

public class MergeTwoLinkedList {
    /**
     * Definition for singly-linked list.

     */
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5= new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        MergeTwoLinkedList ls= new MergeTwoLinkedList();
        ls.printList(node1);
        node1=ls.reverseList(node1);
        ls.printList(node1);
        System.out.println( ls.isPalindrome(node1));
         node1 = new ListNode(1);
         node2 = new ListNode(2);
         node3 = new ListNode(2);
         node4 = new ListNode(2);
         node5= new ListNode(2);
         ListNode node6= new ListNode(1);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
node5.next=node6;
        System.out.println( ls.isPalindrome(node1));
    }
   public void printList(ListNode head){
        ListNode current= head;
       System.out.println("list print start");
        while(current!=null) {
            System.out.println(current.val);
            current = current.next;
        }
       System.out.println("list node  print end");
   }
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode nextNode=null;
            ListNode current=null;
            if(list1==null)
                return list2;
            if(list2==null)
                return list1;
            if(list1.val<=list2.val){
                current = new ListNode(list1.val);
                current.next = mergeTwoLists(list1.next,list2);
            }else
            {
                current = new ListNode(list2.val);
                current.next = mergeTwoLists(list1,list2.next);
            }
            return current;
        }
    public ListNode reverseList(ListNode head) {
        /* using recursion
        if(head==null||head.next==null)
            return head;
        ListNode current= reverseList(head.next);
        ListNode pointer= current;
        while(pointer.next!=null){
            pointer=pointer.next;
        }
        pointer.next=head;
        head.next=null;
        return current;
        */
        //using iteration
        ListNode current=head;
        ListNode previous =null;
        ListNode next;
        while(current!=null){
            next=current.next;
            current.next=previous;
            previous=current;

                current=next;
        }
        return previous;
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null)
            return true;
        ListNode current=head;
        ListNode fast=current,slow=current;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

        ListNode secondHalf= reverse(slow);
        while(head!=null&&secondHalf!=null){
            if(head.val!=secondHalf.val)
                return false;
            head=head.next;
            secondHalf=secondHalf.next;
        }
        return true;

    }
    public ListNode reverse(ListNode head){
        ListNode previous=null,next=null;
        ListNode current= head;
        while(current!=null){
            next=current.next;
            current.next=previous;
            previous=current;
            current=next;
        }
        return previous;
    }
}
