package questions;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class SubArrayExceedingSum {
    public static void main(String[] args) {

    }

    public int func(int[] arr, int k){
        Map<Integer,Integer> dictionary = new HashMap<>();
        dictionary.put(0,1);
        int count=0,sum=0;
        for(int i =0;i< arr.length;i++){
            sum+=arr[i];
            int rem = sum % k;
            if(rem<0)
                rem+=k;
            count+=dictionary.getOrDefault(rem,0);
            dictionary.put(rem,dictionary.getOrDefault(rem,0)+1);

        }
        return count;
    }
}
