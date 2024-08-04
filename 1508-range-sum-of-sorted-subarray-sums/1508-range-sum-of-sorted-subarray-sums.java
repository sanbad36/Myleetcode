class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
          int MOD = 1000000007;
        List<Integer> subarraySums = new ArrayList<>();
        
        // Calculate all subarray sums
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                subarraySums.add(sum);
            }
        }
        
        // Sort the sums
        Collections.sort(subarraySums);
        
        // Calculate the sum of the elements from index left to right
        long result = 0;
        for (int k = left - 1; k < right; k++) {
            result = (result + subarraySums.get(k)) % MOD;
        }
        
        return (int) result;
    }
}