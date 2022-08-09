package com.practice.dp.mcm;

/**
 * Example 1:
 * <p>
 * Input: str = "ababbbabbababa"
 * Output: 3
 * Explaination: After 3 partitioning substrings
 * are "a", "babbbab", "b", "ababa".
 * Example 2:
 * <p>
 * Input: str = "aaabba"
 * Output: 1
 * Explaination: The substrings after 1
 * partitioning are "aa" and "abba".
 */
public class PalindromicPartitioning {

    public static void main(String[] args) {
        char[] str = "wnitin".toCharArray();
        int count = ppCount(str, 0, str.length - 1);
        System.out.println(count);
    }

    private static int ppCount(char[] str, int i, int j) {
        if ((i >=j) || isPalindrome(str, i, j)) {
            return 0;
        }

        int min = Integer.MAX_VALUE - 1;

        for (int k = i; k <j; k++) {
            int tempResult = 1 + ppCount(str, i, k) + ppCount(str, k+1, j);
            min = Math.min(tempResult, min);
        }
        return min;
    }

    private static boolean isPalindrome(char[] str, int x, int y) {
        while (x <= y) {
            if (str[x] != str[y]) {
                return false;
            }
            x++;
            y--;
        }
        return true;
    }
}
