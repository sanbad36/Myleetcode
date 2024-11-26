class Solution {
    public int findChampion(int n, int[][] edges) {
        int arr[] = new int[n];
        for(int i = 0;i < edges.length;i++) {
            arr[edges[i][1]]++;
        }
        int count = 0;
        int ans = 0;
        for(int i = 0;i < n;i++) {
            if(arr[i] == 0) {
                count++;
                ans = i;
            }
            if(count > 1) {
                return -1;
            }
        }
        return ans;
    }
}