class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        int count = 0;
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='('){
                count++;
            } else if(sb.charAt(i) == ')' && count>0){
                count--;
            } else if(sb.charAt(i) == ')' && count==0){
                sb.delete(i,i+1);
                i--;
            }
        }
        for(int i=sb.length()-1;i>=0;i--){
            if(count==0){
                break;
            }
            if(sb.charAt(i)=='('){
                sb.delete(i,i+1);
                count--;
            }
        }
        return sb.toString();
    }
}