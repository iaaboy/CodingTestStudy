package acmicpc2568;

import java.io.*;
import java.util.*;

/*
 * 풀이중
 */

public class Main {
    static final int MAX = 500001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] cables = new int[MAX];
        int maxN = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            cables[a] = b;
            maxN = Math.max(maxN, Math.max(a, b));
        }

        int[] dp = new int[maxN + 1];
        for (int i = 1; i <= maxN; i++) {
            if (cables[i] != 0) {
                dp[i] = 1;

                // 이분탐색.
                for (int j = 1; j < i; j++) {
                    if (cables[j] != 0 && cables[j] < cables[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                        // System.out.println(i + "," + cables[i] + ":" + +dp[i]);
                    }
                }
            }
        }

        // //증가하는 수가 n
        // for (int i = 0; i <= maxN; i++) {
        // System.out.print(dp[maxN] + " ");
        // }
        // System.out.println();

        // for (int i = 1; i < dp.length; i++) {
        // System.out.print(dp[i] + " ");
        // }
        // System.out.println();

        int nextDept = 0;
        for (int dp2 : dp) {
            nextDept = Math.max(dp2, nextDept);
        }
        int x = Integer.MAX_VALUE;
        HashSet<Integer> numToKeep = new HashSet<>();
        for (int i = maxN; i >= 0; i--) {
            int curDepth = dp[i];
            if (cables[i] != 0 && nextDept == curDepth && x > i) {
                numToKeep.add(i);
                nextDept--;
                x = i;
            }
        }
        // System.out.println(numToKeep);
        StringBuilder sb = new StringBuilder();
        sb.append(N - numToKeep.size()).append("\n");
        for (int i = 0; i <= maxN; i++) {
            if (cables[i] != 0 && !numToKeep.contains(i)) {
                sb.append(i).append("\n");
            }
        }
        System.out.print(sb);
    }
}
