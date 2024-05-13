class Solution {
    public int matrixScore(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = n * (1 << (m - 1));

        for (int j = 1; j < m; j++) {
            int colCount = 0;
            for (int i = 0; i < n; i++) 
                colCount += grid[i][0] == 0 ? (grid[i][j] ^ 1) : grid[i][j];

            if (colCount < n - colCount) {
                ans += (n - colCount) * (1 << (m - 1 - j));
            } else {
                ans += (colCount) * (1 << (m - 1 - j));
            }
        }
        return ans;
    }
}