class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int result[]= new int[queries.length];
        for(int i=1;i<arr.length;i++){  
            arr[i] = arr[i-1] ^ arr[i];  
        } 
        for(int q=0;q<queries.length;q++){
            int start = queries[q][0];
            int end = queries[q][1];
            result[q] = start != 0 ? arr[end] ^ arr[start-1] : arr[end];
        }
        return result;
    }
}