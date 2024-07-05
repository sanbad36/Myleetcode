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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode slow = head;
        ListNode med = slow.next;
        ListNode fast = med.next;
        int[] arr = new int[2];
        arr[0]=-1;
        arr[1]=-1;
        int minc=0,maxc=0,min=Integer.MAX_VALUE,max=0;
        boolean a = false;
        while(fast!=null){
            if((med.val>slow.val && med.val>fast.val) || (med.val<slow.val && med.val<fast.val)){
                a=true;
                if(maxc>max){
                    max=maxc;
                }
                if(minc!=0 && minc<min){
                    min=minc;
                }
                minc=0;
            }
            if(a==true){
                maxc++;
                minc++;
            }
            slow=med;
            med = fast;
            fast = fast.next;
        }
        if(max==0){
            return arr;
        }
        arr[0]=min;
        arr[1]=max;
        return arr;
    }
}