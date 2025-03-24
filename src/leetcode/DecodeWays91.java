package leetcode;

public class DecodeWays91 {
    public static void main(String[] args) {
        DecodeWays91 d = new DecodeWays91();
        System.out.println(d.numDecodings("12"));
        System.out.println(d.numDecodings("226"));
    }
    public int numDecodings(String s) {
        return num(s,0);
    }

    public int num(String s,int i){
        if(i==s.length())
            return 1;
        char ch = s.charAt(i);
        if(ch =='0')
            return 0;
        int one= num(s,i+1);
        int two =0;
        if((i <s.length()-1)&&
                ((ch=='1') || (ch=='2' && s.charAt(i+1)<='6')))
            two= num(s,i+2);
        return one+two;

    }
}
