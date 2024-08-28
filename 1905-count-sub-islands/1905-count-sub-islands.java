class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
     int m = grid2.length, n = grid2[0].length;
        int subIslandCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    if (dfs(grid1, grid2, i, j)) {
                        subIslandCount++;
                    }
                }
            }
        }

        return subIslandCount;
    }

    private boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {
        int m = grid2.length, n = grid2[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || grid2[i][j] == 0) {
            return true;
        }

        if (grid1[i][j] == 0) {
            return false;
        }

        grid2[i][j] = 0;

        boolean isSubIsland = true;

        // Check all 4 directions
        isSubIsland &= dfs(grid1, grid2, i - 1, j); // Up
        isSubIsland &= dfs(grid1, grid2, i + 1, j); // Down
        isSubIsland &= dfs(grid1, grid2, i, j - 1); // Left
        isSubIsland &= dfs(grid1, grid2, i, j + 1); // Right

        return isSubIsland;
    }
}