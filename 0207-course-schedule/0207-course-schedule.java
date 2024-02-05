class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites.length == 0) return true;
        int[] indegree = new int[numCourses];
        
        for(int i=0;i<prerequisites.length; i++){
            indegree[prerequisites[i][0]] ++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<numCourses; i++){  
            if(indegree[i] == 0) queue.add(i);
        }
        
        int count = queue.size();
        while(!queue.isEmpty()){
            int node = queue.remove();
            
            for(int i=0; i < prerequisites.length; i++){
                if(prerequisites[i][1] == node) {  
                    indegree[prerequisites[i][0]]--;                          
                    if(indegree[prerequisites[i][0]] == 0) {
                        count++;
                        queue.add(prerequisites[i][0]);   
                    }
            }
                   
        }     
    }
     
        return (count == numCourses);
    }
}