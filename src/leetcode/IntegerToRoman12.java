package leetcode;

public class IntegerToRoman12 {
    public static void main(String[] args) {
        IntegerToRoman12 i = new IntegerToRoman12();
        String output = i.intToRoman(1994);
        System.out.println(output);
    }

    public String intToRoman(int num) {
        String[] ones = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tens = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hundreds = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thousands = new String[]{"", "M", "MM", "MMM"};
        String s = thousands[num / 1000];
        s += hundreds[(num % 1000) / 100];
        s += tens[(num % 100) / 10];
        s += ones[(num % 10)];
        return s;
    }
}
