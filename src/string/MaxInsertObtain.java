package string;

public class MaxInsertObtain {
    public static void main(String[] args) {
        MaxInsertObtain m = new MaxInsertObtain();
        System.out.println(m.getMaxInsert("aabab"));
    }

    public int getMaxInsert(String s) {

        int As = 0;
        int others = 0;
        int l = s.length();
        for (int i = 0; i < l; i++) {
            if (s.charAt(i) == 'a') {
                As++;
            } else {
                others++;
                As = 0;
            }
            if (As == 3)
                return -1;
        }
        return 2 * (others + 1) - (l - others);

    }
}
