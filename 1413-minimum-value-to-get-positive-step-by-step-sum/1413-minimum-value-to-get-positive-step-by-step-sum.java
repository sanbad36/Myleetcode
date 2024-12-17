class Solution {
    public int minStartValue(int[] nums) {
        int sum = 0, ans = 1;
        for(int num:nums)
        {
            sum+=num;
            if(sum<0)
                ans = Math.max(ans,Math.abs(sum)+1);
        }
        return ans;
    }
}