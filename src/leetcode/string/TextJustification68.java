package leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class TextJustification68 {
    public static void main(String[] args) {
        TextJustification68 t = new TextJustification68();
        List<String> strings = t.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
        strings.forEach(System.out::println);

    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        int i =0;
        List<String> ans = new ArrayList<>();
        while(i< words.length) {
            List<String> line = getWords(i,words,maxWidth);
            i+= line.size();
            ans.add(createLine(line,i,words,maxWidth));
        }
        return ans;
    }

    private List<String> getWords(int i, String[] words, int maxWidth){
        List<String> line = new ArrayList<>();
        int currWidth =0;
        while(i< words.length && currWidth +words[i].length()<=maxWidth){
            line.add(words[i]);
            currWidth+= words[i].length()+1;
            i++;
        }
        return line;
    }

    private String createLine(List<String> line,int i,String[] words,int maxWidth){
        int baseLength=-1;
        for(String word :line){
            baseLength+= word.length() +1;
        }
        int extraSpace= maxWidth-baseLength;
        if(line.size()==1 || i==words.length){
            return String.join(" ",line)+ " ".repeat(extraSpace);
        }
        // this is because we dont want to count last word
        int wordCount = line.size()-1;
        int spacePerWord = extraSpace/wordCount;
        int needsExtraSpace= extraSpace%wordCount;
        for(int j =0;j<needsExtraSpace ; j++){
            line.set(j,line.get(j)+" ");
        }
        for(int j =0; j< wordCount;j++){
            line.set(j,line.get(j)+" ".repeat(spacePerWord));
        }
        return  String.join(" ",line);
    }
}
