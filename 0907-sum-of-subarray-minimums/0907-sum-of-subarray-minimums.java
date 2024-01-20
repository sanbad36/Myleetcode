class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        long MOD = 1000000007;
        Arrays.fill(right, n - 1);
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < n; i++){
            int curr = arr[i];
            while(!s.isEmpty() && arr[s.peek()] > curr){
                right[s.pop()] = i - 1;
            }
            s.push(i);
        }
        s.clear();
        for(int i = n - 1; i >= 0; i--){
            int curr = arr[i];
            while(!s.isEmpty() && arr[s.peek()] >= curr){
                left[s.pop()] = i + 1;
            }
            s.push(i);
        }
        long sum = 0;
        for(int i = 0; i < n; i++){
            sum += ((long)(arr[i]))*((long)(i - left[i] + 1))*((long)(right[i] - i + 1));
            sum = sum % MOD;
        }
        return (int)(sum % MOD);
    }
}