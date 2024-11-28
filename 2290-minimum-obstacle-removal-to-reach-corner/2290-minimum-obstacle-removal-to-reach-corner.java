class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        // Directions for moving up, down, left, right
        int[][] directions ={{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        // A deque to store the current position and cost
        Deque<int[]> deque = new ArrayDeque<>();
        
        // Array to store the minimum cost to reach each cell
        int[][] cost = new int[m][n];
        for (int[] row :cost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        // Start from (0, 0) with cost 0
        deque.offer(new int[]{0, 0, 0}); // {row, col, cost}
        cost[0][0] = 0;
        
        while (!deque.isEmpty()) {
            int[] current = deque.poll();
            int x = current[0], y = current[1], currCost = current[2];
            
            // If we reach the bottom-right corner, return the cost
            if (x == m - 1 && y == n - 1) {
                return currCost;
            }
            
            // Explore all possible directions
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                
                // Check if the new cell is within bounds
                if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    // Calculate the new cost
                    int newCost = currCost + grid[newX][newY];
                    
                    // If the new cost is better, update it and add to deque
                    if (newCost < cost[newX][newY]) {
                        cost[newX][newY] = newCost;
                        if (grid[newX][newY] == 0) {
                            deque.addFirst(new int[]{newX, newY, newCost}); // Prioritize zero-cost moves
                        } else {
                            deque.addLast(new int[]{newX, newY, newCost}); // Add obstacle moves later
                        }
                }
                }
            }
       }
        
        return -1; // If no path exists (though problem guarantees a solution)
    }
}


/*

Approach
Graph Representation: 

Treat the grid as a graph. Each cell is a node, and you can move up, down, left, or right to adjacent nodes.

Cost of Movement:
Moving to a cell with value 0 has a cost of 0.
Moving to a cell with value 1 has a cost of 1.

Optimal Traversal Algorithm:
Use a 0-1 Breadth-First Search (0-1 BFS) approach. This algorithm is optimal for graphs with edge weights of 0 or 1.
Use a deque (double-ended queue) to keep track of the nodes to process. Nodes with a cost of 0 are added to the front of the deque, and nodes with a cost of 1 are added to the back.

Final Goal:
Start from (0, 0) and traverse the grid while minimizing the number of obstacles removed.
Stop when you reach (m-1, n-1).

*/