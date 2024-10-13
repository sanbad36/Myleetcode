class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
            PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int maxValue = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.size(); i++) {
        minHeap.offer(new int[] {nums.get(i).get(0), i, 0});
            maxValue = Math.max(maxValue, nums.get(i).get(0));
        }
        
        int start =0,end =Integer.MAX_VALUE;
        
        while (minHeap.size() == nums.size()) {
            int[] curr = minHeap.poll();
            int minValue = curr[0], row = curr[1], col = curr[2];
            
            if (maxValue - minValue < end - start || (maxValue - minValue == end - start && minValue < start)) {
                start = minValue;
                end = maxValue;
            }
            
            if (col + 1 < nums.get(row).size()) {
            int nextValue = nums.get(row).get(col + 1);
            minHeap.offer(new int[] {nextValue, row, col + 1});
                maxValue = Math.max(maxValue, nextValue);
            }
        }
        
    return new int[]{start,end};
    }
}