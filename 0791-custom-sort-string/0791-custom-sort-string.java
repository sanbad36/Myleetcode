class Solution {
    public String customSortString(String order, String str) {
       HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<str.length();i++)    
        {
            if(hm.containsKey(str.charAt(i)))
               hm.put(str.charAt(i),hm.get(str.charAt(i))+1);
            else
               hm.put(str.charAt(i),1);
        }
        String res ="";
        
        for(int i=0;i<order.length();i++)
        {
            char ch=order.charAt(i);
            if(!hm.containsKey(ch))        
                continue;
            int freq = hm.get(ch);
            for(int j=0;j<freq;j++)
                res+=Character.toString(ch);    
            hm.remove(ch);     
        }
        
        for(Character key : hm.keySet()) 
        {
            int freq = hm.get(key);
            for(int j=0;j<freq;j++)
                res+=Character.toString(key);
        }
               return res;
    }
}