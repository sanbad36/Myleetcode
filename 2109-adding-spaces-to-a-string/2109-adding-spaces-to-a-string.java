class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuffer bul = new StringBuffer(s);
        int j=0;
        for(int i=0;i<bul.length();i++){
            if(i==spaces[j]){
                bul=bul.insert(spaces[j]+j," ");
                j++;
                if(j>=spaces.length){
                    break;
                }
            }
        }
        return bul.toString();
    }
}