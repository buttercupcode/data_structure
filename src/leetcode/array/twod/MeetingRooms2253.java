package leetcode.array.twod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms2253 {
    public static void main(String[] args) {
        MeetingRooms2253 m = new MeetingRooms2253();
        int[][] input = new int[][]{{0, 30}, {5, 10}, {15, 20}};
        int res = m.minMeetingRoomsArrays(input);
        System.out.println(res);
    }

    public int minMeetingRoomsHeap(int[][] intervals) {
        if (intervals.length == 0 || intervals[0].length == 0)
            return 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        heap.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= heap.peek()) {
                heap.poll();
            }
            heap.add(intervals[i][1]);
        }
        return heap.size();

    }

    public int minMeetingRoomsArrays(int[][] intervals) {
        if (intervals.length == 0 || intervals[0].length == 0) {
            return 0;
        }
        Integer[] start = new Integer[intervals.length];
        Integer[] end = new Integer[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start, Comparator.comparingInt(a -> a));
        Arrays.sort(end, Comparator.comparingInt(a -> a));
        int rooms = 0, endPtr = 0, startPtr = 0;
        while (startPtr < intervals.length) {
            if (start[startPtr] >= end[endPtr]) {
                rooms -= 1;
                endPtr += 1;
            }
            rooms += 1;
            startPtr += 1;
        }
        return rooms;
    }

    public int minMeetingRoomsArrayList(int[][] intervals) {
        if (intervals.length == 0 || intervals[0].length == 0)
            return 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        ArrayList<ArrayList<int[]>> rooms = new ArrayList<>();

        for (int[] ints : intervals) {
            if (rooms.isEmpty()) {
                ArrayList<int[]> n = new ArrayList<>();
                n.add(ints);
                rooms.add(n);
            } else {
                boolean found = false;
                for (ArrayList<int[]> interval : rooms) {
                    if (interval.getLast()[1] < ints[0]) {
                        interval.add(ints);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    ArrayList<int[]> n2 = new ArrayList<>();
                    n2.add(ints);
                    rooms.add(n2);
                }
            }
        }
        return rooms.size();
    }
}
