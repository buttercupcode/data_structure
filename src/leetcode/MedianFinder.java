package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> small = new PriorityQueue<>();
    PriorityQueue<Integer> big = new PriorityQueue<>(Collections.reverseOrder());
    boolean even  = true;

    public MedianFinder() {

    }

    public void addNum(int num) {
        if(even){
            big.offer(num);
            small.offer(big.poll());
        }else {
            small.offer(num);
            big.offer(small.poll());
        }

    }

    public double findMedian() {
        if(even)
            return ((double) small.peek()+ (double) big.peek())/2.0;
        else
            return small.peek();
    }
}
