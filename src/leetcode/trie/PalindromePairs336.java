package leetcode.trie;

import java.util.*;

public class PalindromePairs336 {

    List<String> validPrefixes(String word) {
        List<String> validPrefixes = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            if (isPalindromeBetween(word, i, word.length() - 1)) validPrefixes.add(word.substring(0, i));
        }
        return validPrefixes;
    }

    List<String> validSuffixes(String word) {
        List<String> validSuffixes = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            if (isPalindromeBetween(word, 0, i)) validSuffixes.add(word.substring(i + 1));
        }
        return validSuffixes;
    }

    private boolean isPalindromeBetween(String word, int start, int end) {
        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) return false;
            start++;
            end--;
        }

        return true;
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        TrieNode trie = new TrieNode();
        for (int wordId = 0; wordId < words.length; wordId++) {
            String word = words[wordId];
            String revWord = new StringBuffer(word).reverse().toString();
            TrieNode curr = trie;
            for (int j = 0; j < word.length(); j++) {
                if (hasPalindromeRemaining(revWord, j)) {
                    curr.palindromeRemaining.add(wordId);
                }
                Character c = revWord.charAt(j);
                if (!curr.next.containsKey(c)) curr.next.put(c, new TrieNode());
                curr = curr.next.get(c);
            }
            curr.wordEnding = wordId;
        }
        List<List<Integer>> pairs = new ArrayList<>();

        for (int wordId = 0; wordId < words.length; wordId++) {
            String word = words[wordId];
            TrieNode curr = trie;
            for (int j = 0; j < word.length(); j++) {
                if (curr.wordEnding != -1
                        && hasPalindromeRemaining(word, j)) {
                    pairs.add(Arrays.asList(wordId, curr.wordEnding));
                }
                // Move down to the next trie level.
                Character c = word.charAt(j);
                curr = curr.next.get(c);
                if (curr == null) break;
            }
        }
        return null;
    }

    private boolean hasPalindromeRemaining(String s, int i) {
        int p1 = i;
        int p2 = s.length() - 1;
        while (p1 < p2) {
            if (s.charAt(p1) != s.charAt(p2)) return false;
            p1++;
            p2--;
        }
        return true;
    }

    class TrieNode {
        public int wordEnding = -1;
        public Map<Character, TrieNode> next = new HashMap<>();
        public List<Integer> palindromeRemaining = new ArrayList<>();

    }
}
