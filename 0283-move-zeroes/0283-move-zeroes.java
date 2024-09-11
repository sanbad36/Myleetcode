class Solution {
    public void moveZeroes(int[] nums) {
        int c = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                c=i;
                break;
            }
        }
        if(c==-1){
            return;
        }

        for(int i=c+1;i<nums.length;i++)
        {
            if(nums[i]!=0){
                int temp = nums[c];
                nums[c] = nums[i];
                nums[i]=temp;
                c++;
            }
        }
        return;
    }
}