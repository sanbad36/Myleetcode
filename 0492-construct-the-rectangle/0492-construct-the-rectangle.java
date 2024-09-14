class Solution {
    public int[] constructRectangle(int area) {
        int[] bestDimensions = new int[2]; // Array to hold best length and width
        int minDifference = Integer.MAX_VALUE; // Initialize with a large number

        for (int i = 1; i * i <= area; i++) { // Loop up to the square root of the area
            if (area % i == 0) {
                int l = i;
                int w = area / i;
                // Ensure l is always the larger dimension
                if (l < w) {
                    int temp = l;
                    l = w;
                    w = temp;
                }
                int difference = Math.abs(l - w);

                // Check if this pair has a smaller difference than the previous best
                if (difference < minDifference) {
                    minDifference = difference;
                    bestDimensions[0] = l; // Set best length
                    bestDimensions[1] = w; // Set best width
                }
            }
        }
        return bestDimensions;
    }
}
