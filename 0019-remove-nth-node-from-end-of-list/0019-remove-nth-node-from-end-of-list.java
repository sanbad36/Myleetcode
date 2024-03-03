/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(head == null || n==0) return head;
       ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode iter = head;

        int length=0;
        while(iter != null){
            length++;
            iter = iter.next;
        }
        length -= n;
        iter = dummy;
        while(length>0){
            length--;
            iter = iter.next;
        }
    
        iter.next = iter.next.next;
        return dummy.next;
    }
}