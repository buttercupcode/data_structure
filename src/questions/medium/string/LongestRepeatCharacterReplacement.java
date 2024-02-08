package questions.medium.string;

public class LongestRepeatCharacterReplacement {
    public static void main(String[] args) {
        LongestRepeatCharacterReplacement lr = new LongestRepeatCharacterReplacement();
        System.out.println(lr.characterReplacement("AABABBA", 1));
    }

    public int characterReplacement(String s, int k) {

        int[] map = new int[26];
        int i = 0, j = 0;
        int maxLength = 0, maxCount =0;
        while (j < s.length()) {
            maxCount = Math.max(maxCount, ++map[s.charAt(j) - 'A']);
            while (j - i + 1 - maxCount > k) {
                map[s.charAt(i) - 'A']--;
                i++;
            }

            maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }
        return maxLength;
    }
}
