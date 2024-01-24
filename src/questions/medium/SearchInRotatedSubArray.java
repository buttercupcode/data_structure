package questions.medium;

public class SearchInRotatedSubArray {
    public static void main(String[] args) {
        SearchInRotatedSubArray sra = new SearchInRotatedSubArray();
        boolean out = false;
        //out= sra.search(new int[]{2,5,6,0,0,1,2},0);
        //out= sra.search(new int[]{2,5,6,0,0,1,2},3);
        out = sra.search(new int[]{5, 1, 3}, 3);
        System.out.println(out);
    }

    public boolean search(int[] num, int target) {
        int left = 0, right = num.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (num[mid] == target)
                return true;
            if (num[mid] < num[left]) {
                if (num[mid] <= target && num[right] >= target)
                    left = mid + 1;
                else
                    right = mid - 1;
            } else if (num[mid] > num[left]) {
                if (num[mid] > target && num[left] <= target)
                    right = mid - 1;
                else
                    left = mid + 1;

            } else
                left++;


        }
        return false;

    }
}
