class Solution {
    public double myPow(double x, int n) {
           if (n == 0) {
            return 1.0;
        }

        // If n is negative, we handle it by using the reciprocal of x and negating n
        long exp = n;
        if (n < 0) {
            x = 1 / x;
            exp = -exp;
        }

        double result = 1.0;
        double currentProduct = x;

        while (exp > 0) {
            if ((exp % 2) == 1) { // If exp is odd, multiply the result by the current product
                result *= currentProduct;
            }
            currentProduct *= currentProduct; // Square the current product
            exp /= 2; // Divide exp by 2
        }

        return result;
    }
}