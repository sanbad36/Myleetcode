class Solution {
    public int firstMissingPositive(int[] nums) {
           int n = nums.length;

        // Mark negative numbers and numbers larger than n as they won't affect the result
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        // Mark the presence of positive integers by changing the sign of the corresponding index
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        // Find the first missing positive integer
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1; // If all positive integers are present, return n + 1    
    }
}