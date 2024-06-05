class Solution {
    public List<String> commonChars(String[] words) {
        
        int[] minFreq = new int[26];
        List<String> ans  = new ArrayList<String>();
        
        Arrays.fill(minFreq, Integer.MAX_VALUE);
        
        for(String currentString: words){
            int[] counter = new int[26];
            
            for(char c: currentString.toCharArray()){
                
                counter[c-'a']++;
            }
            
            for(int i=0;i<26;i++){
                
                minFreq[i] = Math.min(minFreq[i], counter[i]);
            }
            
        }
        
        for(int i=0;i<26;i++){
           
            while(minFreq[i]>0){
                ans.add(""+ (char)(i + 'a'));
                minFreq[i]--;
            }
            
        }
        
        return ans;
        
    }
    
}