package com.practice.dp.mcm;

import static java.lang.Math.min;

public class MCMPalindromPartitioning {

    public static void main(String[] args) {
        char[] chars = "aabaaa".toCharArray();
        int n = chars.length;

        int r = mcm(chars, 0, n - 1);

        //boolean r = isPalindrome(chars,0,n-1);
        System.out.println("Result : " + r);
    }

    private static int mcm(char[] str, int i, int j) {
        //Base condition
        if (i >j || isPalindrome(str,i,j))  {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
           /* print(str,i,k);
            print(str,k+1,j);
            System.out.println("--------------");*/
            int result = mcm(str, i, k) +
                    mcm(str, k + 1, j) +
                    1;
            min = min(result, min);
        }
        return min;
    }

    public static boolean isPalindrome(char[] chars, int i, int j)
    {
        while (i <= j)
        {
            if (chars[i++] != chars[j--]) {
                return false;
            }
        }
        return true;
    }
}
