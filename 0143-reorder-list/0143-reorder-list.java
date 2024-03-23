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
    
    public ListNode getMid(ListNode head){
        if(head == null || head.next == null) return head;
        
        ListNode fast= head,slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        } 
        return slow;
    }
    
    
    public ListNode getReversed(ListNode head){
        
          if(head == null || head.next == null) return head;
        
        ListNode curr = head, prev = null,next = null;
        
        while(curr!= null){  
           next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
              
        }  
        return prev;
    }
    
    
    public void reorderList(ListNode head) {
        
        if(head == null && head.next == null) return;
        
        // mid
        ListNode mid = getMid(head);
        
        ListNode head1 = mid.next;
        mid.next = null;
        
        // reverse second list
        
        head1 = getReversed(head1);
        
        // fold it
        
        ListNode c1 = head;
        ListNode f1;
        
        ListNode c2 = head1;
        ListNode f2; 
        
        while(c2 != null){
            f1 = c1.next;
            f2 = c2.next;
            c1.next= c2;
            c2.next = f1;
            c1 = f1;
            c2 = f2; 
            
        }
              
        
    }
}