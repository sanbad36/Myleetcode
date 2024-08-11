class Solution {
     private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int minDays(int[][] grid) {
        if (!isConnected(grid)) return 0; // Already disconnected
        
        int n = grid.length, m = grid[0].length;
        
        // Try removing one land cell
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (!isConnected(grid)) return 1; // Disconnected by removing one cell
                    grid[i][j] = 1; // Revert the change
                }
            }
        }
        
        // Try removing two land cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    for (int x = 0; x < n; x++) {
                        for (int y = 0; y < m; y++) {
                            if (grid[x][y] == 1) {
                                grid[x][y] = 0;
                                if (!isConnected(grid)) return 2; // Disconnected by removing two cells
                                grid[x][y] = 1; // Revert the change
                            }
                        }
                    }
                    grid[i][j] = 1; // Revert the change
                }
            }
        }
        
        return 3; // The grid requires at least three days to disconnect
    }
    
    private boolean isConnected(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        boolean foundLand = false;
        int[] start = new int[2];
        
        // Find the first land cell
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    start[0] = i;
                    start[1] = j;
                    foundLand = true;
                    break;
                }
            }
            if (foundLand) break;
        }
        
        if (!foundLand) return false; // No land, thus disconnected
        
        // Use BFS or DFS to mark all connected land cells
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        int landCells = 0;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            landCells++;
            for (int[] dir : DIRECTIONS) {
                int newX = curr[0] + dir[0];
                int newY = curr[1] + dir[1];
                if (newX >= 0 && newX < n && newY >= 0 && newY < m && !visited[newX][newY] && grid[newX][newY] == 1) {
                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
        
        // Check if the number of visited cells equals the number of land cells
        int totalLandCells = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) totalLandCells++;
            }
        }
        
        return landCells == totalLandCells; // Connected if all land cells are visited
    }

}