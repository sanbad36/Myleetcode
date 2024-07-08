class Solution {
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node newone(int n) {
        Node first = new Node(1);
        Node curr = first;
        for (int i = 2; i <= n; i++) {
            Node temp = new Node(i);
            curr.next = temp;
            curr = temp;

        }
        curr.next = first;
        return curr;
    }

    public int findTheWinner(int n, int k) {
        Node prev = newone(n);
        Node curr = prev.next;

        while (n > 1) {
            int count = (k - 1) % n;
            while (count > 0) {
                prev = curr;
                curr = curr.next;
                count--;
            }

            prev.next = curr.next;
            curr = curr.next;
            n--;
        }

        return curr.data;
    }
}