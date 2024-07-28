
public class Solution {

    static class Pair {
        int vertex;
        int time;

        public Pair(int vertex, int time) {
            this.vertex = vertex;
            this.time = time;
        }
    }

    public int secondMinimum(int n, int[][] edges, int time, int change) {
        Map<Integer, List<Pair>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(new Pair(v, time));
            graph.get(v).add(new Pair(u, time)); 
        }

        // Initialize priority queue and distance arrays
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.time));
        int[] minDistances = new int[n + 1];
        int[] secondMinDistances = new int[n + 1];
        Arrays.fill(minDistances, Integer.MAX_VALUE);
        Arrays.fill(secondMinDistances, Integer.MAX_VALUE);
        minDistances[1] = 0;  // Start node has a distance of 0

        // Start the priority queue with the starting node (1) and time 0
        pq.offer(new Pair(1, 0));

        // Process nodes in the priority queue
        while (!pq.isEmpty()) {
            Pair currNode = pq.poll();  // Get the node with the smallest time
            int curr = currNode.vertex;
            int currTime = currNode.time;

            // Calculate if and how long to wait based on the traffic light cycle
            int waitTime = shouldIWait(currTime, change);

            // Explore all neighbors of the current node
            for (Pair neighbor : graph.get(curr)) {
                int newTime = currTime + waitTime + neighbor.time;  // Calculate the time to reach the neighbor
                if (newTime < minDistances[neighbor.vertex]) {
                    // If new time is less than the current minimum distance, update both minimum and second minimum
                    secondMinDistances[neighbor.vertex] = minDistances[neighbor.vertex];
                    minDistances[neighbor.vertex] = newTime;
                    pq.offer(new Pair(neighbor.vertex, newTime));
                } else if (newTime > minDistances[neighbor.vertex] && newTime < secondMinDistances[neighbor.vertex]) {
                    // Update the second minimum distance if the new time is between the current minimum and second minimum
                    secondMinDistances[neighbor.vertex] = newTime;
                    pq.offer(new Pair(neighbor.vertex, newTime));
                }
            }
        }

        // Return the second minimum distance to the destination node (node n), or -1 if not reachable
        return secondMinDistances[n] == Integer.MAX_VALUE ? -1 : secondMinDistances[n];
    }

    // Function to determine if and how long to wait based on the traffic light cycle
    public static int shouldIWait(int currTime, int timeOfChange) {
        // Calculate the total duration of one full cycle (green + red light)
        int cycleDuration = 2 * timeOfChange;  // Total duration of one green + one red light cycle
        
        // Calculate the remainder to determine the phase in the current cycle (Green ? or Red ?)
        int remainder = currTime % cycleDuration;

        // Check if the current time is in the red light phase
        if (remainder >= timeOfChange) {
            // Calculate how long we need to wait until the green light phase starts
            // Example: timeOfChange = 5
            // Traffic light cycle: 0 to 4 (green), 5 to 9 (red), 10 to 14 (green), and so on
            // Current time = 7
            // Remainder when divided by cycleDuration (2 * timeOfChange = 10): 7 % 10 = 7
            // Since 7 falls in the red light phase (5 to 9), we need to wait until 10 (end of the current red light phase)

            // Waiting time = 10 - 7 = 3 units of time 
            // Alternatively, Waiting time can be calculated as:
            // timeOfChange - (currTime % timeOfChange) = 5 - (7 % 5) = 5 - 2 = 3
            return timeOfChange - (currTime % timeOfChange);  // Returns the time until the green light starts
        }
        
        // If the light is green, no waiting is required
        return 0;
    }
}