package questions.medium;

import java.util.Arrays;
import java.util.Comparator;

public class CarFleet {
    public static void main(String[] args) {
    CarFleet c = new CarFleet();
        int i = c.carFleet(12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3});
        System.out.println(i);
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length, res =0;
        double[][] cars = new double[position.length][2];

        for(int i =0; i<n;i++){
             cars[i] = new double[]{position[i],(double) (target-position[i])/(double)speed[i]};
        }

        Arrays.sort(cars, Comparator.comparingDouble(a -> a[0]));
        double curr =0;
        for(int i =n-1; i>=0;i--){
            if(cars[i][1]>curr){
                curr = cars[i][1];
                res++;
            }
        }
        return res;

    }
}
