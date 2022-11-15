package string;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement repeatingCharacterReplacement = new LongestRepeatingCharacterReplacement();
        repeatingCharacterReplacement.characterReplacement("AABABBA", 2);
    }

    public int characterReplacement(String s, int k) {
        int low = 1, high = s.length() + 1;

        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (canMakeValidString(s, mid, k)) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return low;

    }

    private boolean canMakeValidString(String s, int subStringLen, int k) {
        int[] freqMap = new int[26];
        int maxFreq = 0;
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            freqMap[s.charAt(end) - 'A']++;

            if (end - start + 1 > subStringLen) {
                freqMap[s.charAt(start) - 'A']--;
                start++;
            }
            maxFreq = Math.max(maxFreq, freqMap[s.charAt(end) - 'A']);
            if (subStringLen - maxFreq <= k)
                return true;
        }
        return false;
    }
}
