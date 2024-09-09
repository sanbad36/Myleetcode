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
    public int[][] spiralMatrix(int n, int m, ListNode head) {
        int[][]ans=new int[n][m];
        for(int[]i:ans)Arrays.fill(i,-1);
        int top=0,left=0,right=m-1,bottom=n-1;
        int dir=0;
        Deque<Integer> q=new ArrayDeque<>();
        while(head!=null){
            q.offerLast(head.val);
            head=head.next;
        }
        while(!q.isEmpty()&&top<=bottom&&left<=right){
            if(dir==0){
                for(int i=left;i<=right&&!q.isEmpty();i++){
                    ans[top][i]=q.pollFirst();
                }
                top++;
            }else if(dir==1){
                for(int i=top;i<=bottom&&!q.isEmpty();i++){
                    ans[i][right]=q.pollFirst();
                }
                right--;
            }else if(dir==2){
                for(int i=right;i>=left&&!q.isEmpty();i--){
                    ans[bottom][i]=q.pollFirst();
                }
                bottom--;
            }else{
                for(int i=bottom;i>=top&&!q.isEmpty();i--){
                    ans[i][left]=q.pollFirst();
                }
                left++;
            }
            dir=(dir+1)%4;
        }
        return ans;
    }
}