class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        if(n==1) return 1;
        int dp[] = new int[n];
        dp[0] = 1;
        int current_max = 0;
        int overall_max=0;
        
        for(int i=1 ; i<n ; i++)
        {
            current_max = 0;
            for(int j=0 ; j<i ; j++)
            {
                if(nums[j] < nums[i])
                    if(dp[j] > current_max)
                        current_max = dp[j];    
                dp[i] = current_max + 1;
                overall_max = (dp[i] > overall_max ? dp[i] : overall_max);
            }
        }
        return overall_max;   
    }
}