class Solution {
    
    static int util(int[] arr, int ind, int T, int[][] dp){

        if(ind == 0){
            if(T%arr[0] == 0) return 1;
            else return 0;
        }

        if(dp[ind][T]!=-1)
            return dp[ind][T];

        int notTaken = util(arr,ind-1,T,dp);

        int taken = 0;
        if(arr[ind] <= T)
            taken = util(arr,ind,T-arr[ind],dp);

        return dp[ind][T] = notTaken + taken;
}
    
    public int change(int amount, int[] coins) {
        
        int n= coins.length;
        int[][] dp=new int[n][amount+1];
        for(int row[]: dp)
        Arrays.fill(row,-1);
        int ans =  util(coins, n-1, amount, dp);
        return ans;
    }
}