package linkedlist;

public class LeetcodeBkpUp {
    /*
    if(l1==null ) return l2;
        if(l2==null ) return l1;
    int carry=0;
    ListNode head= new ListNode(0);
    ListNode curr= head;

        while(l1!=null || l2!=null){
        int val1 = l1 == null?0:l1.val;
        int val2 = l2 == null?0:l2.val;
        int sum = val1+val2+carry;
        carry = sum>=10?1:0;
        sum = sum%10;
        ListNode temp = new ListNode(sum);
        curr.next=temp;
        curr=curr.next;
        l1 = l1==null?null:l1.next;
        l2 = l2==null?null:l2.next;
    }
    ListNode rem=null,carryNode=null;

        if(carry!=0){
        carryNode = new ListNode(carry);
        curr.next= carryNode;
        curr = curr.next;
    }
        return head.next;


}

**
        * Definition for singly-linked list.
        * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/*
    class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    }
    */


}
