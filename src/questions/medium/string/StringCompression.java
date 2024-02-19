package questions.medium.string;

public class StringCompression {
    public static void main(String[] args) {
        StringCompression sc = new StringCompression();
       /* System.out.println( sc.compress(new char[]{'a','a','b','b','c','c','c'}));
        System.out.println( sc.compress(new char[]{'a'}));
        System.out.println( sc.compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));

        */
        System.out.println(sc.compress(new char[]{'a', 'a', 'a', 'b', 'b', 'a', 'a'}));

    }

    public int compress(char[] chars) {


        int i = 0, j = 0, idx = 0;
        while (i < chars.length) {
            char ch = chars[i];
            int counter = 0;
            while (j < chars.length && chars[j] == ch) {
                counter++;
                j++;
            }
            chars[idx++] = ch;
            if (counter > 1) {

                for (char s : String.valueOf(counter).toCharArray()) {
                    chars[idx++] = s;
                }
            }
            i = j;
        }
        return idx;
    }
}
