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
    Set<Integer> s = new HashSet<>();
    public void traversal(TreeNode root) {
        if (root != null) {
            traversal(root.left);
            s.add(root.val);
            traversal(root.right);
        }
    }
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        traversal(root);
        
        return ((s.size() == 1)? true : false);
    }
}