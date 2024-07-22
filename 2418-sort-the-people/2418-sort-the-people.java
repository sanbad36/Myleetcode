class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        TreeMap<Integer,String> sortedMap = new TreeMap<>(Collections.reverseOrder());
        
        for(int i=0;i<heights.length;i++){
            sortedMap.put(heights[i],names[i]);
        }
        int j=0;
        for(String values:sortedMap.values()){
            names[j++] = values;
        }
        return names;
    }
}