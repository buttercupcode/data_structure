package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayFindDuplicate {

    public static void main(String[] args) {
        ArrayFindDuplicate a = new ArrayFindDuplicate();
        int[] nums= new int[]{2,5,9,6,9,3,8,9,7,1};
        System.out.println(a.dupBySorting(nums));
        System.out.println(a.dupBySet(nums));
    }

    public int dupBySorting(int[] nums){
        Arrays.sort(nums);
        for(int i =1;i<nums.length;i++){
            if( nums[i]==nums[i-1])
                return nums[i];
        }
        return -1;
    }
    public int dupBySet(int[] nums){
        Set<Integer> numSet= new HashSet<Integer>();
        for(int num : nums){
            if(numSet.contains(num))
                return num;
            numSet.add(num);
        }
        return -1;
    }


}
