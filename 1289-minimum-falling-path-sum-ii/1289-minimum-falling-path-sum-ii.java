class Solution {
    public int minFallingPathSum(int[][] grid) {
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        int index = 0;
        int n = grid.length;
        for (int i = n - 1; i >= 0; i--) {
        int newfirstMin = Integer.MAX_VALUE;
        int newsecondMin = Integer.MAX_VALUE;
        int newindex = -1;
            for (int j = 0; j < n; j++) {
                if (i != n - 1 && j != index) {
                    grid[i][j] += firstMin;
                }
                if (i != n - 1 && j == index) {
                    grid[i][j] += secondMin;
                }
                if (grid[i][j] == newfirstMin) {
                    newsecondMin = newfirstMin;
                    continue;
                }
                if (grid[i][j] < newfirstMin) {
                    if(newsecondMin!=Integer.MAX_VALUE){
                        newsecondMin= newfirstMin;
                    }
                    newfirstMin = grid[i][j];
                    newindex = j;
                    continue;
                }
                if (grid[i][j] > newfirstMin) {
                    newsecondMin = Integer.min(newsecondMin, grid[i][j]);
                }
            }
            firstMin=newfirstMin;
            secondMin=newsecondMin;
            index=newindex;
        }
        return firstMin;
    }

}