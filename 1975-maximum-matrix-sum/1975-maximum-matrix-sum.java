class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int minAbs = Integer.MAX_VALUE;
        long sum=0;
        int negative=0;
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]<0) negative++;
                sum+=Math.abs(matrix[i][j]);
                minAbs=Math.min(minAbs, Math.abs(matrix[i][j]));
            }
        }
        if((negative&1)==1){
            sum-=2*minAbs;
        }

        return sum;

    }
}