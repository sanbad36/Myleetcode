class Solution {
    
    private boolean targetSubSetSum(int index, int[] nums, int target, int[][] dp){
        if(target == 0) return true;
        if(index == 0) return nums[index] == target;
        
        if(dp[index][target] != -1) return dp[index][target] == 0 ? false : true;
        
        boolean notTaken = targetSubSetSum(index - 1, nums, target, dp);
        
        boolean taken = false;
        
        if(nums[index] <= target){
            taken = targetSubSetSum(index - 1, nums, target - nums[index], dp);
        }
        dp[index][target] = notTaken || taken ? 1 : 0;
        
        return notTaken || taken; 
    }
    
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        int n = nums.length;
        for(int num : nums){
            totalSum += num;
        }  
        if(totalSum % 2 == 1) return false;
        int halfOfTotalSum  = totalSum / 2;
        
        int dp[][] = new int[n][halfOfTotalSum + 1];
        
        for(int row[] : dp){
            Arrays.fill(row, -1);
        }
        return targetSubSetSum(n-1, nums, halfOfTotalSum, dp);
    }
}