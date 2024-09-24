class Solution {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
    }
    
    public static void insert(TrieNode root, String numStr) {
        TrieNode node = root;
        for (char ch : numStr.toCharArray()) {
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
        }
    }
    
    public static int findLongestPrefix(TrieNode root, String numStr) {
        TrieNode node = root;
        int prefixLength = 0;
        
        for (char ch : numStr.toCharArray()) {
            if (node.children.containsKey(ch)) {
                prefixLength++;
                node = node.children.get(ch);
            } else {
                break;
            }
        }
        
        return prefixLength;
    }

    public static int longestCommonPrefix(int[] arr1, int[] arr2) {
        TrieNode root = new TrieNode();
        
        for (int num1 : arr1) {
            insert(root, String.valueOf(num1));
        }
        
        int maxPrefixLength = 0;
                for (int num2 : arr2) {
            int currentPrefixLength = findLongestPrefix(root, String.valueOf(num2));
            maxPrefixLength = Math.max(maxPrefixLength, currentPrefixLength);
        }   
        return maxPrefixLength;
    }
}