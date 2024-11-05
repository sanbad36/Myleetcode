class Solution {
    public String compressedString(String word) {

     StringBuilder sb = new StringBuilder();
     Stack<Character> st = new Stack<>();
       
     int count = 1;
     for(int i=word.length()-1;i>=0;i--)
     {
        st.push(word.charAt(i));
     }
     while(!st.isEmpty())
     {
        char c = st.pop();

        while (!st.isEmpty() && st.peek()==c && count<9)
        {
            count++;
            st.pop();

        }
        sb.append(count);
        sb.append(c);
        count =1;
     }
     return sb.toString();
    }
}