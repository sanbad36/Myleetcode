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
    
    ListNode getMiddle(ListNode head){
        ListNode fast = head,slow = head;
        
        while(fast.next != null && fast.next.next != null){
            fast  = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    ListNode getReversal(ListNode head){
        
        if(head==null || head.next == null) return head;
        
        ListNode curr,prev,nex;
        curr = head;
        prev= null;
        nex = null;
        while(curr!=null){
            nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
        }
        return prev;
        
    }
    
    
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null ) return true;
        // get middle
        ListNode mid = getMiddle(head);
        
        ListNode head1 = mid.next;
        mid.next = null;
        // Reverse the second list
        head1 = getReversal(head1);
        
        // check for the palindrome
        ListNode c1 = head;
        ListNode c2 = head1;
        while(c2 != null){
            
            if(c1.val != c2.val){
                return false;
            }
            c1 = c1.next;
            c2 = c2.next; 
        }
        return true;
    }
}