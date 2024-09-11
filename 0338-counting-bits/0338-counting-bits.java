class Solution {
public int[] countBits(int n) {

    int dp[] = new int[n+1];
    
    for(int i=0;i<=n;i++)
    {
        //for even number number of bits is number of bits in [number/2]
        //for odd number number of bits is number of bits in [number/2]+1
        dp[i] = dp[i/2] + i%2; //i%2 is for adding 1 for odd numbers 
    }
    
    return dp;
}
}