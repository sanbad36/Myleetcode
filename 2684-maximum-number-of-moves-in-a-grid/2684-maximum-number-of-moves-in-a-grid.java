class Solution {
    public int maxMoves(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        int[][] dp = new int[n][m];
        for (int col = m - 2; col >= 0; col--) {
            for (int row = 0; row < n; row++) {
                int g = grid[row][col];
                if (row - 1 >= 0 && grid[row - 1][col + 1] > g) {
                    dp[row][col] = Math.max(dp[row][col],
                            1 + dp[row - 1][col + 1]);
                }
                if (grid[row][col + 1] > g) {
                    dp[row][col] = Math.max(dp[row][col], 1 + dp[row][col + 1]);
                }
                if (row + 1 < n && grid[row + 1][col + 1] > g) {
                    dp[row][col] = Math.max(dp[row][col],
                            1 + dp[row + 1][col + 1]);
                }
            }
        }

        int count = 0;
        for (int[] d : dp) {
            count = Math.max(count, d[0]);
        }
        return count;
    }
}