/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return root;

        Queue<Pair<Node, Integer>> queue = new LinkedList<>();
        Map<Integer, Node> prevNodeByLevel = new HashMap<>();
        queue.add(new Pair<>(root, 0));

        while (!queue.isEmpty()) {
            Pair<Node, Integer> pair = queue.poll();
            Node node = pair.getKey();
            int level = pair.getValue();

            if (prevNodeByLevel.containsKey(level)) {
                prevNodeByLevel.get(level).next = node;
            }

            if (node.left != null) {
                queue.add(new Pair<>(node.left, level + 1));
            }

            if (node.right != null) {
                queue.add(new Pair<>(node.right, level + 1));
            }

            prevNodeByLevel.put(level, node);
        }

        return root;
    }
}
