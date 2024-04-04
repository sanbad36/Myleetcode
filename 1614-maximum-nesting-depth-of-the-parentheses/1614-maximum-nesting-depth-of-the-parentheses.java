class Solution {
    public int maxDepth(String s) {
        
        Stack<Character> stack = new Stack<>();
        int count = 0;
        int max = 0;
        for(int i=0;i<s.length();i++){
            max = Math.max(max,count);    
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push('(');
                count++;
            }
            else if(!stack.isEmpty() && ch == ')') {
                stack.pop();
                count--;
            }
            
        }
        if(!stack.isEmpty()) 
            return -1;
        return max;
        
    }
}