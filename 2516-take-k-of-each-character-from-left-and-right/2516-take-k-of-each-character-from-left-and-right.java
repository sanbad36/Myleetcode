class Solution {
    public int takeCharacters(String s, int k) {
        int[] ns = new int[s.length()];
        int[] is = new int[3];
        int min, tmp;
        for(int i=0; i<s.length(); i++){
            ns[i] = s.charAt(i)-'a'; is[ns[i]]++;
        }
        if(is[0]<k||is[1]<k||is[2]<k) return -1;

        int r=0;
        while(r<ns.length&&is[ns[r]]>k)is[ns[r++]]--;
        min = ns.length-r;

        for(int l=0; l<ns.length&&r<ns.length; l++){
            is[ns[l]]++;
            while(r<ns.length&&is[ns[r]]>k)is[ns[r++]]--;
            tmp = ns.length-r+l+1;
            if(min>tmp)min=tmp;
            if(r==ns.length)break;
        }
        return min;
    }
}