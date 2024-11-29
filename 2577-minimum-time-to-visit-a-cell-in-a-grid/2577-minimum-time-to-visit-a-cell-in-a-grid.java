class Solution {
    public int minimumTime(int[][] grid) {
        if(grid[0][1] > 1 && grid[1][0] > 1) return -1;
        int m = grid.length, n = grid[0].length;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]); 
        pq.add(new int[]{0, 0, 0});//int[step, i, j]
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        while(!pq.isEmpty()){
            int[] cur = pq.poll(); //current smallest step
            for(int[] direction : directions){
                int i = cur[1] + direction[0];
                int j = cur[2] + direction[1];
                if(i < 0 || i == m || j < 0 || j == n || visited[i][j]) continue;
                visited[i][j] = true;
                int step = cur[0] + 1;
                if(grid[i][j] > step) step = (grid[i][j] - step) % 2 + grid[i][j];
                if(i == m - 1 && j == n - 1) return step;
                pq.add(new int[]{step , i, j});
            }     
        }
        return -1;
    }
}