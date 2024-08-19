func minSteps(n int) int {
    	steps := 0
	for i := 2; i <= n; i++ {
		for n%i == 0 {
			steps += i
			n /= i
		}
	}
	return steps
}