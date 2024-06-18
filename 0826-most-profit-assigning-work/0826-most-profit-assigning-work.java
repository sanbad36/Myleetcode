class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
         int maxProfit = 0;
        
        // Iterate through each worker
        for (int ability : worker) {
            int best = 0;
            // Iterate through each job
            for (int i = 0; i < difficulty.length; i++) {
                if (ability >= difficulty[i]) {
                    best = Math.max(best, profit[i]);
                }
            }
            maxProfit += best;
        }
        
        return maxProfit;
    }
}