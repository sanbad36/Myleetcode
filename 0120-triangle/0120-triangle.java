class Solution {
    
    private int findMinimumTotalUtil(int i, int j, List<List<Integer>> triangle, int[][]dp, int n ){
        if(i == n-1) return triangle.get(n-1).get(j);
        if(dp[i][j] != -1) return dp[i][j];
        int down = triangle.get(i).get(j) + findMinimumTotalUtil(i+1,j, triangle,dp,n);
        int diagonal = triangle.get(i).get(j) + findMinimumTotalUtil(i+1,j+1,triangle,dp,n); 
        return dp[i][j] = Math.min(down,diagonal);
    }
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];
        for(int row[] : dp){
            Arrays.fill(row, -1);
        }
        return findMinimumTotalUtil(0,0,triangle,dp,n);
    }
}