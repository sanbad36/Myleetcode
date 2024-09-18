class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] arr = new String[n];
        for(int i = 0; i < n; i++){
            arr[i] = String.valueOf(nums[i]);
        }
        
        for(int i = 0; i < n - 1; i++){
            
            int min = i;
            for(int j = i + 1; j < n; j++){
                
                String s1 = arr[min] + arr[j];
                String s2 = arr[j] + arr[min];
                if(s2.compareTo(s1) > 0) { // if s2 is lexicographically greater than s1
                    min = j;
                }
            }
            String s = arr[i];
            arr[i] = arr[min];
            arr[min] = s;
        }
        
        if(arr[0].charAt(0) == '0'){
            return "0";
        }
        
        String ret = "";
        for(int i = 0; i < n; i++){
            ret += arr[i];
        }
        
        return ret;   
    }
}