class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0 || duration == 0) return 0;
        int totalPoisonedTime = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            int timeDifference = timeSeries[i + 1] - timeSeries[i];
            totalPoisonedTime += Math.min(timeDifference, duration);
        }
        totalPoisonedTime += duration;
        return totalPoisonedTime;
    }
}