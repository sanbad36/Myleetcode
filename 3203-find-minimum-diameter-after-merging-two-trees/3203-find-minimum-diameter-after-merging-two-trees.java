class Solution {
    private static int[] farthest(List<List<Integer>> G, int i) {
        
        
        
        int n = G.size();
        Queue<Integer> queue = new LinkedList<>();
        int[] seen = new int[n];
        Arrays.fill(seen, 0);
        seen[i] = 1;
        queue.add(i);
        int res = -1, maxd = -1;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : G.get(node)) {
                if (seen[neighbor] == 0) {
                    seen[neighbor] = seen[node] + 1;
                    queue.add(neighbor);
                    if (seen[neighbor] > maxd) {
                        res = neighbor;
                        maxd = seen[neighbor];
                    }
                }
            }
        }
        return new int[]{res, maxd - 1};
    }

    private static int[] diameter(int[][] edges) {
        if (edges.length == 0) {
            return new int[]{0, 0, 0};
        }
        int n = edges.length + 1;
        List<List<Integer>> G = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            G.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            G.get(u).add(v);
            G.get(v).add(u);
        }
        int[] firstFarthest = farthest(G, 0);
        int[] secondFarthest = farthest(G, firstFarthest[0]);
        return new int[]{secondFarthest[1], firstFarthest[0], secondFarthest[0]};
    }

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        
        
        int[] d1 = diameter(edges1);
        int[] d2 = diameter(edges2);
        int maxD1 = d1[0];
        int maxD2 = d2[0];
        return Math.max(maxD1, Math.max(maxD2, (maxD1 + 1) / 2 + (maxD2 + 1) / 2 + 1));
    }
}