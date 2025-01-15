package leetcode;

public class HappyNumber202 {
    public static void main(String[] args) {
        HappyNumber202 hn = new HappyNumber202();
        boolean b;
        //b = hn.isHappy(19);
        //System.out.println(b);
        b = hn.isHappy(2);
        System.out.println(b);
    }

    public boolean isHappy(int num) {

        int slow = num, fast = num;
        while ((slow != fast) && fast != 1) {
            slow = square(slow);
            fast = square(square(fast));
        }
        return fast == 1;
    }

    public int square(int num) {
        int ans = 0;
        while (num > 0) {
            int x = num % 10;
            ans += x * x;
            num = num / 10;
        }
        return ans;
    }
}
