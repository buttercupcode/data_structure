package questions.easy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFromDataStream {

    PriorityQueue<Integer> small = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> big = new PriorityQueue<>();
    boolean even = true;

    public MedianFromDataStream() {

    }

    public static void main(String[] args) {
        MedianFromDataStream obj = new MedianFromDataStream();
        obj.addNum(1);
        obj.addNum(2);
        double param_2 = obj.findMedian();
        System.out.println(param_2);
    }

    public void addNum(int num) {
        if (even) {
            big.offer(num);
            small.offer(big.poll());
        } else {
            small.offer(num);
            big.offer(small.poll());
        }
        even = !even;
    }

    public double findMedian() {
        if (even)
            return (small.peek() + big.peek()) / 2.0;
        else {

            return small.peek();
        }

    }
}
