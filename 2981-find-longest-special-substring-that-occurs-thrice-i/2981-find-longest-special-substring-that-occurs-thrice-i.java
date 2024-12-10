class Solution {
    public int maximumLength(String s) {
     
        int n = s.length();
        int longest= -1;
        
        
        for (int len = 1; len <= n; len++) {
            
            
        Map<String, Integer> substringCount = new HashMap<>();

            for (int i = 0; i <= n - len; i++) {
                String substring = s.substring(i, i + len);

                if (isSpecial(substring)) {
                    substringCount.put(substring, substringCount.getOrDefault(substring, 0) + 1);

                    // If it occurs at least three times, update the longest   length
                    if (substringCount.get(substring) >= 3) {
                        longest = Math.max(longest, len);
                    }
                }
            }
        }
return longest;
    }

// Helper function to check if a string is "special"
    private static boolean isSpecial(String str) {
      char firstChar = str.charAt(0);
        for (char c : str.toCharArray()) {
            if (c != firstChar) return false;
        }
        return true;
    }
}