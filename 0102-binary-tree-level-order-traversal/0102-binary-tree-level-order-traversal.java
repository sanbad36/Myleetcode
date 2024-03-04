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
public class Solution {
List<List<Integer>> levelOrder = new LinkedList<List<Integer>>();
    
    private void getLevelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int count=1;
        
        List<Integer> temp = new LinkedList<Integer>();

        while(!queue.isEmpty()){
            TreeNode curr=queue.poll();
          
            if(curr.left != null){
                queue.add(curr.left);
            }
             if(curr.right != null){
                queue.add(curr.right);
            }
            temp.add(curr.val);
             if (--count == 0) {
	            levelOrder.add(new LinkedList<Integer>(temp));
	            temp.clear();
	            count = queue.size();
	        }
           
           
        }
    }


    public List<List<Integer>> levelOrder(TreeNode A) {
        if (A == null) return levelOrder;
        getLevelOrder(A);
        return levelOrder;
    }
}
