class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int rightProd[] = new int[n];
        rightProd[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            rightProd[i]=rightProd[i+1]*nums[i];
        }
        
        int lp=1;
        
        for(int i=0;i<=n-2;i++ ){
            
            rightProd[i]=lp*rightProd[i+1];
            lp *= nums[i];  
        }
        rightProd[n-1]=lp;
        return rightProd;
    }
}