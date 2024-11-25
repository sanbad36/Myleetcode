import java.util.*;

class Solution {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        StringBuilder start = new StringBuilder();
        for (int[] row : board) {
            for (int num : row) {
                start.append(num);
            }
        }

        int[][] neighbors = {
            {1, 3},    // 0 can move to 1 or 3
            {0, 2, 4}, // 1 can move to 0, 2, or 4
            {1, 5},    // 2 can move to 1 or 5
            {0, 4},    // 3 can move to 0 or 4
            {1, 3, 5}, // 4 can move to 1, 3, or 5
            {2, 4}     // 5 can move to 2 or 4
        };

        // BFS setup
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(start.toString());
        visited.add(start.toString());

        int moves = 0;

        // Perform BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                // Check if we've reached the target state
                if (current.equals(target)) {
                    return moves;
                }
                // Find the position of 0
                int zeroPos = current.indexOf('0');
                // Generate all possible moves
                for (int neighbor : neighbors[zeroPos]) {
                    String next = swap(current, zeroPos, neighbor);
                    if (!visited.contains(next)) {
                        queue.add(next);
                        visited.add(next);
                    }
                }
            }
            moves++;
        }

        return -1;
    }

    private String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}
