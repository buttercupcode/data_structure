package leetcode;

public class JumpGameII45 {
    public static void main(String[] args) {
        JumpGameII45 jg = new JumpGameII45();
        int[] input = new int[]{2,3,1,1,4};
        input = new int[]{3, 2, 1, 0, 1}  ;
        int out=0;
        out= jg.jump(input);
        System.out.println(out);
    }
    public int jump(int[] nums) {
        int jump=0,curEnd=0, farthest=0;
        for(int i=0;i< nums.length-1;i++){
            farthest= Math.max(farthest,i+nums[i]);
            if(i==curEnd){
                jump++;
                curEnd=farthest;
            }
        }
        return jump;
    }
}
