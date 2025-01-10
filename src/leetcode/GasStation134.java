package leetcode;

public class GasStation134 {
    public static void main(String[] args) {
        GasStation134 gas134 = new GasStation134();
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};
        int mark = gas134.canCompleteCircuitOptimized(gas, cost);
        System.out.println(mark);
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int totalFuel = 0;
            int stopCount = 0, j = i;
            while (stopCount < n) {
                totalFuel += gas[j % n] - cost[j % n];
                if (totalFuel < 0)
                    break;
                stopCount++;
                j++;
            }
            if (stopCount == n && totalFuel >= 0)
                return i;
        }
        return -1;
    }

    public int canCompleteCircuitOptimized(int[] gas, int[] cost) {
        int n = gas.length;
        int totalSurplus = 0;
        int surplus = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            totalSurplus += gas[i] - cost[i];
            surplus += gas[i] - cost[i];
            if (surplus < 0) {
                surplus = 0;
                start = i + 1;
            }

        }
        return totalSurplus < 0 ? -1 : start;
    }
}
