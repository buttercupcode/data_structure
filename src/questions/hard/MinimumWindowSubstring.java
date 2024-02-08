package questions.hard;

public class MinimumWindowSubstring {
    public static void main(String[] args) {

    }

    public String minWindow(String s, String t) {
    if(s==null|| t==null||s.isEmpty()||t.isEmpty()|| s.length()<t.length())
        return "";
    int[] map = new int[128];
    for(char c : t.toCharArray())
        map[c-'A']++;
    int left=0,right=0,minLen=s.length()+1, startIndex=0;
    int count=0;
        char[] chS = s.toCharArray();
    while(right<chS.length){
        if(map[chS[right++]]-- >0)
            count--;
        while(count==0){
            if(right-left<minLen){
                startIndex=left;
                minLen=right-left;
            }
            if(map[chS[left++]]++==0){
                count++;
            }
        }

    }
    return minLen== s.length()+1?"":new String(chS,startIndex,minLen);
    }

}
