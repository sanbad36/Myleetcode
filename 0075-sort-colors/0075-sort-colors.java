class Solution {
    
//     public static void swap(int n1,int n2){
//         int temp=n1;
//         n1=n2;
//         n2=temp;
//     }
    
    
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low=0;
        int high=n-1;
        int mid=0;
        
        while(mid<=high){
            switch(nums[mid]){
                case 0:
                   nums[low]= nums[low] ^nums[mid] ^ (nums[mid] =nums[low]);
                    // swap(  nums[low],nums[mid])
                  
                    low++;
                    mid++;
                    break;
                
                case 1: 
                    mid++;
                    break;
                    
                case 2: 
                    nums[mid]= nums[mid] ^nums[high] ^ (nums[high] =nums[mid]);
                   high--;
                    break;
                    
            }
            
        }

    }
}