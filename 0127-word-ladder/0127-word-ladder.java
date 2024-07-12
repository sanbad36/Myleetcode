class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordsSet = new HashSet<>(wordList);
        if (!wordsSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        Set<String> visitedWords = new HashSet<>();
        visitedWords.add(beginWord);

        int changes = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return changes;
                }

                for (String nei : new HashSet<>(wordsSet)) { 
                    if (checkOneDiff(word, nei)) {
                        if (!visitedWords.contains(nei)) {
                            queue.add(nei);
                            visitedWords.add(nei);
                            wordsSet.remove(nei); 
                        }
                    }
                }
            }
            changes++;
        }
        return 0; 
    }

    boolean checkOneDiff(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int diffCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
            }
            if (diffCount > 1) {
                return false;
            }
        }
        return diffCount == 1;
    }
}
