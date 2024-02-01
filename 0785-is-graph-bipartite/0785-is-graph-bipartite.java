class Solution { 
    private boolean dfs(int color, int node, int[][] graph, int[] colorVisited){
        colorVisited[node] = color;
        for(int i : graph[node]){
            if(colorVisited[i] == -1){
               if(dfs(1-color, i, graph, colorVisited) == false)
                   return false;
            }
            else if(colorVisited[i] == color){
                return false;
            }
        }
        return true;
    }
     
    public boolean isBipartite(int[][] graph) {  
        int v = graph.length;
        int[] colorVisited = new int[v];
        for(int i=0; i<v; i++){
            colorVisited[i] = -1;
        }   
        for(int i = 0; i<v; i++){
            if(colorVisited[i] == -1){
                if(dfs(0,i,graph,colorVisited) == false) return false;
            }
        }   
        return true;  
    }
}