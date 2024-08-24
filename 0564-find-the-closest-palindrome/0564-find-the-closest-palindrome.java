class Solution {
    public static String nearestPalindromic(String n) {
        var num = Long.parseLong(n);

        // fast exit for corner cases
        if (num <= 10) {
            return String.valueOf(num - 1);
        } else if (num == 11) {
            return String.valueOf(9);
        }

        var len = n.length();
        var half = num / (int)Math.pow(10, len / 2);

        var reminderLen = len - (len / 2 + len % 2);
        var numLw = constructPalindrome(half - 1, reminderLen, num);
        var numMd = constructPalindrome(half, reminderLen, num);
        var numUp = constructPalindrome(half + 1, reminderLen, num);
        System.out.println("lower: %s; mid: %s; upped: %s // reminderLen = %s".formatted(numLw, numMd, numUp, reminderLen));
        
        var distLw = num - numLw;
        var distMd = Math.abs(num - numMd);
        var distUp = numUp - num;
        if (distUp < distMd && distUp < distLw)
            return String.valueOf(numUp);
        else if (distMd < distLw)
            return String.valueOf(numMd);
        else
            return String.valueOf(numLw);
    }

    private static long constructPalindrome(long half, int reminderLen, long num) {
        // half is a left side of a palindrome
        var result = half;
        // shrink half if it's too long
        while (strLen(half) > reminderLen) {
            half = half / 10;
        }
        // add '9' to the half if it's not long enough
        while (strLen(half) < reminderLen) {
            half = half * 10;
            half = half + 9;
        }
        // add a right side of palindrome by mirroring half 
        while (half != 0) {
            result = result * 10;
            result = result + (half % 10);
            half = half / 10;
        }
        return result == num 
            ? 0L    // do not consider palindrome if it the same as num
            : result;
    }

    private static int strLen(long l) {
        var result = 0;
        while (l != 0) {
            l = l / 10;
            result++;
        }
        return result;
    }
}