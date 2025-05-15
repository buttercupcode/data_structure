package leetcode.array.oned.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubStringConcatenationOfWords30 {
    public static void main(String[] args) {
        SubStringConcatenationOfWords30 s = new SubStringConcatenationOfWords30();
        for (Integer barfoothefoobarman : s.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"})) {
            System.out.println(barfoothefoobarman);
        }

    }
    // brute force approach
   /* public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length();
        int subStringSize = words.length * words[0].length();
        Map<String, Integer> freq = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for( String word : words){
            freq.put(word, freq.getOrDefault(word,0)+1);
        }

        for( int i =0; i< n - subStringSize +1; i++ ){
            if(check(i,s,subStringSize, words[0].length(), freq,words.length)){
                ans.add(i);
            }
        }
        return ans;
    }
    private boolean check(int i, String s, int subStringSize, int wordLength, Map<String,Integer> wordCount, int totalWords ){
        Map<String,Integer> seen = new HashMap<>(wordCount);
        int wordsUsed=0;
        for(int j = i; j< i+ subStringSize; j+=wordLength){
            String sub = s.substring(j, j+wordLength);
            if(seen.getOrDefault(sub,0)!=0){
                seen.put(sub,seen.get(sub)-1);
                wordsUsed++;
            }
            else{
                break;
            }
        }
        return wordsUsed==totalWords;
    }*/


        private HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
        private int n;
        private int wordLength;
        private int substringSize;
        private int k;

        private void slidingWindow(int left, String s, List<Integer> answer) {
            HashMap<String, Integer> wordsFound = new HashMap<>();
            int wordsUsed = 0;
            boolean excessWord = false;

            // Do the same iteration pattern as the previous approach - iterate
            // word_length at a time, and at each iteration we focus on one word
            for (int right = left; right <= n - wordLength; right += wordLength) {
                String sub = s.substring(right, right + wordLength);
                if (!wordCount.containsKey(sub)) {
                    // Mismatched word - reset the window
                    wordsFound.clear();
                    wordsUsed = 0;
                    excessWord = false;
                    left = right + wordLength;
                } else {
                    // If we reached max window size or have an excess word
                    while (right - left == substringSize || excessWord) {
                        String leftmostWord = s.substring(left, left + wordLength);
                        left += wordLength;
                        wordsFound.put(leftmostWord,wordsFound.get(leftmostWord) - 1);

                        if (wordsFound.get(leftmostWord) >=wordCount.get(leftmostWord)) {
                            // This word was an excess word
                            excessWord = false;
                        } else {
                            // Otherwise we actually needed it
                            wordsUsed--;
                        }
                    }

                    // Keep track of how many times this word occurs in the window
                    wordsFound.put(sub, wordsFound.getOrDefault(sub, 0) + 1);
                    if (wordsFound.get(sub) <= wordCount.get(sub)) {
                        wordsUsed++;
                    } else {
                        // Found too many instances already
                        excessWord = true;
                    }

                    if (wordsUsed == k && !excessWord) {
                        // Found a valid substring
                        answer.add(left);
                    }
                }
            }
        }

        public List<Integer> findSubstring(String s, String[] words) {
            n = s.length();
            k = words.length;
            wordLength = words[0].length();
            substringSize = wordLength * k;

            for (String word : words) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }

            List<Integer> answer = new ArrayList<>();
            for (int i = 0; i < wordLength; i++) {
                slidingWindow(i, s, answer);
            }

            return answer;
        }
    }

