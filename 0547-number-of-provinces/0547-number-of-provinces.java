class Solution {
    
    private void bfsGraphTraversal(int startingNode, boolean isVisitedList[], int[][] isConnected){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startingNode);
        isVisitedList[startingNode] = true;
        while(!queue.isEmpty()){
            int currentNode = queue.poll();
            for(int listIterator = 0; listIterator < isConnected.length; listIterator++){
                if(isConnected[currentNode][listIterator] == 1 && !isVisitedList[listIterator]){
                    queue.offer(listIterator);
                    isVisitedList[listIterator] = true;
                }
            }
        }         
    }
    
    public int findCircleNum(int[][] isConnected) {
        
        int provinceCount = 0;
        int totalNode = isConnected.length;
        boolean isVisitedList[] = new boolean[totalNode];
                
        for(int graphNodeIterator = 0; graphNodeIterator < totalNode; graphNodeIterator++){
            if(!isVisitedList[graphNodeIterator]){
               bfsGraphTraversal(graphNodeIterator, isVisitedList, isConnected);
               provinceCount++;
            }
        }   
        return provinceCount;
    }
}