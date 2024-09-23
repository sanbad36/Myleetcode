class Solution {
       public int minExtraChar(String s, String[] dictionary) {
        Set<String> dict = new HashSet<>();
        for (String word : dictionary) {
            dict.add(word);
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;  
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String substring = s.substring(i, j + 1);
                if (dict.contains(substring)) {
                    dp[j + 1] = Math.min(dp[j + 1], dp[i]);
                }
            }
            dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
        }
        return dp[n];
    
    }
}