class Solution {
    private void dfs(int row, int col, int[][] visited, char[][] board, int[] delRow, int[]delCol, int n, int m){
        visited[row][col] = 1;
        for(int i=0; i<4; i++){ 
            int nrow = row + delRow[i];
            int ncol = col + delCol[i]; 
            if(nrow >=0 && nrow < n && ncol >=0 && ncol < m && visited[nrow][ncol] != 1 && board[nrow][ncol] != 'X'){
                dfs(nrow, ncol, visited, board, delRow, delCol, n, m);
            }        
        }     
    }
    
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int delRow[] = {-1,0,1,0};
        int delCol[] = {0,1,0,-1}; 
        int visited[][] = new int[n][m];
        
        // traverse the first row and last row
        for(int i=0;i<m; i++){  
            if(visited[0][i] == 0 && board[0][i] == 'O'){
                dfs(0,i,visited, board, delRow, delCol,n,m);
            } 
            if(visited[n-1][i] == 0 && board[n-1][i] == 'O'){
                dfs(n-1, i, visited, board, delRow, delCol, n, m);
            }
        }  
        
        for(int i=0;i<n; i++){  
            if(visited[i][0] == 0 && board[i][0] == 'O'){
                dfs(i,0,visited, board, delRow, delCol,n,m);
            } 
            if(visited[i][m-1] == 0 && board[i][m-1] == 'O'){
                dfs(i, m-1, visited, board, delRow, delCol, n, m);
            }
        }
        
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){    
                if(board[i][j] == 'O' && visited[i][j] != 1){
                    board[i][j] = 'X';
                }     
            }
        }
    }
}