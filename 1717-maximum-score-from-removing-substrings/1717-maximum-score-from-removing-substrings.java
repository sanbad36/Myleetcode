class Solution {
    public int maximumGain(String s, int x, int y) {
        long maxGain = 0;
        String bigBenifitPat = (x >= y) ? ("ab") : ("ba");
        String smallBenifitPat = (bigBenifitPat.equals("ab")) ? ("ba") : ("ab");
        String bigPatRemoved = removePattern(s, bigBenifitPat);
        maxGain = Math.max(x, y) * ((s.length() - bigPatRemoved.length()) / 2);
        String smallPatRemoved = removePattern(bigPatRemoved, smallBenifitPat);
        maxGain += Math.min(y, x) * ((bigPatRemoved.length() - smallPatRemoved.length()) / 2);
        return (int)maxGain;
    }
    private String removePattern(String text, String pat){
        Deque<Character> stck = new ArrayDeque<>();
        int size = text.length();
        for(int indx = 0; indx < size; indx++){
            var chr = text.charAt(indx);
            if(stck.isEmpty()){
                stck.offerLast(chr);
            }else{
                if(stck.peekLast() == pat.charAt(0) && chr == pat.charAt(1)){
                   stck.pollLast();
                }else{
                   stck.offerLast(chr);
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while(!stck.isEmpty()){
            res.append(stck.pollFirst());
        }
        return res.toString();

    }
}