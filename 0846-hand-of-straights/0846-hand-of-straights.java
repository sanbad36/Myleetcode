class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        if(hand.length % groupSize != 0) return false;
        
        Map<Integer, Integer> countMap = new TreeMap<>();
        for(int currentHand : hand){
            countMap.put(currentHand, countMap.getOrDefault(currentHand,0) + 1);
        }
        
        for(int countMapKey : countMap.keySet()){
            if(countMap.get(countMapKey) > 0){
                for(int i = 1; i < groupSize; i++){
                    if(countMap.getOrDefault(countMapKey + i, 0) < countMap.get(countMapKey)){
                        return false;
                    }
                    countMap.put(countMapKey + i, countMap.get(countMapKey + i) - countMap.get(countMapKey));
                }
            }
        }
        return true;            
    }
}