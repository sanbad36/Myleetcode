class Solution {
    Map<Integer, List<Integer>> m = new HashMap();
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < n - 1; i++) {
            m.put(i, new ArrayList());
            m.get(i).add(i + 1);
        }

        for (int i = 0; i < queries.length; i++) {
            int from = queries[i][0];
            int to = queries[i][1];
            m.get(from).add(to);
            result[i] = bfs(n - 1);
        }
        return result;
    }

    private int bfs(int dest) {
        Set<Integer> visited = new HashSet();
        Queue<Integer> q = new LinkedList();
        if (0 == dest) return 0;
        q.add(0);
        int distance = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int city = (int) q.remove();
                if (city == dest) return distance;
                List<Integer> neighbors = m.get(city);
                for (int neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        q.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            distance++;
        }
        return 0;
    }
}

/*
create a adj map of 
city to list of neighbors
process a query and then do a bfs


*/