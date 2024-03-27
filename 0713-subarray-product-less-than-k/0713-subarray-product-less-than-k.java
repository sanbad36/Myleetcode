class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
         if (k <= 1) return 0;
        int i=0;
        int ans=0;
        int prod=1;
        int n = nums.length;
        int j=0;
        while(i<n){
            prod *= nums[i];
            while(prod>=k)
            {   prod /= nums[j++];
                 
            }
            ans += i-j + 1;
            i++;
        }
        return ans;
    }
}