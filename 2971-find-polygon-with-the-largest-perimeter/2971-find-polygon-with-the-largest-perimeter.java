class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long res = -1, cur = 0;
        for (int i = 0; i < nums.length; ++i)
            if ((cur += nums[i]) > nums[i] * 2)
                res = cur;
        return res;
    }  
}