package leetcode.string;

public class IndexFirstStringOcc28 {
    public static void main(String[] args) {
        IndexFirstStringOcc28 idx = new IndexFirstStringOcc28();
        int out = idx.strStr("sad", "sad");
        System.out.println(out);
        out = idx.strStr("sadbutsad", "sad");
        System.out.println(out);
        out = idx.strStr("a", "a");
        System.out.println(out);
        out = idx.strStr("leetcode", "leeto");
        System.out.println(out);
    }

    public int strStr(String haystack, String needle) {

        int hayLen = haystack.length();
        int needleLen = needle.length();

        for (int i = 0; ; i++) {

            for (int j = 0; ; j++) {
                if (i + j >= hayLen)
                    return -1;
                if (needle.charAt(j) != haystack.charAt(i + j))
                    break;
                if (j == needleLen - 1)
                    return i;

            }
        }

    }

    public int strStrUsingRabinKarp(String haystack, String needle) {
        int m = needle.length();
        int n = haystack.length();
        if(n<m) return -1;
        int RADIX=26;
        int MOD = 1000000033;//where MOD is a large prime number.
        long MAX_WEIGHT = 1;
        for(int i =0;i<n;i++)
            MAX_WEIGHT=(MAX_WEIGHT*RADIX)%MOD;
        long hashNeedle = hashValue(needle, RADIX, MOD, m), hashHay = 0;
        for (int windowStart = 0; windowStart <= n - m; windowStart++){
            if (windowStart == 0) {
                // Compute hash of the First Substring
                hashHay = hashValue(haystack, RADIX, MOD, m);
            }else{
                hashHay = (((hashHay * RADIX) % MOD) -
                        (((int) (haystack.charAt(windowStart - 1) - 'a') *
                                MAX_WEIGHT) %
                                MOD) +
                        (int) (haystack.charAt(windowStart + m - 1) - 'a') +
                        MOD) %
                        MOD;
            }
            if (hashNeedle == hashHay) {
                for (int i = 0; i < m; i++) {
                    if (needle.charAt(i) != haystack.charAt(i + windowStart)) {
                        break;
                    }
                    if (i == m - 1) {
                        return windowStart;
                    }
                }
            }
        }
        return -1;
    }
    public int hashValue(String string, int RADIX, int MOD, int m) {
        long ans = 0;
        long factor = 1;
        for (int i = m - 1; i >= 0; i--) {
            ans = (ans + (string.charAt(i) - 'a') * factor) % MOD;
            factor = (factor * RADIX) % MOD;
        }
        return (int) ans;
    }
}


