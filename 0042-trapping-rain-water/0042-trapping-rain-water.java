class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int left = 0;
        int right = n-1;
        int res=0;
        int leftMax=0,rightMax=0;
        
        while(left<=right){
            
            if(height[left]<height[right]){
                if(height[left]>leftMax){
                    leftMax=height[left];
                }else{
                    res+= leftMax-height[left];
                }
                left++;
                
            }
            else{
                if(height[right]>rightMax){
                    rightMax=height[right];
                    
                }else{
                    res += rightMax-height[right];
               
                }
                right--;
            }
            
        }
        return res;
        
        }
        
    }