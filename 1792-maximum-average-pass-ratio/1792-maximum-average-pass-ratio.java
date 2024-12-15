class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        
        //max-heap with custom comparator based on the delta improvement
    PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a,b) -> Double.compare(b[0], a[0]));
        
        // Populate the heap with initial delta values
for (int[] c : classes) {
            int pass = c[0], total = c[1];
            double currentRatio = (double) pass / total;
            double delta = calculateDelta(pass, total);
            maxHeap.offer(new double[]{delta, pass, total});
        }
        
    while (extraStudents>0) 
    
    {
            double[] top = maxHeap.poll();
            double delta = top[0];
            int pass =(int)top[1];
            int total = (int) top[2];
            pass++;
            total++;
            extraStudents--;
            
            // Recalculate delta and push back to the heap
            delta = calculateDelta(pass, total);
            maxHeap.offer(new double[]{delta, pass, total});
        }
        
        // the final average pass ratio
        double totalAverage = 0.0;
        while (!maxHeap.isEmpty()) {
            double[] top = maxHeap.poll();
            int pass = (int) top[1];
            int total = (int) top[2];
            totalAverage += (double) pass / total;
        }
        
        
        
    
       return totalAverage / classes.length;
    }
    
    private double calculateDelta(int pass, int total) {
       double currentRatio = (double) pass / total;
        double newRatio =(double) (pass +1) /(total +1);
        return newRatio -currentRatio;
    }
}
