class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        
  int len = nums.length;
        int[] left = new int[len];
        left[0] =1;
        
        int sum = 1;
        
        for (int i = 1; i <len; i++) {
            
            int n = nums[i -1] %2 + nums[i] %2;            
            sum += n == 1 ? 1 :0;
            
        left[i]= sum;
        }
                      
        int qlen = queries.length;
        
        boolean[] res = new boolean[qlen];
        
        for (int i = 0; i < qlen; i++) {
int[] query = queries[i];
            int start = query[0] ;
            int end = query[1];
                        
            int ns = start < 0 ? 0 : left[start];
            int ne = left[end];
            
            int count = ne - ns;
            int length = end - start ;
        
            
            
            res[i] = count == length;
        }
        
    return res;
    }
}