package leetcode;

public class TwoSumII167 {
    public static void main(String[] args) {
        TwoSumII167 twoSumII167 = new TwoSumII167();
        int[] output;
//        output= twoSumII167.twoSum(new int[]{2,7,11,15},9);
//        print(output);
//
//        output= twoSumII167.twoSum(new int[]{2,3,4},6);
//        print(output);
//
//        output= twoSumII167.twoSum(new int[]{-1,0},-1);
//        print(output);
//
//        output= twoSumII167.twoSum(new int[]{2,7,11,15},9);
//        print(output);


        output = twoSumII167.twoSum(new int[]{3, 24, 50, 79, 88, 150, 345}, 200);
        print(output);
    }

    public static void print(int[] output) {
        for (int out : output) {
            System.out.print(out + ",");
        }
        System.out.println();
    }

    //two pointer
    public int[] twoSumTwoPointer(int[] numbers, int target) {
        int begin = 0, end = numbers.length - 1;
        while (begin <= end) {
            int num = numbers[begin] + numbers[end];
            if (num == target)
                return new int[]{begin + 1, end + 1};
            else if (num > target) {
                end--;
            } else {
                begin++;
            }
        }
        return new int[]{};
    }

    //binary
    public int[] twoSum(int[] numbers, int target) {


        for (int i = 0; i < numbers.length; i++) {
            int begin = i + 1, end = numbers.length - 1;

            while (begin <= end) {
                int mid = begin + (end - begin) / 2;
                int i1 = numbers[mid] + numbers[i];
                if (target == i1) {
                    return new int[]{i + 1, mid + 1};
                } else if (target > i1) {
                    begin = mid + 1;
                } else {
                    end = mid - 1;
                }

            }

        }
        return new int[]{0, 0};
    }
}
