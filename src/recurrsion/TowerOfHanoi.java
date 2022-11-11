package recurrsion;

public class TowerOfHanoi {
    public static void main(String[] args) {
        TowerOfHanoi t = new TowerOfHanoi();
        t.towerOfHanoii(3, "home ", "destination", "auxillary");
    }

    public void towerOfHanoii(int n, String from, String to, String aux) {
        if (n == 0) {
            return;
        }
        towerOfHanoii(n - 1, from, aux, to);
        System.out.println("move disk " + n + " from " + from + " to " + to);
        towerOfHanoii(n - 1, aux, to, from);
    }
}
