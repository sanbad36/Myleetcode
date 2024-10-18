class Solution {
    private void solve(int[] nums, int i, int n, int xor, int[] res) {
	if(i == n) {
		if(xor == res[0]) res[1]++;
		else if(xor > res[0]) {
			res[0] = xor;
			res[1] = 1;
		}
		return;
	}
	solve(nums, i+1, n, xor|nums[i], res);
	solve(nums, i+1, n, xor, res);
}

public int countMaxOrSubsets(int[] nums) {
	// res[0] = value, res[1] = count
	int[] res = new int[2];
	solve(nums, 0, nums.length, 0, res);
	return res[1];
}
}