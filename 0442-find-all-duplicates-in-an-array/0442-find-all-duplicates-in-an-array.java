class Solution {
    public List<Integer> findDuplicates(int[] nums) {
          List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // Get the index (1-indexed)

            if (nums[index] < 0) { // If negative, it means we've seen this number before
                result.add(index + 1); // Add it to the result (convert back to 1-indexed)
            } else {
                nums[index] = -nums[index]; // Mark the index as visited by making it negative
            }
        }

        return result;
    }
}