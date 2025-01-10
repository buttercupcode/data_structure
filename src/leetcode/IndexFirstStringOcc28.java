package leetcode;

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
}


