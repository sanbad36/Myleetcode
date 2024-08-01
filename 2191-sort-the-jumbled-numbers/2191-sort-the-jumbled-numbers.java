class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int[] result = new int[nums.length];
        int[][] mappedNums = new int[nums.length][2];  
        for (int i = 0; i < nums.length; i++) {
            int original = nums[i];
            int mappedValue = mapNumber(mapping, original);
            mappedNums[i][0] = mappedValue;
            mappedNums[i][1] = i;
        }      
        Arrays.sort(mappedNums, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));       
        for (int i = 0; i < mappedNums.length; i++) {
            result[i] = nums[mappedNums[i][1]];
        }       
        return result;
    }   
    public int mapNumber(int[] mapping, int num) {
        if (num == 0) return mapping[0];    
        int mappedNum = 0;
        int place = 1;
        while (num > 0) {
            int digit = num % 10;
            mappedNum += mapping[digit] * place;
            place *= 10;
            num /= 10;
        }
       
        return mappedNum;
    }
}