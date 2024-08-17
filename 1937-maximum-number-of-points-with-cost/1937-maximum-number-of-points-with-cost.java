class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;

        long[] prevRow = new long[n];
        for (int i = 0; i < n; i++) {
            prevRow[i] = points[0][i];
        }

        for (int i = 1; i < m; i++) {
            long[] leftMax = new long[n];
            long[] rightMax = new long[n];
            long[] currRow = new long[n];

            leftMax[0] = prevRow[0];
            for (int j = 1; j < n; j++) {
                leftMax[j] = Math.max(leftMax[j - 1], prevRow[j] + j);
            }

            rightMax[n - 1] = prevRow[n - 1] - (n - 1);
            for (int j = n - 2; j >= 0; j--) {
                rightMax[j] = Math.max(rightMax[j + 1], prevRow[j] - j);
            }

            for (int j = 0; j < n; j++) {
                currRow[j] = points[i][j] + Math.max(leftMax[j] - j, rightMax[j] + j);
            }

            prevRow = currRow;
        }

        long maxPoints = 0;
        for (long val : prevRow) {
            maxPoints = Math.max(maxPoints, val);
        }
        return maxPoints;
    }
}