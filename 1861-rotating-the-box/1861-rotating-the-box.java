class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int n = box.length;
        int m = box[0].length;

        for(int i = 0 ; i < n ; i++) {
            traverseArray(box[i], m);
        }
    
        char[][] result = new char[m][n];
        for(int i = n - 1 ; i >= 0 ; i--) {
            transpose(box[i], result, n - i - 1);
        }
        return result;
    }

    public void transpose(char[] arr, char[][] ans, int col) {
        for(int i = 0 ; i < arr.length ; i++) {
            ans[i][col] = arr[i];
        }
    }

    public void traverseArray(char[] arr, int len) {
        int ground = len;
        for(int i = len - 1 ; i >= 0 ; i--) {
            char temp = arr[i];
            if(temp == '*') {
                ground = i;
            }

            if(temp == '#') {
                if(ground - 1 == i) ground = ground - 1;
                else {
                    arr[i] = '.';
                    arr[ground - 1] = '#';
                    ground = ground - 1;
                }
            }
        }
    }
}