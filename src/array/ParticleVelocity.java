package array;

public class ParticleVelocity {
    public static void main(String[] args) {
        ParticleVelocity pv = new ParticleVelocity();
        System.out.println(pv.particleVelocity(new int[]{1, 3, 5, 7, 9}));
    }

    public int particleVelocity(int[] velocities) {
        if (velocities.length <= 2)
            return -1;
        int[] diff = new int[velocities.length];
        int total = 0;

        for (int i = 0; i < velocities.length - 2; i++) {
            int count = 0;
            for (; i + 2 < velocities.length && (velocities[i + 2] - velocities[i + 1]) == (velocities[i + 1] - velocities[i]); i++) {
                count++;
                total += count;
            }
        }
        return total;
    }
}
