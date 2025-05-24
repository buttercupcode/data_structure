package leetcode.trie;

import java.util.HashMap;
import java.util.Map;

public class MapSum {
    Map<String, Integer> map;
    Map<String, Integer> sum;

    public MapSum() {
        this.map = new HashMap<>();
        this.sum = new HashMap<>();
    }

    public static void main(String[] args) {
        MapSum m = new MapSum();
        m.insert("apple", 3);
        System.out.println(m.sum("ap"));
        m.insert("app", 2);
        System.out.println(m.sum("ap"));
    }

    public void insert(String key, int val) {
        int delta = val - this.map.getOrDefault(key, 0);
        map.put(key, val);
        String prefix = "";
        for (char ch : key.toCharArray()) {
            prefix += ch;
            sum.put(prefix, sum.getOrDefault(prefix, 0) + delta);
        }
    }

    public int sum(String prefix) {
        return sum.getOrDefault(prefix, 0);
    }
}