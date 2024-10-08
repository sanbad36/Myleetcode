class Solution {
    public int minSwaps(String s) {
          int imbalance = 0;
        int swaps = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                imbalance++;
            } else {
                imbalance--;
            }

            if (imbalance < 0) {
                swaps++;
                imbalance = 1;
            }
        }
        return swaps;
    }
}