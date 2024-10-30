class Solution {
    public int minimumMountainRemovals(int[] nums) {
	int n = nums.length;
	TreeMap<Integer, Integer> map = new TreeMap<>();
	map.put(0, 0);
	int[] increase = new int[n];
	for(int i=0; i<n; i++) {
		increase[i] = map.get(map.floorKey(nums[i]-1)) + 1;
		while(map.ceilingKey(nums[i]+1) != null) {
			int ceil = map.ceilingKey(nums[i]+1);
			if(map.get(ceil) < increase[i]) {
				map.remove(ceil);
			} else break;
		}
		map.put(nums[i], increase[i]);
	}

	int[] decrease = new int[n];
	map.clear();
	map.put(0, 0);
	for(int i=n-1; i>=0; i--) {
		decrease[i] = map.get(map.floorKey(nums[i]-1)) + 1;
		while(map.ceilingKey(nums[i]+1) != null) {
			int ceil = map.ceilingKey(nums[i]+1);
			if(map.get(ceil) < decrease[i]) {
				map.remove(ceil);
			} else break;
		}
		map.put(nums[i], decrease[i]);
	}

	int res = 0;
	for(int i=1; i<n-1; i++) {
		if(increase[i] == 1 || decrease[i] == 1) continue;
		res = Math.max(res, increase[i]+decrease[i]);
	}

	return n-res+1;
}
}