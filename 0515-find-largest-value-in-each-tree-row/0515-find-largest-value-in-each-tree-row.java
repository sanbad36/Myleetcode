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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int maxVal = Integer.MIN_VALUE; 
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                maxVal = Math.max(maxVal, currentNode.val); 
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);    
            }  
            result.add(maxVal);
        }
        return result;
    }
}


/*

       1
       / \
      3   2
     / \    \
    5   3    9
Steps:
Level 0: [1] → Largest = 1
Level 1: [3, 2] → Largest = 3
Level 2: [5, 3, 9] → Largest = 9

output :
[1, 3, 9]

*/