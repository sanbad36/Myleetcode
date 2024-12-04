class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int n=str1.length();
        int m=str2.length();
        int j=0;
       
        for(char c : str1.toCharArray()){
         if(j<m && (c==str2.charAt(j) || (c+1)==str2.charAt(j)|| (c-25)==str2.charAt(j))){
            j++;
         }
         }
      return j==m?true:false;
    }
}