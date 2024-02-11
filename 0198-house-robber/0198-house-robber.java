class Solution {
    
    public static int slove(int idx,int [] nums){
     
       int  prev = nums[0];
       int  prev1 = 0;
        for(int i=1;i<nums.length;i++){
            int take = nums[i] + prev1;
            int nottake =0 + prev;
            int current = Math.max(take,nottake);
            prev1 = prev;
            prev = current;
        }
        return prev;  
    }
    public int rob(int[] nums){
        int n = nums.length;
        return slove(n-1,nums);
    }
    
}