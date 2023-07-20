class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int n = asteroids.length;
        
        if(n<1) return new int[]{};
        
        for(int i=0;i<n;i++ ){
            
            int val = asteroids[i];
            if(val > 0){
                stack.push(val);
            }
            else{
                
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -val){
                    stack.pop();                    
                }
                if(!stack.isEmpty() && stack.peek() == - val){
                    stack.pop();
                }
                else if(!stack.isEmpty() && stack.peek() > -val){
                    
                }
                else{
                    stack.push(val);
                }
            }
            
        }
        int result[] = new int[stack.size()];
        int j=result.length-1;
        while(j>=0){
            result[j] = stack.pop();
            j--;
        }
    return result;
    }
}