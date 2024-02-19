package questions.medium.string;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        List<List<String>> lists = ga.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(lists);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String sorted = new String(ch);
            if (res.containsKey(sorted)) {
                res.get(sorted).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                res.put(sorted, list);
            }
        }
        return new ArrayList<>(res.values());
    }
}
