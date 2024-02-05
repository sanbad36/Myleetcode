class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
       if (numCourses == 0) return null;
        int[] indegree = new int[numCourses];
        for(int i=0;i<prerequisites.length; i++){
            indegree[prerequisites[i][0]] ++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<numCourses; i++){  
            if(indegree[i] == 0) {
                queue.add(i);
                                                        
        }
        }
        
        int itr=0;
        int[] topo = new int[numCourses];
        while(!queue.isEmpty()){
            int node = queue.remove();  
            topo[itr++] = node;
            for(int i=0; i < prerequisites.length; i++){
                if(prerequisites[i][1] == node) {  
                    indegree[prerequisites[i][0]]--;                          
                    if(indegree[prerequisites[i][0]] == 0) {
                        queue.add(prerequisites[i][0]);   
                    }
            }             
        }     
    }

    if(itr == numCourses) return topo;
        
    return new int[0];
        
    }
}