class Solution {
    public int passThePillow(int n, int time) {
        int cnt = 1;
        int start = 0, inc = 1;

        while (start < time) {
            cnt += inc;
            if (cnt == n || cnt == 1) {
                inc = -inc;
            }
            start++;
        }
        return cnt;
    }
}