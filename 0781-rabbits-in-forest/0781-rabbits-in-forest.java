class Solution {
    public int numRabbits(int[] answers) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int num: answers){
            if(num==0){
                sum += 1;
                continue;
            }
            
            if(!map.containsKey(num)){
                map.put(num,0);
                sum += (num + 1);
            }
            else{
                map.put(num, map.get(num) + 1);
                if(map.get(num) == num)
                    map.remove(num);
            }   
            
        } 
        
        return sum;
        
    }
}

    
