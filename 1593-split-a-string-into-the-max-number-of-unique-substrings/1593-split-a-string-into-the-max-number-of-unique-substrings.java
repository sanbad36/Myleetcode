class Solution {
    
    int max = 0;
    public int maxUniqueSplit(String s) {
        split(0,new HashSet<>(),s);
        return max;
    }
    
    public void split(int ind , Set<String> set , String s){
        
        if(ind >= s.length()){
            max = Math.max(set.size(),max);
            return;
        }
    
        for(int i  = ind + 1 ; i <= s.length() ; i++){
            String newS = s.substring(ind,i);
            if(set.add(newS)){
                split(i,set,s);
                set.remove(newS);
            }
        }
    }
}