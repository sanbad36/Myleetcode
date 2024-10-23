class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null)
            return root;

        TreeNode res = new TreeNode(0);
        Queue<TreeNode> resq = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        resq.offer(res);
        while (!q.isEmpty()) {
            int size = q.size();
            TreeNode[] t = new TreeNode[size];
            int sum = 0;
            for (int i = 0; i < size; i++) {
                t[i] = q.poll();
                if (t[i].left != null) {
                    q.offer(t[i].left);
                    sum += t[i].left.val;
                }
                if (t[i].right != null) {
                    q.offer(t[i].right);
                    sum += t[i].right.val;
                }
            }
            for (int i = 0; i < size; i++) {
                TreeNode curr = resq.poll();
                int cusins = sum - (t[i].left != null ? t[i].left.val : 0) - (t[i].right != null ? t[i].right.val : 0);
                if (t[i].left != null) {
                    curr.left = new TreeNode(cusins);
                    resq.offer(curr.left);
                }
                if (t[i].right != null) {
                    curr.right = new TreeNode(cusins);
                    resq.offer(curr.right);
                }
            }
        }
        return res;
    }
}