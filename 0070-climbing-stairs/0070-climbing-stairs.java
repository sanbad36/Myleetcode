class Solution {
    public int climbStairs(int n) {
        // Edge cases
//         if(n <= 0) return 0;
//         if(n == 1) return 1;
//         if(n == 2) return 2;  // 1, 2
        
//         int one_step_before = 2;
//         int two_step_before = 1;
//         int all_ways = 0;  
 
//         for(int i = 3; i<= n; i++){
//             all_ways = one_step_before + two_step_before;
//             two_step_before =  one_step_before;
//             one_step_before = all_ways;     
//         } 
//         return all_ways;  


//         if(n==0 || n==1) 
//             return 1;
//             return climbStairs(n-1) + climbStairs(n-2);
 
   
    
        Map<Integer, Integer> memo = new HashMap<>();
        return climblingStair(n,memo);
    
    }
    
    private int climblingStair(int n, Map<Integer,Integer> memo){ 
        if(n == 0 || n == 1) return 1;
        if(!memo.containsKey(n)){
            memo.put(n, climblingStair(n-1, memo) + climblingStair(n-2, memo) );
        }
        return memo.get(n);
    }
}

// TC: O(N)
//
//  1 -> 1
// 2 -> 2
// 3 -> 3 (1,1,1),(2,1),(1,2)

// N-> 1+(N-1) + 2 + (N-2)
//(N-1) = 1 + (N-2) + 2 + (N-3)

// 1,2,3, 5, 8, .....(n-1),(n)




