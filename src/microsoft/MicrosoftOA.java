package microsoft;

import tree.TreeExamples;
import tree.TreeNode;

import java.util.*;

public class MicrosoftOA {
    TreeExamples treeExamples = new TreeExamples();
    public static void main(String[] args) {
        MicrosoftOA moa = new MicrosoftOA();
        System.out.println("Expect: 4, output: " + moa.subArray(new int[]{-3, -2, 1, 0, 8, 7, 1}, 3));
        System.out.println("Expect: Codility, output: " + moa.cropWords("Codility Me test coders", 10));
        TreeNode tn =  moa.treeExamples.tree1();
        System.out.println(moa.countGoodNodes(tn));


        System.out.println("Expect: 2, output: " + moa.numTimesAllShine(new int[]{3,2,4,1,5}));
        System.out.println("Expect: 1, output: " + moa.numTimesAllShine(new int[]{4,1,2,3}));
        System.out.println("Expect: 3, output: " + moa.numTimesAllShine(new int[]{2,1,4,3,6,5}));
        System.out.println("Expect: 2, output: " + moa.minMeetingRooms(new int[][]{{0, 30},{5, 10},{15, 20}}));
    }

    public int subArray(int[] nums, int M){
        if(M<=1) return nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int max=0;
        for(int i =0; i< nums.length;i++){
            int rem = nums[i]%M;
            rem= rem>=0?rem: rem+M;
           int key =  map.getOrDefault(rem,0)+1;
           max = Math.max(max,key);
            map.put(rem, key);
        }
        return max;
    }

    public String cropWords(String s, int k){
        if(k >= s.length()){
            return s;
        }
        while(s.charAt(k) != ' '){
            k--;
        }
        while(k > 0 && s.charAt(k) == ' '){
            k--;
        }
        return s.substring(0, k + 1);
    }

    public int countGoodNodes(TreeNode node){
    List<Integer> goodNodes= new ArrayList<>();
    dfsCountGoodNodes(node,Integer.MIN_VALUE,goodNodes);
    return  goodNodes.size();
    }

    public void dfsCountGoodNodes(TreeNode node, int max, List<Integer> goodNodes){
        if(node==null)
            return;
        if(node.getVal()>= max) {
            max= node.getVal();
            goodNodes.add(node.getVal());
        }
        dfsCountGoodNodes(node.getLeft(),max,goodNodes);
        dfsCountGoodNodes(node.getRight(),max,goodNodes);
    }

    public  int numTimesAllShine(int[] A) {
        int rightMost = 0, res = 0;
        for (int i = 0; i < A.length; i++) {
            rightMost = Math.max(rightMost, A[i]);
            if (rightMost == i + 1) res++;
        }
        return res;
    }
    public  int minMeetingRooms(int[][] is) {
        //This is actually a sliding window question,
        //left is the last start,
        //right is the first end after start
        //room is the rooms in the sliding window,
        //since it is an expanding window, the room in current window is current max;
        int n = is.length, room = 0;
        int[] starts = new int[n], ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = is[i][0];
            ends[i] = is[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        for (int l = 0, r = 0; l < n; l++) {
            if (starts[l] < ends[r]) room++;
            else if (++r == n) break;
        }
        return room;
    }
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals==null||intervals.length==0)
            return 0;

        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start-i2.start;
            }
        });

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        int numberOfMeetingRoomsUsed = 1;
        queue.offer(intervals[0].end);

        for(int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < queue.peek()) {
                numberOfMeetingRoomsUsed++;
            } else {
                queue.poll();
            }

            queue.offer(intervals[i].end);
        }

        return numberOfMeetingRoomsUsed;
    }
}
