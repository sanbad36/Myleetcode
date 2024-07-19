class Solution {
    public int getMin(int row,int [][]matrix){
        int tempMin=Integer.MAX_VALUE;
        for(int i=0;i<matrix[row].length;i++){
            tempMin=Math.min(tempMin,matrix[row][i]);
        }
        return tempMin;
    }
    public int getMax(int col,int [][]matrix){
        int tempMax = Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++){
            tempMax=Math.max(tempMax,matrix[i][col]);
        }
        return tempMax;
    }
    
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
         List<Integer> ans = new ArrayList<>();
        
        int minRowValue[] = new int[m];
        for(int i=0;i<m;i++){
            minRowValue[i]= getMin(i,matrix);
        }
        
        int maxColValue[] = new int[n];
        for(int i=0;i<n;i++){
            maxColValue[i]= getMax(i,matrix);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(minRowValue[i]==maxColValue[j]){
                    ans.add(minRowValue[i]);
                }
            }
        }
        return ans;
    }
}