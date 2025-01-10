package leetcode;

import java.util.List;

public class ReverseWordsInString151 {
    public static void main(String[] args) {
        ReverseWordsInString151 revWords = new ReverseWordsInString151();
        String out = revWords.reverseWords("a good   example");
        System.out.println(out);
        List[] lists = new List[3];

    }

    public String reverseWords(String s) {
        s = s.trim();
        String output = "";
        String[] strArray = s.split(" ");
        for (int i = strArray.length - 1; i >= 0; i--) {
            if (strArray[i] != " " && strArray[i] != "") {
                output += strArray[i] + " ";
            }

        }
        return output.trim();
    }
}
