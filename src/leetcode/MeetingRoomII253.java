package leetcode;

public class MeetingRoomII253 {
    public static void main(String[] args) {

    }

    public int maxRooms(int[][] intervals) {
        int[] occupancy = new int[1000010];
        int max = 0, sum = 0;
        for (int[] interval : intervals) {
            occupancy[interval[0]] += 1;
            occupancy[interval[1]] -= 1;
        }
        for (int i : occupancy) {
            sum += i;
            max = Math.max(sum, max);
        }
        return max;
    }
}
