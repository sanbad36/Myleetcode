class Solution {
     public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;  // we start from 1, so decrement k by 1 to make it zero-based
        
        while (k > 0) {
            int steps = calculateSteps(n, curr, curr + 1);
            
            // If the number of steps to go under 'curr' is less than k,
            // we know that the kth number is not in this subtree.
            if (steps <= k) {
                curr++;   // move to the next number
                k -= steps; // decrement k by the number of steps we've just skipped
            } else {
                curr *= 10; // go deeper into the tree (i.e., move to the next level)
                k--;  // we move one step down
            }
        }
        return curr;
    }

    // Helper function to calculate how many numbers exist between prefix and the next prefix
    private int calculateSteps(int n, long curr, long next) {
        int steps = 0;
        while (curr <= n) {
            steps += Math.min(n + 1, next) - curr; // Add the range of numbers between curr and next
            curr *= 10;
            next *= 10;
        }
        return steps;
    }
    
}