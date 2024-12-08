class Solution {
    public int minimumSize(int[] nums, int maxOperations) {

        int low=1, high=Arrays.stream(nums).max().getAsInt();
        int ans = 1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if (solve(mid,nums,nums.length,maxOperations)) {
                ans=mid;
                high=mid-1;
            } else {
                low=mid+1;
            }
        }
        return ans;
    }

    public boolean solve(int mid,int arr[],int n,int maxi){
        long op=0l;
        for(int i=0;i<n;i++){
            if(arr[i]>mid){
            op+=(arr[i]-1)/(long)mid;
           } 
        }
        return op<=(long)maxi;
    }
}