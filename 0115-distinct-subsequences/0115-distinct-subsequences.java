class Solution {
    
    static int prime = (int) (Math.pow(10, 9) + 7);
    
     static int countUtil(String s1, String s2, int ind1, int ind2, int[][] dp) {
        if (ind2 < 0)
            return 1;
         
        if (ind1 < 0)
            return 0;
         
        if (dp[ind1][ind2] != -1)
            return dp[ind1][ind2];

        if (s1.charAt(ind1) == s2.charAt(ind2)) {
            int leaveOne = countUtil(s1, s2, ind1 - 1, ind2 - 1, dp);
            int stay = countUtil(s1, s2, ind1 - 1, ind2, dp);
            return dp[ind1][ind2] = (leaveOne + stay) % prime;
        } else {
            return dp[ind1][ind2] = countUtil(s1, s2, ind1 - 1, ind2, dp);
        }
    }
     
    public int numDistinct(String s, String t) {
        int ls = s.length();
        int lt = t.length();
        
        int dp[][] = new int[ls][lt];
        for (int rows[] : dp)
            Arrays.fill(rows, -1);
        return countUtil(s, t, ls - 1, lt - 1, dp);     
    }
}