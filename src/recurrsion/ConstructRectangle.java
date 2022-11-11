package recurrsion;

public class ConstructRectangle {
    public static void main(String[] args) {
        ConstructRectangle cr = new ConstructRectangle();

        int[] factors = cr.constructRectangle(9999992);
        for (int a : factors) {

            System.out.print(a + ",");
        }
    }

    public int[] constructRectangle(int area) {
        int mid = (int) Math.sqrt(area);
        int l = mid;
        int w = mid;
        while (l <= area) {
            if (l * w == area)
                break;

            else if (l * w > area)
                w--;

            else
                l++;
        }
        return new int[]{l, w};
    }
/*
            int[][] factors = new int[area/2][3];
            int count=0;
            int minDiff =area;
            int[] optArea= new int[2];
            if(area<=1){
                return new int[]{area,area};
            }
            for(int i =1;i<=area/2;i++){
                int div= area/i;
                int rem= area%i;
                if(rem==0){
                    factors[count][0]= i>=div?i:div;
                    factors[count][1]=i<=div?i:div;
                    factors[count][2]=Math.abs(i-div);
                    int localDiff=factors[count][2];
                    if(localDiff<minDiff)
                    {
                        minDiff= localDiff;
                        optArea[0]=factors[count][0];
                        optArea[1]=factors[count][1];
                    }
                    count++;
                }
            }


            return optArea;*/
}
        /*
            int[][] factors = new int[area][3];
            int count=0;
            for(int i =1;i<=area/2;i++){
                int div= area/i;
                int rem= area%i;
                if(rem==0){
                    factors[count][0]= i;
                    factors[count][1]=div;
                    factors[count][2]=i-div;
                    count++;
                }
            }
            int minDiff =area;
            int[] optArea= new int[2];
            for(int[] arr: factors){
                if(arr[2]>=0 && arr[0]>0)
                {
                    int localDiff= arr[2];
                    if(localDiff<minDiff){
                        minDiff= localDiff;
                        optArea[0]=arr[0];
                        optArea[1]=arr[1];
                    }
                }
            }
            return optArea;
        */


