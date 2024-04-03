class Solution {
    
    private boolean searchWord(char[][] board, String word, int idx, int i, int j){
        if(idx == word.length()-1 ) return true;
        board[i][j] -= 65;
        char ch = word.charAt(idx+1);
        if(i>0 && board[i-1][j] == ch && searchWord(board,word,idx+1,i-1,j)) return true;
        if(j>0 && board[i][j-1] == ch && searchWord(board,word,idx +1,i,j-1)) return true;
        if(i<board.length-1 && board[i+1][j] == ch && searchWord(board,word,idx+1,i+1,j)) return true;
        if(j<board[0].length-1 && board[i][j+1] == ch && searchWord(board,word,idx+1,i,j+1)) return true;
        board[i][j] += 65;
        return false;
    }

    public boolean exist(char[][] board, String word) {        
        int row = board.length;
        int col = board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(word.charAt(0) == board[i][j]  && searchWord(board,word,0,i,j)) return true;  
            }  
        }
        return false;
    }
}