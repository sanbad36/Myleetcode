class Solution {
    
    
    public static boolean isPalindrome(String s){
        int start=0;
        int end = s.length()-1;
        while(start<=end){
            if(s.charAt(start)==s.charAt(end)){
                start++;
                end--;
            }
            else{
                return false;
            }
        }
        return true;    
    }
    
    
    public int countSubstrings(String s) {
        int count = 0;
        for(int i=0;i<s.length();i++){
             for(int j = i+1;j<=s.length();j++){
                String subS = s.substring(i,j);
                if(isPalindrome(subS)==true)
                { 
                count++;
                }
            }
        }
      return count;
}
}