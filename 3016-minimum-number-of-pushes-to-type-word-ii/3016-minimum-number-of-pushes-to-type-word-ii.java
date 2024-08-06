class Solution {
    public int minimumPushes(String word) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue());

        maxHeap.addAll(frequencyMap.entrySet());

        int[] keyPresses = new int[8];
        int totalKeyPresses = 0;

        while (!maxHeap.isEmpty()) {
            for (int i = 0; i < 8 && !maxHeap.isEmpty(); i++) {
                Map.Entry<Character, Integer> entry = maxHeap.poll();
                totalKeyPresses += (keyPresses[i] + 1) * entry.getValue();
                keyPresses[i]++;
            }
        }
        return totalKeyPresses;
    }
}