class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int[]steps = {1,1}; 
        int stepIndex = 0; 
    List<int[]> result = new ArrayList<>();
         result.add(new int[]{rStart, cStart});
        while (result.size() < rows*cols) {
            for (int i = 0; i < 2; i++) { 
                for (int j = 0; j < steps[stepIndex % 2]; j++) {
                    rStart += directions[stepIndex][0];
                    cStart += directions[stepIndex][1];
                    if (rStart >= 0&& rStart<rows && cStart>=0 && cStart<cols) {
                        result.add(new int[]{rStart, cStart});
                    }
                }
            stepIndex = (stepIndex+1)%4;
        }
            steps[0]++;
            steps[1]++;
        }    
        int[][] resultArray = new int[result.size()][2];
        for (int i =0; i<result.size(); i++) {
            resultArray[i] = result.get(i);
        }
    return resultArray;
    }
}