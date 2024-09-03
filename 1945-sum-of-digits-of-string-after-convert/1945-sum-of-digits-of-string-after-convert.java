class Solution {
    public int getLucky(String s, int k) {
        String str="";
        for(int i=0;i<s.length();i++){
            int x=(int)(s.charAt(i)-'a');
            str+=""+(x+1);
        }

        int ans=0;
        while(k-->0){
            int sum=sumOfDigit(str);
            str=""+sum;
        }
        ans=Integer.parseInt(str);
        return ans;
    }

    public int sumOfDigit(String str){
        int sum=0;
        for(char ch : str.toCharArray()){
            sum+=Character.getNumericValue(ch);
        }
        return sum;
    }
}