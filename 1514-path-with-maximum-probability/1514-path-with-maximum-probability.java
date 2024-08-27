class Solution {
    class Pair {
        int node;
        double prob;
        
        Pair(int node, double prob) {
            this.node = node;
                this.prob = prob;
        }
    }
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<Pair>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            graph[u].add(new Pair(v, prob));
            graph[v].add(new Pair(u, prob));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
    
        pq.offer(new Pair(start, 1.0));
        
        double[] maxProb = new double[n];
        maxProb[start] = 1.0;
        
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            double prob = curr.prob;
            
            if (node == end) {
                return prob;
            }
            
     for (Pair neighbor : graph[node]) {
                int nextNode = neighbor.node;
                double nextProb = neighbor.prob;
                
                if (prob * nextProb > maxProb[nextNode]) {
                    maxProb[nextNode] = prob * nextProb;
                    pq.offer(new Pair(nextNode, maxProb[nextNode]));
                }
            }
        }
        
        
        return 0.0;
    }
        
    


}