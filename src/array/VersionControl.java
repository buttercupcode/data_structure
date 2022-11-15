package array;

public class VersionControl {
    public int[] versionArr = new int[]{0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1};

    public static void main(String[] args) {
        VersionControl v = new VersionControl();
        v.firstBadVersion(v.versionArr.length - 1);
    }

    public int firstBadVersion(int n) {
        int low = 1, high = n, version = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            boolean badVersion = isBadVersion(mid);
            if (!badVersion) {
                if (mid < n && isBadVersion(mid + 1))
                    return mid + 1;
                else
                    low = mid + 1;
            } else {
                high = mid;
                version = mid;
            }
        }
        return version;
    }

    private boolean isBadVersion(int version) {
        if (version > versionArr.length)
            throw new RuntimeException("increase version array");
        if (version <= 0)
            throw new RuntimeException("invalid version number");
        return versionArr[version - 1] != 0;
    }


}
