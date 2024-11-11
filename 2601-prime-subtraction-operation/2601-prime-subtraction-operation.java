class Solution {
    public boolean primeSubOperation(int[] nums) {
        int n = nums.length;
        int[] primes = getPrimesLessThan(1000);
        int prev = 0;

        for (int i = 0; i < n; i++) {
            boolean valid = false;
            for (int j = primes.length - 1; j >= 0; j--) {
                if (nums[i] - primes[j] > prev) {
                    nums[i] -= primes[j];
                    valid = true;
                    break;
                }
            }
            if (!valid && nums[i] <= prev) return false;
            prev = nums[i];
        }
        return true;
    }

    private int[] getPrimesLessThan(int max) {
        boolean[] isPrime = new boolean[max + 1];
        for (int i = 2; i <= max; i++) isPrime[i] = true;
        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i <= max; i++) {
            if (isPrime[i]) count++;
        }
        int[] primes = new int[count];
        int index = 0;
        for (int i = 2; i <= max; i++) {
            if (isPrime[i]) primes[index++] = i;
        }
        return primes;
    }
}
