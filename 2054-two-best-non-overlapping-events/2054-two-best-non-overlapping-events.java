class Solution {
   public int findNextIndex(int[][] events, int pos){
    int start = pos;
    int end = events.length-1;
    int nextIndex = events.length;
    while(start <= end){
        int mid = (start+end)/2;
        if(events[pos][1] < events[mid][0]){
            nextIndex = mid;
            end = mid-1;
        }else{
            start = mid+1;
        }
    }
    return nextIndex;
}
public int maxTwoEvents(int[][] events) {
    Arrays.sort(events, (a, b) -> a[0]- b[0]);
    int n = events.length;
    int[] max = new int[n];
    max[n-1] = events[n-1][2];
    for(int i = n-2; i >= 0 ;i--){
        max[i] = Math.max(max[i+1], events[i][2]);
    }
    
    int maxValue = -1;

    for(int i =0 ; i < n ; i++){
        int start = events[i][0];
        int end = events[i][1];
        int value = events[i][2];
        int nextIndex = findNextIndex(events, i);
        maxValue = Math.max(maxValue, value +  ((nextIndex == n) ? 0 : max[nextIndex]));
    }
    return maxValue;
}
}