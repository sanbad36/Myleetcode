class Solution {
    private String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public String reverseParentheses(String s) {
        Stack<Integer> stck = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stck.push(i);
            } else if (s.charAt(i) == ')') {
                int last_pop = stck.pop();
                String temp = s.substring(last_pop + 1, i);
                s = s.substring(0, last_pop) + reverse(temp) + s.substring(i + 1);
                i -= 2;
            } else {
                continue;
            }
        }
        return s;
    }
}