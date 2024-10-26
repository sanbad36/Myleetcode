class Solution {
    public String licenseKeyFormatting(String s, int k) {
               
        s = s.replace("-", "").toUpperCase();
        
        StringBuilder result = new StringBuilder();
        
        int firstGroupSize = s.length() % k;
        int i = 0;

        if (firstGroupSize > 0) {
            result.append(s.substring(0, firstGroupSize));
            i = firstGroupSize;
        }

        while (i < s.length()) {
            if (result.length() > 0) {
                result.append("-");
            }
            result.append(s.substring(i, i + k));
            i += k;
        }

        return result.toString(); 
    }
}