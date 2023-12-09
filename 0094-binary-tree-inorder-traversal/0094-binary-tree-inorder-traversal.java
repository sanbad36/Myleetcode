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
    List<Integer> res  = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    } 
    public void helper(TreeNode t,List<Integer> res){
            if(t!=null){    
                helper(t.left,res);
                res.add(t.val);
                helper(t.right,res);      
            }
    }     
}