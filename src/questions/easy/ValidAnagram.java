package questions.easy;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
    ValidAnagram va = new ValidAnagram();
    //String  s = "anagram", t = "nagaram";
    //String   s = "rat", t = "car";
    String   s = "ab", t = "a";
        boolean anagram = va.isAnagram(s, t);
        System.out.println(anagram);
    }

    public boolean isAnagram(String s, String t) {

        if(s.length()!= t.length())
            return false;
        Map<Character,Integer> map = new HashMap<>();
        for(Character c: s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(Character c :t.toCharArray()){
            int freq = map.getOrDefault(c,0);
            if(freq==0)
                return false;
            else
                map.put(c,freq-1);
        }
        return  true;
        /*if(s.length()!=t.length())
            return false;
        int[] freq = new int[26];
        for(int i =0;i<s.length();i++ ){
            freq[s.charAt(i)-'a']++;
            freq[t.charAt(i)-'a']--;
        }
        for(int i = 0; i< freq.length; i++){
            if(freq[i]!=0)
                return false;
        }
        return  true;

         */
    }
}
