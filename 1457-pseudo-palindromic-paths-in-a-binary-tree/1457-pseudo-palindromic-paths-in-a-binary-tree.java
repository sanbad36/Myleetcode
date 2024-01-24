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
    int count;
    public int pseudoPalindromicPaths (TreeNode root) {
        count=0;
        traversal(root, new HashSet<>());
        return count;
    }
    public void traversal(TreeNode root, HashSet<Integer> set){
        if(root==null)
            return;
        if(root.left==null && root.right==null)
        {
           if(set.contains(root.val)){
               set.remove(root.val);
           }
           else{
               set.add(root.val);
           }
           if(set.size()<2){
               count++;
           }
           return;
        }
        if(set.contains(root.val)){
            set.remove(root.val);
        }
        else{
            set.add(root.val);
        }
        traversal(root.left,new HashSet<>(set));
        traversal(root.right,new HashSet<>(set));
    }
}