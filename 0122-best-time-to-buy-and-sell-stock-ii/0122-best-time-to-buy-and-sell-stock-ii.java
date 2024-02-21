class Solution {
    int memo(int ind , int b , int n,int p[], int dp[][]){
        if(ind==n) return 0;
        
        int sum=0;

        if(dp[ind][b]!=-1) return dp[ind][b];
        if(b==1)
        sum=Math.max(-p[ind]+memo(ind+1,0,n,p,dp) , memo(ind+1,1,n,p,dp));
        else
        sum=Math.max(p[ind]+memo(ind+1,1,n,p,dp),  memo(ind+1,0,n,p,dp));

        return dp[ind][b]=sum;
    }
    public int maxProfit(int[] p) {
        int len=p.length;
        
        int  dp[][]=new int [len][2];
        for(int i=0;i<len;i++){
            dp[i][0]=-1;
            dp[i][1]=-1;
        }
        return memo(0,1,len,p,dp);
    }
}