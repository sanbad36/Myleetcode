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
    public ListNode swapNodes(ListNode head, int k) {
        
        if(head == null || head.next == null || k==0) return head;
        
        
        // find the node postions   
        ListNode fast = head;
        ListNode slow = head;
        for(int i=0;i<k-1;i++){
          fast = fast.next;
      }
        ListNode c1 = fast;
        
     while(fast.next != null ){
         slow = slow.next;
         fast = fast.next;   
     }
        
        int temp=c1.val;
        c1.val = slow.val;
        slow.val = temp;
    
      return head;
    
    }
}