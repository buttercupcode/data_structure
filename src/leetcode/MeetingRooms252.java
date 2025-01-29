package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms252 {
    public static void main(String[] args) {
        MeetingRooms252 m = new MeetingRooms252();
        int[][] intervals = new int[][]{{0,30},{5,10},{15,20}};
       boolean b =  m.meetingRooms(intervals);
        System.out.println(b);

       intervals = new int[][]{{7,10},{2,4}};
       b = m.meetingRooms(intervals);
        System.out.println(b);
    }


    public boolean meetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for( int i =0; i< intervals.length-1; i++){
            if(intervals[i][1]>intervals[i+1][0] )
                return  false;
        }
        return  true;
    }
}
