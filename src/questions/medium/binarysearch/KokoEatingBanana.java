package questions.medium.binarysearch;

public class KokoEatingBanana {
    public static void main(String[] args) {
        KokoEatingBanana kb = new KokoEatingBanana();
        //int i = kb.minEatingSpeed(new int[]{3, 6, 7, 11}, 8);
        // int i = kb.minEatingSpeed(new int[]{312884470}, 968709470);
        int i = kb.minEatingSpeed(new int[]{805306368, 805306368, 805306368}, 1000000000);
        System.out.println(i);
    }

    public int minEatingSpeed(int[] piles, int h) {
        int maxTime = 0;

        for (int i : piles) {
            maxTime = Math.max(maxTime, i);
        }

        int low = 1, high = maxTime, minTime = maxTime;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long hours = 0;
            for (int i : piles) {
                hours += Math.ceilDiv(i, mid);
            }
            if (hours <= h) {
                high = mid - 1;
                minTime = Math.min(minTime, mid);
            } else {
                low = mid + 1;
            }
        }
        return minTime;
    }
}
