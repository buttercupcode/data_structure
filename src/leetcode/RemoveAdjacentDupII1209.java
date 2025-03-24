package leetcode;

public class RemoveAdjacentDupII1209 {
    public static void main(String[] args) {
        RemoveAdjacentDupII1209 d = new RemoveAdjacentDupII1209();
        String out = d.removeDuplicates("deeedbbcccbdaa", 3);
        System.out.println(out);
    }
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int[] count = new int[s.length()];

        for(int i =0; i<sb.length();i++){
            if(i==0 || sb.charAt(i)!=sb.charAt(i-1)){
                count[i]=1;

            }
            else{
                count[i]=count[i-1]+1;
                if(count[i]==k){
                    sb.delete(i-k+1,i+1);
                    i=i-k;
                }
            }
        }
        return sb.toString();
    }
}
