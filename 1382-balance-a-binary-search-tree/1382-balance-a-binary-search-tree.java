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
      public TreeNode balanceBST(TreeNode root) {
        List<Integer> sortedList = new ArrayList<>();
        inorderTraversal(root, sortedList);
        return sortedListToBST(sortedList, 0, sortedList.size() - 1);
    }

    // Helper function to perform in-order traversal and collect values
    private void inorderTraversal(TreeNode root, List<Integer> sortedList) {
        if (root == null) return;
        inorderTraversal(root.left, sortedList);
        sortedList.add(root.val);
        inorderTraversal(root.right, sortedList);
    }

    // Helper function to construct a balanced BST from a sorted list
    private TreeNode sortedListToBST(List<Integer> sortedList, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(sortedList.get(mid));
        node.left = sortedListToBST(sortedList, left, mid - 1);
        node.right = sortedListToBST(sortedList, mid + 1, right);
        return node;
    }
}