package array;

import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class ArrayExamples {
    public static void main(String[] args) {
        //int[] nums = new int[]{3, 4, 9, 1, 3, 9, 5};
        ArrayExamples k = new ArrayExamples();
        //List<Integer> kDistantIndices = k.findKDistantIndices(new int[]{2,2,2,2,2}, 2, 2);
        //System.out.println(kDistantIndices);
        //nums = new int[]{1, 5, 9, 1, 5, 9};
        //                 indexDiff = 3, valueDiff = 0
        //k.containsNearbyAlmostDuplicate(nums,2,3);
        //k.maxProfit(new int[]{7,1,5,3,6,4});
        // System.out.println(k.productExceptSelf(new int[]{1,2,3,4,5}));
        //System.out.println(k.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        //System.out.println(k.maxSubArray(new int[]{2,1,-3,4,-1,2,1,-5,4}));
        //System.out.println(k.subarraySum(new int[]{-1,-1,1},0));
        //System.out.println(k.maxProduct(new int[]{2,3,-2,4}));
        // System.out.println(k.findPairs(new int[]{1,2,4,4,3,3,0,9,2,3},3));
        //System.out.println(k.findPairs(new int[]{3,1,4,1,5},        2));
        //System.out.println(k.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        //System.out.println(k.trapWater(new int[]{4, 2, 0, 3, 2, 5, 1, 0, 4}));
        //System.out.println(k.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        //System.out.println(k.medianTwoSortedArray(new int[]{1,2},new int[] {3,4}));
        //System.out.println(k.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
        // System.out.println(k.subArraysDivByK(new int[]{4,5,0,-2,-3,1},5));
        //System.out.println(k.numSubArrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
        // System.out.println(k.maxProduct2(new int[]{2, 3, -2, 4}));
        //System.out.println(k.replaceElements(new int[]{17,18,5,4,6,1}));
        //int[][] meetingIntervals= new int[][]{new int[]{0,30},new int[]{5,10},new int[]{15,20}};
        //System.out.println(k.canAttendMeetings(meetingIntervals));
        //System.out.println(k.nextGreaterElement(  new int[]{4,1,2},new int[]{1,3,4,2}));
        //System.out.println(k.rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3));
       // System.out.println(k.findMin(new int[]{3,4,5,1,2}));
       // System.out.println(k.searchInRotatedSortedArray(new int[]{1,3},3));
        //System.out.println(k.findShortestSubArray(new int[]{1,2,2,3,1}));
        k.nextGreaterElements(new int[]{1,2,1});
    }

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> sort = new ArrayList<>();
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                for (j = max(j, i - k); j <= i + k && j < nums.length; j++) {
                    sort.add(j);
                }
            }
        }
        return sort;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket) || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t) || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                return true;
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }

    public int maxProfit(int[] prices) {
        int buyPrice = Integer.MAX_VALUE;
        int sellPrice = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
                sellPrice = prices[i];
            }
            if (prices[i] > sellPrice) {
                sellPrice = prices[i];
            }
            if ((i + 1 != prices.length) && (prices[i] > prices[i + 1]) && (sellPrice > buyPrice)) {
                sum = sum + (sellPrice - buyPrice);
                buyPrice = Integer.MAX_VALUE;
                sellPrice = Integer.MIN_VALUE;
            }
        }
        return sum;
    }

    public int maxProfit2(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int maxProf = 0;
        for (int i = 0; i < prices.length; i++) {
            buy = Math.min(buy, prices[i]);
            int todayProf = prices[i] - buy;
            if (todayProf > maxProf) maxProf = todayProf;
        }
        return maxProf;
    }

    public int maximumDifference(int[] nums) {
        int min = Integer.MAX_VALUE;
        int diff = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            int currentDiff = nums[i] - min;
            if (currentDiff > diff) diff = currentDiff;
        }
        return diff > 0 ? diff : -1;
    }

    /**
     * Input: colors = [1,1,1,6,1,1,1]
     * Output: 3
     * Explanation: In the above image, color 1 is blue, and color 6 is red.
     * The furthest two houses with different colors are house 0 and house 3.
     * House 0 has color 1, and house 3 has color 6. The distance between them is abs(0 - 3) = 3.
     * Note that houses 3 and 6 can also produce the optimal answer.
     */
    public int maxDistanceColorHouses(int[] colors) {
        int i = 0, n = colors.length, j = n - 1;
        while (colors[0] == colors[j]) j--;
        while (colors[n - 1] == colors[i]) i++;
        return Math.max(j, n - i - 1);
    }

    public int[] productExceptSelf(int[] nums) {
        int[] finalArray = new int[nums.length];
        /*int product=1;
        int zeroCount=0;
        for(int i=0; i<nums.length;i++){
            if(nums[i]!=0)
                product=product*nums[i];
            else
                zeroCount++;
        }
        for(int j=0; j< nums.length;j++){
            if(zeroCount==0){

                finalArray[j]= product/nums[j];
            }
            else if(zeroCount==1){
                if(nums[j]!=0)
                    finalArray[j]=0;
                else
                    finalArray[j]=product;
            }
            else
                finalArray[j]=0;
        }
        return finalArray;
    }*/
        int left = 1;
        finalArray[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            finalArray[i] = left * nums[i - 1];
            left = finalArray[i];
        }
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            finalArray[i] = finalArray[i] * right;
            right = right * nums[i];
        }
        return finalArray;
    }

    public int minSubArrayLen(int target, int[] nums) {
        int length = Integer.MAX_VALUE;
           /* int sum=0;
            for(int i=0; i<nums.length; i++){
                int j=1;
                while(target>=sum && (i+j-1<nums.length)){
                    sum=sum+nums[i+j-1];
                    if(target<=sum && (j< length)) {
                        length=j;
                        break;
                    }
                    j++;
                }

                sum=0;
            }
            return length<Integer.MAX_VALUE? length:0;*/
        int j = 0, sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {

            sum = sum + nums[i];
            while (sum > target) {
                length = min(i - j, length);
                sum = sum - nums[j++];
            }
        }
        return length < Integer.MAX_VALUE ? length : 0;
    }

    public int maxSubArray(int[] A) {
        int maxSoFar = A[0], maxEndingHere = A[0];
        for (int i = 1; i < A.length; ++i) {
            maxEndingHere = max(maxEndingHere + A[i], A[i]);
            maxSoFar = max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public int subarraySum(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }

        return result;
    }

    int maxProduct(int[] A) {
        // store the result that is the max we have found so far
        int r = A[0];
        int n = A.length;
        // imax/imin stores the max/min product of
        // subarray that ends with the current number A[i]
        for (int i = 1, imax = r, imin = r; i < n; i++) {
            // multiplied by a negative makes big number smaller, small number bigger
            // so we redefine the extremums by swapping them
            if (A[i] < 0) {

                int temp = imin;
                imin = imax;
                imax = temp;
            }

            // max/min product for the current number is either the current number itself
            // or the max/min by the previous number times the current one
            imax = max(A[i], imax * A[i]);
            imin = min(A[i], imin * A[i]);

            // the newly computed max value is a candidate for our global result
            r = max(r, imax);
        }
        return r;
    }

    public int maxProduct2(int[] nums) {
       /* int maxProd = Integer.MIN_VALUE;
        int j=0,currentProd=1;
        for(int i=0;i<nums.length;i++){
            currentProd= nums[i] * currentProd;
            if(currentProd<=maxProd){
                while(j<i && currentProd<maxProd){
                    currentProd=currentProd/nums[j];
                    j++;
                }
            }
            maxProd=Math.max(maxProd,currentProd);
        }
        return maxProd;*/
        int r = nums[0];
        int iMax = r, iMin = r;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = iMax;
                iMax = iMin;
                iMin = temp;
            }
            iMax = Math.max(iMax * nums[i], nums[i]);
            iMin = Math.min(iMin * nums[i], nums[i]);
            r = Math.max(r, iMax);
        }
        return r;
    }

    public void swap(int i, int j) {
        int temp = i;
        i = j;
        j = temp;
    }

    public int findPairs(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> freqMap = new HashMap<>();
        int freq = 0;
        for (int i = 0; i < n; i++) {
            freqMap.put(nums[i], (freqMap.getOrDefault(nums[i], 0) + 1));
        }
        for (Map.Entry<Integer, Integer> e : freqMap.entrySet()) {
            int sum = e.getKey() + k;
            if (freqMap.containsKey(sum)) freq++;
        }
        return freq;
    }

    public int maxArea(int[] height) {
        int water = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            water = Math.max(water, (j - 1) * (Math.min(height[i], height[j])));
            if (height[i] < height[j]) i++;
            else j--;
        }
        return water;
    }

    public int trapWater(int[] height) {
        int maxLeft = 0, maxRight = 0, water = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > maxLeft) maxLeft = height[left];
                else water += maxLeft - height[left];
                left++;
            } else {
                if (height[right] > maxRight) maxRight = height[right];
                else water += maxRight - height[right];
                right--;
            }
        }
        return water;
    }

    public int longestConsecutive(int[] arr) {
        Set<Integer> elements = new HashSet<>();
        for (int i : arr) {
            elements.add(i);
        }
        int longestStreak = 0;
        for (int num : elements) {
            if (!elements.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (elements.contains(currentNum + 1)) {
                    currentNum = currentNum + 1;
                    currentStreak += 1;

                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

    public double medianTwoSortedArray(int[] input1, int[] input2) {
        if (input1 == null || input2 == null) throw new IllegalArgumentException();
        if (input1.length > input2.length) return medianTwoSortedArray(input2, input1);
        int x = input1.length;
        int y = input2.length;
        int low = 0;
        int high = x;
        while (low <= high) {
            int positionX = (high + low) / 2;
            int positionY = (x + y + 1) / 2 - positionX;
            int maxLeft1 = (positionX == 0) ? Integer.MIN_VALUE : input1[positionX - 1];
            int minRight1 = (positionX == x) ? Integer.MAX_VALUE : input1[positionX];

            int maxLeft2 = positionY == 0 ? Integer.MIN_VALUE : input2[positionY - 1];
            int minRight2 = positionY == y ? Integer.MAX_VALUE : input2[positionY];
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if ((x + y) % 2 == 0) {
                    return ((double) Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2;
                } else {
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                high = positionX - 1;
            } else if (maxLeft2 > minRight1) {
                low = positionX + 1;
            }
        }
        throw new IllegalArgumentException();
    }

    public int[] maxSlidingWindow(int[] arr, int k) {
        if (arr == null || k <= 0) return new int[0];

        int n = arr.length;
        int[] result = new int[n - k + 1];
        int ri = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1) deque.poll();
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) deque.pollLast();
            deque.offer(i);
            if (i >= k - 1) result[ri++] = arr[deque.peek()];
        }
        return result;
    }

    public int subArraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int sum = 0, count = 0;
        freq.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum < 0) sum += k;
            int rem = sum % k;
            count += freq.getOrDefault(rem, 0);
            freq.put(rem, freq.getOrDefault(rem, 0) + 1);
        }
        return count;
    }

    public int numSubArrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int currentProd = 1;
        int i = 0, j = 0;
        while (j < nums.length) {
            currentProd *= nums[j];
            while (currentProd >= k && i <= j) {
                currentProd = currentProd / nums[i];
                i++;
            }
            count += j - i + 1;
            j++;
        }
        return count;
    }

    /**
     * Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
     * <p>
     * After doing so, return the array.
     * Input: arr = [17,18,5,4,6,1]
     * Output: [18,6,6,6,1,-1]
     *
     * @param arr
     * @return
     */
    public int[] replaceElements(int[] arr) {
        int oldMax = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int element = arr[i];
            int max = Math.max(element, oldMax);
            arr[i] = oldMax;
            oldMax = max;
        }
        return arr;
    }

    public boolean canAttendMeetings(int[][] arr) {
        Interval[] intervals = new Interval[arr.length];
        int i = 0;
        for (int[] interval : arr) {
            intervals[i] = new Interval(interval[0], interval[1]);
            i++;
        }
        Arrays.sort(intervals, Comparator.comparingInt(i2 -> i2.start));
        Interval later = null;
        for (Interval interval : intervals) {
            if (later != null && interval.start < later.end) return false;
            later = interval;
        }
        return true;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nums2Map = new HashMap<>();
        Stack<Integer> maxStack = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!maxStack.isEmpty() && nums2[i] > maxStack.peek()) {
                maxStack.pop();
            }
            nums2Map.put(nums2[i], maxStack.isEmpty() ? -1 : maxStack.peek());
            maxStack.add(nums2[i]);
        }
        int[] output = new int[nums1.length];
        int c = 0;
        for (int num : nums1) {
            output[c] = nums2Map.getOrDefault(num, -1);
            c++;
        }
        return output;
    }

    /*    public int[] rotate(int[] nums, int k) {
            int n = nums.length;
            int[] output= new int[n];
            if(k%n==0)
                return nums;
            for(int i =0; i<n;i++){
                int newPos = (i+k) %n;
                output[newPos]= nums[i];
            }
            return output;
        }*/
    public int[] rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        return nums;
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            end--;
            start++;
        }
    }
    public int findMin(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int n = nums.length;
        int start=0,end= n-1;
        while(start<end){
            int mid= (start+end)/2;
            if(mid>0 && nums[mid]<nums[mid-1])
                return nums[mid];
            else if(nums[mid]>nums[end])
                start=mid+1;
            else
                end=mid-1;
        }
        return nums[start];
    }

    public int searchInRotatedSortedArray(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[start] <= nums[mid]){
                if (target < nums[mid] && target >= nums[start])
                    end = mid - 1;
                else
                    start = mid + 1;
            }

            if (nums[mid] <= nums[end]){
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }
    class Interval {
        int start;
        int end;

        Interval() {
            this.start = 0;
            this.end = 0;
        }

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int findShortestSubArray(int[] nums) {
        Map<Integer,Integer> count= new HashMap<>(), firstOccurrence = new HashMap<>();
        int degree=0,res=0;
        for(int i =0; i< nums.length;i++){
            firstOccurrence.putIfAbsent(nums[i],i);
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            if(count.get(nums[i])> degree){
                degree= count.get(nums[i]);
                res= i-firstOccurrence.get(nums[i])+1;
            }
            else if(count.get(nums[i])==degree){
                res=Math.min(res,i-firstOccurrence.get(nums[i])+1);
            }
        }
        return res;
    }
    public int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack  = new Stack<>();
        Arrays.fill(result,-1);
        for(int i=2*n-1;i>=0;i--){
            int num=arr[i%n];
            while(!stack.isEmpty() && stack.peek()<=num)
                stack.pop();
            if(!stack.isEmpty())
                result[i%n]= stack.peek();
            stack.push(num);
        }
        return result;
    }
}
