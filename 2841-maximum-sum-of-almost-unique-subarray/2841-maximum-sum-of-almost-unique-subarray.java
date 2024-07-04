class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        
        if(nums.size() < k) return 0;
        
        long maxSum = 0;
        long currentSum = 0;
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        for(int start = 0; start < k ; start++){
            currentSum += nums.get(start);
            frequencyMap.put(nums.get(start), frequencyMap.getOrDefault(nums.get(start),0) + 1 );
        }
        
        if(frequencyMap.size() >= m){
            maxSum = currentSum;
        }
        
        for(int i = k; i < nums.size(); i++){
            
            currentSum += nums.get(i);
            frequencyMap.put(nums.get(i), frequencyMap.getOrDefault(nums.get(i),0)+ 1 );
            
            currentSum -= nums.get(i-k);
            
            if(frequencyMap.get(nums.get(i-k)) == 1){
                frequencyMap.remove(nums.get(i-k));
            }else{
                frequencyMap.put(nums.get(i-k), frequencyMap.get(nums.get(i-k)) - 1);
            }
            
            if(frequencyMap.size() >= m){
                maxSum = Math.max(currentSum, maxSum);
            }             
        }   
        return maxSum;    
    }
}