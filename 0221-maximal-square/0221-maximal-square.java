class Solution {
    public int maximalSquare(char[][] matrix) {
        int dp[][] = new int[matrix.length+1][matrix[0].length+1];
        int max =0;
        for(int i=1;i<=matrix.length;i++){
            for(int j=1;j<=matrix[0].length;j++){
                if(matrix[i-1][j-1]=='0'){
                    dp[i][j]=0;
                }else{
                    dp[i][j] =Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    max= Math.max(max,dp[i][j]);
                }
            }
        }
        return max*max;
        
    }
}