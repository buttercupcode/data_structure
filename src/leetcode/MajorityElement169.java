package leetcode;

public class MajorityElement169 {
    public static void main(String[] args) {
        MajorityElement169 mj = new MajorityElement169();
        //int r1 = mj.majorityElement(new int[]{3,2,3});
        int r2= mj.majorityElement(new int[]{2,2,1,1,1,2,2});
       // System.out.println(r1);
        System.out.println(r2);

    }
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int count =1;
        for(int i =1; i< nums.length;i++){
            if(count==0)
                majority=nums[i];
            if(majority==nums[i])
                count++;
            else
                count--;
        }
        return majority;
    }
}
