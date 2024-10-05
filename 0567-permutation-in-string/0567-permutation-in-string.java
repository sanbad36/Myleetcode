class Solution {
    public boolean checkInclusion(String s1, String s2) {
            int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        
        for (char c : s1.toCharArray()) {
            s1Count[c - 'a']++;
        }
        
        int windowLength = s1.length();
        int s2Length = s2.length();
        
        for (int i = 0; i < s2Length; i++) {
            s2Count[s2.charAt(i) - 'a']++;
            
            if (i >= windowLength) {
                s2Count[s2.charAt(i - windowLength) - 'a']--;
            }
            
            if (Arrays.equals(s1Count, s2Count)) {
                return true;
            }
        }
        
        return false;
    }
}