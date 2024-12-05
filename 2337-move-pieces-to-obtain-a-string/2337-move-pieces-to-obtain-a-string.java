class Solution {
    public boolean canChange(String start, String target) {
      
        
        
        
        String startWithoutBlanks = start.replace("_", "");
        String targetWithoutBlanks = target.replace("_", "");
        if (!startWithoutBlanks.equals(targetWithoutBlanks)) {
            return false;
        }
        
        int n = start.length();
        int i = 0, j = 0;

        while (i < n && j < n) {
            // Skip blank spaces in `start` and `target`
            while (i < n && start.charAt(i) == '_') i++;
            while (j < n && target.charAt(j) == '_') j++;

            // If both pointers reach the end, the strings are valid
            if (i == n && j == n) return true;

            // If one pointer reaches the end before the other, return false
            if (i == n || j == n) return false;

            // Check if the characters at the pointers are the same
            if (start.charAt(i) != target.charAt(j)) return false;

            if (start.charAt(i) == 'L' && i < j) return false; // 'L' cannot move right
            if (start.charAt(i) == 'R' && i > j) return false; // 'R' cannot move left
            i++;
            j++;
        }

        return true;
    }
}