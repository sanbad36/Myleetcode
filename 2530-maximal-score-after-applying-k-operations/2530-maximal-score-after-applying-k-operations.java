class Solution {
    public long maxKelements(int[] nums, int k) {
          PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);  // (max)
        for (var num : nums){
            pq.add(num);
        }

        long sum =0;
        while (k-- >0) {
            int x = pq.poll();
             sum += x;
            pq.add((int) Math.ceil(x/3.0));
        }
            return sum;
    }
}