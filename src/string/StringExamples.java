package string;

import java.util.*;

public class StringExamples {
    public static void main(String[] args) {
        StringExamples s = new StringExamples();
        //System.out.println(s.maxSwap(9378));
        //System.out.println(s.compress(new char[]{'a','a','b','b','c','c','c'}));
        //System.out.println(s.isPalindrome("A man, a plan, a canal: Panama"));
        //System.out.println(s.checkInclusion("ab","eidbaooo"));
        //System.out.println(s.makeGood("leEeetcode"));
        //System.out.println(s.makeGoodStack("abBAcC"));
        //System.out.println(s.checkInclusionUsingArray("ab","eidbaooo"));
        //s.slidingWindow();
        //System.out.println(s.findAnagrams("cbaebabacd","abc"));

        //s.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        //System.out.println(s.longestPalindrome("babad"));
       /* System.out.println(s.encode(List.of("lint","code","love","you")));
        System.out.println(s.encodeOriginal(List.of("lint","code","love","you")));*/
        //System.out.println(s.encode(List.of()));
        //System.out.println(s.encodeOriginal(List.of()));
        //System.out.println(s.decode(s.encode(List.of("lint","code","love","you"))));
        System.out.println(s.decodeOriginal(s.encodeOriginal(List.of("lint", "code", "love", "you"))));
    }

    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += countPalindrome(s, i, i);
            count += countPalindrome(s, i, i + 1);
        }
        return count;
    }

    private int countPalindrome(String s, int low, int high) {
        int count = 0;
        while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
            count++;
            low--;
            high++;
        }
        return count;
    }

    public int maxSwap(int num) {

        char[] digits = Integer.toString(num).toCharArray();
        int maxDigit = -1, maxIndex = -1;
        int leftIndex = -1, rightIndex = -1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] - '0' > maxDigit) {
                maxDigit = digits[i] - '0';
                maxIndex = i;
                continue;
            }
            if (digits[i] - '0' < maxDigit) {
                leftIndex = i;
                rightIndex = maxIndex;
            }

        }
        if (leftIndex == -1)
            return num;
        else {
            char tmp = digits[leftIndex];
            digits[leftIndex] = digits[rightIndex];
            digits[rightIndex] = tmp;
            return Integer.parseInt(new String(digits));
        }

       /* for(int i =0; i<digits.length;i++){
            buckets[digits[i]-'0']=i;
        }
        for(int i =0; i<digits.length;i++){
            for(int k=9;k>digits[i]-'0';k--){
                if(buckets[k]>i){
                    char temp = digits[i];
                    digits[i] = digits[buckets[k]];
                    digits[buckets[k]] = temp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }
        return num;*/
    }

    public int compress(char[] chars) {
        int charIdx = 0, charCounter = 0;
        while (charIdx < chars.length) {
            char ch = chars[charIdx];
            int count = 0;
            while (charIdx < chars.length && chars[charIdx] == ch) {
                count++;
                charIdx++;
            }
            chars[charCounter++] = ch;
            if (count > 1) {
                for (char countChar : Integer.toString(count).toCharArray()) {
                    chars[charCounter++] = countChar;

                }
            }
        }
        return charCounter;
    }

    public boolean isPalindrome(String s) {
        char[] charString = s.toCharArray();
        int leftCtr = 0, rightCtr = charString.length - 1;
        while (leftCtr <= rightCtr) {
            char left = charString[leftCtr];
            char right = charString[rightCtr];
            if (!Character.isLetterOrDigit(left)) leftCtr++;
            else if (!Character.isLetterOrDigit(right)) rightCtr--;
            else if (Character.toLowerCase(left) == Character.toLowerCase(right)) {
                leftCtr++;
                rightCtr--;
            } else {
                return false;
            }

        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;

        int[] count = new int[26];
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if (allZero(count)) return true;

        for (int i = len1; i < len2; i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - len1) - 'a']++;
            if (allZero(count)) return true;
        }

        return false;
    }

    private boolean allZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }

    public String makeGood(String s) {

/*        for(int i =0;i<input.length;i++){
            if((i<input.length-1 && !isCaseReverse(s.charAt(i),s.charAt(i+1)))
                    || (i==input.length-1))
                output+=s.charAt(i);

            else
                i+=1;
        }
        return output;*/

        while (!isGood(s)) {
            s = makeItGood(s);
        }
        return s;
    }

    private String makeItGood(String s) {
        String output = "";
        for (int i = 0; i < s.length(); i++) {
            if ((i < s.length() - 1 && !isCaseReverse(s.charAt(i), s.charAt(i + 1)))
                    || (i == s.length() - 1))
                output += s.charAt(i);

            else
                i += 1;
        }
        return output;
    }

    private boolean isGood(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && isCaseReverse(s.charAt(i), s.charAt(i + 1)))
                return false;
        }
        return true;
    }

    private boolean isCaseReverse(char a, char b) {

        return (Character.isLowerCase(a) && Character.toUpperCase(a) == b)
                || (Character.isUpperCase(a) && Character.toLowerCase(a) == b);
    }

    private String makeGoodStack(String s) {
        String output = "";
        Stack<Character> characterStack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!characterStack.isEmpty()) {
                char top = characterStack.peek();
                if (Math.abs(c - top) == 32)
                    characterStack.pop();
                else
                    characterStack.push(c);
            } else
                characterStack.push(c);
        }
        while (!characterStack.isEmpty()) {
            output = characterStack.pop() + output;
        }
        return output;
    }

    public boolean checkInclusionUsingArray(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        for (int i = 0; i < s1.length(); i++)
            s1map[s1.charAt(i) - 'a']++;
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int[] s2map = new int[26];
            for (int j = 0; j < s1.length(); j++) {
                s2map[s2.charAt(i + j) - 'a']++;
            }
            if (matches(s1map, s2map))
                return true;
        }
        return false;
    }

    public boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> anagramIndex = new ArrayList<>();
        if (p.length() > s.length()) return anagramIndex;
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : p.toCharArray())
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);

        int window = charMap.size();
        int left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (charMap.containsKey(c)) {
                charMap.put(c, charMap.get(c) - 1);
                if (charMap.get(c) == 0)
                    window--;
            }
            right++;
            while (window == 0) {
                char tempc = s.charAt(left);
                if (charMap.containsKey(tempc)) {
                    charMap.put(tempc, charMap.get(tempc) + 1);
                    if (charMap.get(tempc) > 0)
                        window++;
                }
                if (right - left == p.length())
                    anagramIndex.add(left);
                left++;
            }

        }
        return anagramIndex;
    }

    public void slidingWindow() {
        String s = "cbaebabacd";
        String o = "";
        int window = 3;
        int i = 0, j = 0;
        while (j < s.length()) {
            while (j - i < window && j < s.length()) {
                o += s.charAt(j);
                j++;
            }
            i++;
        }
        System.out.println(o);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        Set<String> visited = new HashSet<>();
        int counter = 0;
        for (String str : strs) {
            if (!visited.contains(str)) {
                visited.add(str);

                List<String> anagrams = new ArrayList<>();
                anagrams.add(str);

                for (int i = counter + 1; i < strs.length; i++) {
                    String sToCheck = strs[i];
                    Map<Character, Integer> valueMap = new HashMap<>();
                    for (char c : str.toCharArray()) {
                        valueMap.put(c, valueMap.getOrDefault(c, 0) + 1);
                    }
                    if (!visited.contains(sToCheck)) {
                        for (char c : sToCheck.toCharArray())
                            valueMap.put(c, valueMap.getOrDefault(c, 0) - 1);
                        boolean isAnagram = true;
                        for (Map.Entry<Character, Integer> entry : valueMap.entrySet()) {
                            if (entry.getValue() != 0) {
                                isAnagram = false;
                                break;
                            }
                        }
                        if (isAnagram) {
                            anagrams.add(sToCheck);
                            visited.add(sToCheck);
                        }
                    }
                }
                result.add(anagrams);
            }
            counter++;
        }
        return result;
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2)
            return s;
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = maxLengthPalindrome(s, i, i);
            int len2 = maxLengthPalindrome(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - ((len - 1) / 2);
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int maxLengthPalindrome(String s, int left, int right) {
        int length = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        length = right - left - 1;
        return length;
    }

    private String encode(List<String> input) {

        int l = input.size();
        String output = l + ":";
        for (String s : input) {
            output += s.length() + ":";
        }
        for (String s : input) {
            output += s;
        }
        return output;
    }

    public String encodeOriginal(List<String> strs) {
        int numOfStr = strs.size();
        List<Integer> lengths = new LinkedList<Integer>();
        for (String s : strs) {
            lengths.add(s.length());
        }
        String result = numOfStr + "";
        for (Integer i : lengths) {
            result += ":" + i;
        }
        result += ":";
        for (String s : strs) {
            result += s;
        }
        return result;
    }

    public List<String> decode(String encodedString) {
       /*String[] s = encodedString.split(":");
       return  Arrays.asList(s);*/
        int totalLength = 0, resultStr = 0;
        List<Integer> wordLength = new ArrayList<>();

        for (int i = 0; i < encodedString.length(); i++) {
            if (encodedString.charAt(i) != ':') {
                resultStr = resultStr * 10 + (encodedString.charAt(i) - '0');
            } else {
                wordLength.add(resultStr);
                resultStr = 0;
            }
        }
        String actualWord = encodedString.substring(encodedString.lastIndexOf(":") + 1);
        int startIdx = 0;
        List<String> words = new ArrayList<>();
        for (int i = 1; i <= wordLength.get(0); i++) {
            int end = startIdx + wordLength.get(i);
            String s = actualWord.substring(startIdx, end);
            words.add(s);
            startIdx = end;

        }
        return words;
    }

    public List<String> decodeOriginal(String s) {
        List<String> result = new LinkedList<String>();
        int i = 0;
        int numOfStr = 0;
        while (s.charAt(i) != ':') {
            numOfStr = numOfStr * 10 + (s.charAt(i) - '0');
            i++;
        }
        List<Integer> lengths = new LinkedList<Integer>();
        i++;
        for (int j = 0; j < numOfStr; j++) {
            int leng = 0;
            while (s.charAt(i) != ':') {
                leng = leng * 10 + (s.charAt(i) - '0');
                i++;
            }
            lengths.add(leng);
            i++;
        }
        for (Integer l : lengths) {
            String tmp = "";
            for (int j = 0; j < l; j++) {
                tmp += s.charAt(i);
                i++;
            }
            result.add(tmp);
        }
        return result;
    }
}
