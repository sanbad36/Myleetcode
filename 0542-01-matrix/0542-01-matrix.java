class Solution {
    
    class Node{
        public int row;
        public int col;
        public int step;
        public Node(int row, int col, int step){
            this.row = row;
            this.col = col;
            this.step = step;
        }  
    }
    
    private int[][] findNearest(int[][] mat, int n, int m){
        int delRow[] = {-1,0,1,0};
        int delCol[] = {0,1,0,-1};
        
        int visited[][] = new int[n][m];
        int distanceMatrix[][] = new int[n][m];
        
        Queue<Node> queue = new LinkedList<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == 0){
                    queue.add(new Node(i,j,0));
                    visited[i][j] = 1;
                }
                else{
                    visited[i][j] = 0;
                }          
            }
        }
        
        while(!queue.isEmpty()){
            
            int row = queue.peek().row;
            int col = queue.peek().col;
            int step = queue.peek().step;  
            queue.remove();
            distanceMatrix[row][col] = step;
            
            for(int i=0; i<4; i++){
              
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                
                if(nrow >=0 && nrow < n && ncol >=0 && ncol < m && visited[nrow][ncol] != 1){
                    visited[nrow][ncol] = 1;
                    queue.add(new Node(nrow, ncol, step + 1));
                }  
            }             
        }       
       return distanceMatrix;         
    }
    
    public int[][] updateMatrix(int[][] mat) {
        
        int n = mat.length;
        int m = mat[0].length;
        return findNearest(mat,n,m);          
    }
}