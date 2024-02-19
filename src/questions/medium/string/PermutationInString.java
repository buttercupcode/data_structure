package questions.medium.string;

public class PermutationInString {
    public static void main(String[] args) {
        PermutationInString pis = new PermutationInString();
        boolean output = pis.checkInclusion("ab", "eidbaooo");
        //boolean output = pis.checkInclusion("ab","eidboaooo");
        //boolean output = pis.checkInclusion("hello","ooolleoooleh");
        System.out.println(output);
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length())
            return false;
        //int len = s1.length();
        int[] map1 = new int[26];

        for (char c : s1.toCharArray())
            map1[c - 'a']++;

        int[] map2 = new int[26];
        int i = 0, j = 0;
        while (j < s2.length()) {
            map2[s2.charAt(j) - 'a']++;
            if (j - i + 1 == s1.length()) {
                if (areArrayEqual(map1, map2))
                    return true;
            }
            //Set<Character> output = new HashSet<>();

            if (j - i + 1 >= s1.length()) {
                map2[s2.charAt(i) - 'a']--;
                i++;
            }
            j++;

        }
        return false;
    }

    private boolean areArrayEqual(int[] map1, int[] map2) {
        for (int i = 0; i < 26; i++) {
            if (map1[i] != map2[i]) return false;
        }
        return true;
    }
}
