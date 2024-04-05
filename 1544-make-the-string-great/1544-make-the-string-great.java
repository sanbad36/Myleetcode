class Solution {
    public String makeGood(String s) {
        
        
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            
             if(!stack.isEmpty() && Math.abs(stack.peek()-s.charAt(i)) == 32)
                stack.pop();
              else
                stack.push(s.charAt(i));
            
        }
        
    
        char[] charArr = new char[stack.size()];
        int i = stack.size() - 1;
        while(!stack.isEmpty())
            charArr[i--] = stack.pop();  
        
        return new String(charArr);
        
    }
}