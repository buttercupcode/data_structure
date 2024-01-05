package questions;

import java.util.*;

public class KFrequentElements {

    public static void main(String[] args) {
        KFrequentElements kFrequentElements = new KFrequentElements();
        kFrequentElements.topKFrequent(new int[]{1,1,1,2,2,3},2);
    }
/*
using arrays and map
 */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int num : nums){
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
        }
        List<Integer>[] freqList = new List[nums.length+1];
        freqMap.forEach((key,value)->{
            List<Integer> elements = freqList[value];
            if (elements==null)
            {
                elements = new ArrayList<>();
            }
            elements.add(key);
            freqList[value]=elements;
        });
        List<Integer> res = new ArrayList<>();

        for(int i =freqList.length-1;i>=0&& k>0;i--) {
            if(freqList[i]!=null){
                List<Integer> elements = freqList[i];
                res.addAll(elements);
                k-=elements.size();
            }
        }
        int[] res1= new int[res.size()];
        int count=0;
        for(int num: res){
            res1[count++]= num;

        }
        return res1;
    }
    public int[] topKFrequentPQ(int[] nums, int k) {
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int num : nums){
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap= new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        freqMap.entrySet().forEach(maxHeap::add);
            int[] res = new int[k];
            int count=0;
            while(count<k) {
                Map.Entry<Integer, Integer> entry = maxHeap.poll();
                res[count++]= entry.getKey();
            }
        return  res;
    }

}
