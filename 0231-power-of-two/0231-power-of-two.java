class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0)
        return false;

        int result= (n&(n-1));
        if(result==0)
        return true;
        return false;
    }

}