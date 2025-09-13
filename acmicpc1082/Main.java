package acmicpc1082;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

/* 방 번호
 * https://www.acmicpc.net/problem/1082
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] p = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int minExceptFirst = 0;
        for (int i = 0; i < N; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < N; i++) {
            minExceptFirst = Math.min(minExceptFirst, p[i]);
        }
        int M = Integer.parseInt(bf.readLine());
        int[][] dp = new int[M + 1][N];
        for (int i = 1; i <= M; i++) {
            BigInteger maxSum = new BigInteger("-1");
            for (int value = 0; value < N; value++) {
                int cost = p[value];
                if (i - cost >= 0) {
                    int[] comparison = dp[i - cost];
                    StringBuilder number = new StringBuilder();
                    for (int n = 0; n < comparison.length; n++) {
                        if (comparison[n] > 0) {
                            for (int j = 0; j < comparison[n]; j++) {
                                number.insert(0, n);
                            }
                        }
                        if (n == value && n != 0) {
                            number.insert(0, n);
                        }
                    }

                    BigInteger sum = new BigInteger(number.isEmpty() ? "0" : number.toString());
                    if (maxSum.compareTo(sum) < 0) {
                        // System.out.println(i + ":" + number);
                        maxSum = sum;
                        dp[i] = dp[i - cost].clone();
                        dp[i][value]++;
                        maxSum = sum;
                    }
                }
            }
            // System.out.println(i + ":" + Arrays.toString(dp[i]));
        }

        // StringBuilder debugSb = new StringBuilder();
        // for (int i = 0; i < M; i++) {
        // debugSb.append(i + " ");
        // }
        // debugSb.append("\n");
        // for (int i = 0; i < N; i++) {
        // for (int j = 0; j <= M; j++) {
        // debugSb.append(dp[j][i] + " ");
        // }
        // debugSb.append("\n");
        // }
        // System.out.println(debugSb);

        StringBuilder sb = new StringBuilder();
        for (int num = 0; num < dp[M].length; num++) {
            if (dp[M][num] > 0) {
                for (int i = 0; i < dp[M][num]; i++) {
                    sb.insert(0, num);
                }
            }
        }

        BigInteger answer = new BigInteger(sb.toString());
        if (N >= 2 && M >= minExceptFirst + p[0]) {
            int digitCount = 1;
            for (int i = 1; i < N; i++) {
                if (M >= p[0] + p[i]) {
                    int zC = (M - p[i]) / p[0];
                    if (digitCount < zC) {
                        digitCount = zC;
                    }
                }
            }
            digitCount++;
            int[] digit = new int[digitCount];
            int sum = digitCount * p[0];
            for (int i = 0; i < digit.length; i++) {
                for (int j = p.length - 1; j > 0; j--) {
                    if (M >= sum + p[j] - p[0]) {
                        digit[i] = j;
                        sum -= p[0];
                        sum += p[j];
                        break;
                    }
                }
            }
            StringBuilder sb2 = new StringBuilder();
            for (int d : digit) {
                sb2.append(d);
            }
            // System.out.println(sb2);
            BigInteger answer2 = new BigInteger(sb2.toString());
            if (answer.compareTo(answer2) < 0) {
                answer = answer2;
            }
        }

        System.out.println(answer);
    }
}
