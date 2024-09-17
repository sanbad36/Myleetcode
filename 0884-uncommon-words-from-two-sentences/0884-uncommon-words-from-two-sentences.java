class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String str = s1 + " " + s2;
        String[] words = str.split(" "); 
        
        HashMap<String,Integer> hm1 = new HashMap<>();
        
        //counting no. of occurences for both string array
        for(int i = 0 ; i < words.length ; i++){
            String current = words[i];
            if(hm1.containsKey(current)){
                int oldFreq = hm1.get(current);
                int newFreq = 1 + oldFreq ;
                hm1.put(current,newFreq);
            }else{
                hm1.put(current,1);
            }
        }
       ArrayList<String> list = new ArrayList<>(); 
        for(String s:hm1.keySet()){
            if(hm1.get(s)==1){
                list.add(s);
            }
        }
        String[] res = new String[list.size()];
        int index = 0;
        for(String s : list){
                res[index++] = s;
        }
        return res;
    }
}
