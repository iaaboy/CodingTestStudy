package acmicpc2602;

import java.io.*;
import java.util.Arrays;

/* 돌다리 건너기
 * https://www.acmicpc.net/problem/2602
 * DP
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] durumari = bf.readLine().toCharArray();
        int durumariLength = durumari.length;
        char[] bridgeEven = bf.readLine().toCharArray();
        char[] bridgeOdd = bf.readLine().toCharArray();
        int brLength = bridgeEven.length;
        int[][] dp = new int[durumariLength][brLength];
        int[][] dpReverse = new int[durumariLength][brLength];
        for (int bridge = 0; bridge < brLength; bridge++) {
            for (int duru = 0; duru < durumariLength; duru++) {
                if(bridge != 0) {
                    dp[duru][bridge] = dp[duru][bridge - 1];
                    dpReverse[duru][bridge] = dpReverse[duru][bridge - 1];
                }

                if (duru % 2 == 0) {
                    if (durumari[duru] == bridgeEven[bridge]) {
                        // System.out.println("match: " + durumari[duru] + " match with bridgeEven ");
                        if(duru != 0 && bridge != 0) {
                            dp[duru][bridge] += dp[duru - 1][bridge - 1];
                        } else if (duru == 0) {
                            dp[duru][bridge] += 1;
                        }
                    }
                } else {
                    if (durumari[duru] == bridgeOdd[bridge]) {
                        // System.out.println("match: " + durumari[duru] + " match with bridgeOdd ");
                        if(duru != 0 && bridge != 0)
                            dp[duru][bridge] += dp[duru - 1][bridge - 1];
                    }
                }

                if (duru % 2 != 0) {
                    if (durumari[duru] == bridgeEven[bridge]) {
                        // System.out.println("match: " + durumari[duru] + " match with bridgeEven ");
                        if(duru != 0 && bridge != 0)
                            dpReverse[duru][bridge] += dpReverse[duru - 1][bridge - 1];
                    }
                } else {
                    if (durumari[duru] == bridgeOdd[bridge]) {
                        // System.out.println("match: " + durumari[duru] + " match with bridgeOdd ");
                        if(duru != 0 && bridge != 0) {
                            dpReverse[duru][bridge] += dpReverse[duru - 1][bridge - 1];
                        } else if (duru == 0) {
                            dpReverse[duru][bridge] += 1;
                        }
                    }
                }
            }
        }
        // for (int i = 0; i < dp.length; i++) {
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        // for (int i = 0; i < dpReverse.length; i++) {
        //     System.out.println(Arrays.toString(dpReverse[i]));
        // }

        System.out.println(dp[durumariLength - 1][brLength - 1] + dpReverse[durumariLength - 1][brLength - 1]);
    }
}
