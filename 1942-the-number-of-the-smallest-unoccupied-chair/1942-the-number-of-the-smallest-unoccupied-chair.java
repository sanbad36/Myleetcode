class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
         int n = times.length;
        List<int[]> events = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
           events.add(new int[]{times[i][0], i, 1}); 
            events.add(new int[]{times[i][1], i, -1}); 
    }
        
        events.sort((a,b) -> a[0]==b[0] ? a[2] -b[2] :a[0]- b[0]);
        
    PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        int[] occupiedChairs = new int[n];
        Arrays.fill(occupiedChairs, -1);
        int nextChair = 0;
        
        for (int[] event : events) {
            int time = event[0];
            int friend = event[1];
            int action = event[2];
            
            if (action == 1) {
                int chair;
                if (!availableChairs.isEmpty()) 
                    chair = availableChairs.poll();
                 else 
                    chair = nextChair++;
                occupiedChairs[friend] = chair;
                
                if (friend == targetFriend) 
                    return chair;
                
            } else   
              availableChairs.add(occupiedChairs[friend]);
    
        }
        
            return -1; 
    }
    
}