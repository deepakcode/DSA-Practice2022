package com.practice.dp.mcm;

import java.util.Arrays;
import java.util.Objects;

public class ScrambledString_p01 {

    public static void main(String[] args) {
        String s1 = "coder";
        String s2 = "ocder";
        Boolean isStringScrambled = isStringScrambled(s1, s2);
        System.out.println(isStringScrambled);
    }

    private static Boolean isStringScrambled(String s1, String s2) {
        //System.out.println("substring - " + s1.substring(i, j));
        int n = s1.length();
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() == 0)
            return true;
        if (isAnagram(s1, s2))
            return true;

        for (int k = 0; k < n; k++) {
            if (isStringScrambled(s1.substring(0, k), s2.substring(0, k)) &&
                    isStringScrambled(s1.substring(k, n), s2.substring(k, n)))
                return true;

            if (isStringScrambled(s1.substring(n - k, n),s2.substring(0, k)) &&
                    isStringScrambled(s1.substring(0, n - k),s1.substring(k, n))) {
                return true;
            }
        }

        //n=0-4//5
        //0,1,2 | 3 4
        //0,1,2 | 3 4
        //=2//3
        return false;//TODO
    }

    private static boolean isAnagram(String s1, String s2) {
        char[] s1arr = s1.toCharArray();
        char[] s2arr = s2.toCharArray();
        Arrays.sort(s1arr);
        Arrays.sort(s2arr);
        return Objects.equals(Arrays.toString(s1arr), Arrays.toString(s2arr));
    }
}
