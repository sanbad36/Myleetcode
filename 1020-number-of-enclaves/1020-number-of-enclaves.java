class Solution {
    
     private void dfs(int row, int col, int[][] visited, int[][] grid, int[] delRow, int[]delCol, int n, int m){
        visited[row][col] = 1;
        for(int i=0; i<4; i++){ 
            int nrow = row + delRow[i];
            int ncol = col + delCol[i]; 
            if(nrow >=0 && nrow < n && ncol >=0 && ncol < m && visited[nrow][ncol] != 1 && grid[nrow][ncol] != 0){
                dfs(nrow, ncol, visited, grid, delRow, delCol, n, m);
            }        
        }     
    }
    
    public int numEnclaves(int[][] grid) {
    
         int n = grid.length;
        int m = grid[0].length;
        int delRow[] = {-1,0,1,0};
        int delCol[] = {0,1,0,-1}; 
        int visited[][] = new int[n][m];
        
        // traverse the first row and last row
        for(int i=0;i<m; i++){  
            if(visited[0][i] == 0 && grid[0][i] == 1){
                dfs(0,i,visited, grid, delRow, delCol,n,m);
            } 
            if(visited[n-1][i] == 0 && grid[n-1][i] == 1){
                dfs(n-1, i, visited, grid, delRow, delCol, n, m);
            }
        }  
        
        // travese the first col and last col
        for(int i=0;i<n; i++){  
            if(visited[i][0] == 0 && grid[i][0] == 1){
                dfs(i,0,visited, grid, delRow, delCol,n,m);
            } 
            if(visited[i][m-1] == 0 && grid[i][m-1] == 1){
                dfs(i, m-1, visited, grid, delRow, delCol, n, m);
            }
        }
        
        int count=0;
      // final verdict
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){    
                if(grid[i][j] == 1 && visited[i][j] != 1){
                   count ++;
                }     
            }
        }
        return count;
    }              
}