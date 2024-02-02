class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int[][] ans = image;
        int initialColor = image[sr][sc];  
        int[] delRow = {1,0,-1,0};
        int[] delCol = {0,1,0,-1};
        dfs(sr,sc,initialColor,color,image,ans,n,m,delRow,delCol);
        return ans;   
    }  
    private void dfs(int row, int col, int initialColor, int newColor, int[][] image, int[][]ans, int n, int m, int[] delRow, int[] delCol){
        ans[row][col] = newColor;
        for(int i=0; i<4; i++){
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if(nRow >=0 && nRow < n && nCol >=0 && nCol < m && image[nRow][nCol] == initialColor && ans[nRow][nCol] != newColor)
                dfs(nRow, nCol, initialColor, newColor, image, ans, n, m, delRow, delCol);       
        }            
    }    
}