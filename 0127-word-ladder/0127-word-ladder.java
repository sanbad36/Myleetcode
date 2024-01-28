class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Queue<String> queue = new LinkedList<>();
        Set<String> wordListSet = new HashSet();
        for(String str:wordList){
            wordListSet.add(str);
        }
        
        if(!wordListSet.contains(endWord)) return 0;
        
        queue.add(beginWord);
        int lsize = 0;
        int depth = 0;
        
        while(!queue.isEmpty()){
          depth += 1;
           lsize = queue.size();
           while(lsize-- != 0){
               
                System.out.println(queue.size() + " "+depth);
                String currentString = queue.poll();  
                for(int i=0;i<currentString.length();i++){
                    for(char ch = 'a';ch <= 'z';ch++){
                    String checkInSet =  currentString.substring(0, i) + ch + currentString.substring(i + 1);
                    if(checkInSet.equals(currentString)) continue;
                    if(wordListSet.contains(checkInSet)){
                        if(checkInSet.equals(endWord)) return depth + 1;
                        queue.add(checkInSet);
                        wordListSet.remove(checkInSet);
                    }     
                }
                }
               
               
           }   
           
        }
        return 0;
    }
}