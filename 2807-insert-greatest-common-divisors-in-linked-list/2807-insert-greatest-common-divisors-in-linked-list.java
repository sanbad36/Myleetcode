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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode picchla = head;
        ListNode agla = picchla.next;
        while(agla!=null){
            ListNode gcd = new ListNode(gcdOfTwo(picchla.val,agla.val));
            picchla.next = gcd;
            gcd.next = agla;
            picchla = agla;
            agla = agla.next;
        }
        return head;
    }

    public int gcdOfTwo(int a, int b)
    {
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        if (a == b)
            return a;

        if (a > b)
            return gcdOfTwo(a % b, b);
        return gcdOfTwo(a, b % a);
    }
}