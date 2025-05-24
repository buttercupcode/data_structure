package leetcode.trie;

import java.util.HashMap;
import java.util.Map;

public class MapSumTrie677 {
    public static void main(String[] args) {
        MapSumTrie677 mp = new MapSumTrie677();
        MapSumTrie677.MapSum mp1 = new MapSumTrie677.MapSum();
    }

    static class MapSum {
        Map<String, Integer> map;
        TrieNode root;

        public MapSum() {
            map = new HashMap<>();
            root = new TrieNode();

        }

        public void insert(String key, int val) {
            int delta = val - map.getOrDefault(key, 0);
            map.put(key, val);
            TrieNode node = root;
            node.score += delta;
            for (char ch : key.toCharArray()) {
                node.children.putIfAbsent(ch, new TrieNode());
                node = node.children.get(ch);
                node.score += delta;
            }
        }

        public int sum(String prefix) {
            TrieNode node = root;
            for (char ch : prefix.toCharArray()) {
                node = node.children.get(ch);
                if (node == null)
                    return 0;
            }
            return node.score;
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> children;
        int score;

        TrieNode() {
            children = new HashMap<>();
        }
    }

}
