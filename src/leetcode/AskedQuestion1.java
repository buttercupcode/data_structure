package leetcode;

import java.io.*;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Main class should be named 'Solution' and should not be public.
// input: ((2,5), (10,15), (12,16))
// output: ((2,5), (10,16))
class Solution {

    static Comparator<Integer[]> c1 = (a1,a2) -> Integer.compare(a1[0],a2[0]);
    public static void main(String[] args) {
        System.out.println("Hello, World");

        Integer[] a1 = new Integer[]{2,5};
        Integer[] a2 = new Integer[]{10,30};
        // Integer[] a3 = new Integer[]{12,16};
        // Integer[] a4 = new Integer[]{15,20};
        Integer[] a5 = new Integer[]{24,30};
        List<Integer[]> list = new  ArrayList<>();
        list.add(a1);
        // list.add(a3);
        // list.add(a4);
        list.add(a2);
        list.add(a5);

        List<Integer[]> out = getOverLap(list);
        System.out.println("after problem solution");
        out.forEach(a-> System.out.println(a[0]+","+a[1]));

    }

    public static List<Integer[]> getOverLap(List<Integer[]> input){

        input.sort(c1);
        input.forEach(a-> System.out.println(a[0]+","+a[1]));
        List<Integer[]> output = new ArrayList<>();
        int i =0;
        while(  i<input.size() ){

            Integer[] pair = input.get(i);

            boolean flag = true;
            int counter = i+1;
            System.out.println("pair "+ pair[0]+ ": " +pair[1]);
            while(flag){
                //int end = input.get(counter)[0];
                if(counter< input.size() && pair[1]>= input.get(counter)[0]){
                    pair[1]=input.get(counter)[1];
                    counter++;
                    System.out.println("pair after modification "+ pair[0]+ ": " +pair[1]);
                    System.out.println("counter "+ counter);
                }else{
                    output.add(pair);
                    System.out.println("pair after adding "+ pair[0]+ ": " +pair[1]);
                    i=counter;
                    flag=false;
                }
            }
        }
        return output;
    }
}
