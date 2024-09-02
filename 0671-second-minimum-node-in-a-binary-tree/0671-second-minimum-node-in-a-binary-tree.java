/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        recursion(root);
        return (second == Long.MAX_VALUE)?-1:(int)second;
    }

    long first = Long.MAX_VALUE, second = Long.MAX_VALUE;
    public void recursion(TreeNode root){
        if(root == null){
            return;
        }

        first = Math.min(root.val, first);
        if(root.val > first && root.val < second){
            second = root.val;
        }

        recursion(root.left);
        recursion(root.right);
    }
}