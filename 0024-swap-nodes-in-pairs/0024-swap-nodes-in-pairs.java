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
    public ListNode swapPairs(ListNode head) {
        
        // edge cases
        if(head== null || head.next==null) return head;
        
        ListNode first = head.next;
        ListNode second = head;
        ListNode backup = head.next.next;
        
        head = first;
        head.next = second;
        head.next.next = swapPairs(backup);
        return head;
    }
}