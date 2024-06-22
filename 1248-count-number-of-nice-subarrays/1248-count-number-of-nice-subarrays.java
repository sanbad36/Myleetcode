class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
        int n = nums.length;
        
        for(int i=0;i<n;i++){
            if(nums[i] % 2 == 0)  nums[i] = 0;
            else nums[i] = 1;
        }
    
        // a+b
        int count = 0;
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<n;i++){
            sum += nums[i];
            if(map.containsKey(sum - k)){
                count += map.get(sum - k);
            }
            if(sum == k) count++;
            map.put(sum, map.getOrDefault(sum,0) + 1);
        }
        
        return count;
        
    }
}