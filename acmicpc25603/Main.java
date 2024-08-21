package acmicpc25603;

import java.io.*;
import java.util.*;

/* 짱해커 이동식
 * https://www.acmicpc.net/problem/25603
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] cost = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int minCost = cost[0];
        int ans = cost[0];
        int minIdx = 0;
        for (int i = s; i < s + K; i++) {
            if (cost[i] <= minCost) {
                minIdx = i;
                minCost = cost[i];
                ans = minCost;
            }
        }
        s = minIdx + 1;
        while (s + K <= N) {
            int qCount = 0;
            int i = s;
            int minWindow = 0;
            int minWindowIdx = 0;
            for (int j = i; j < N; j++) {
                if (cost[j] <= ans) {
                    s = j + 1;
                    break;
                } else {
                    qCount++;
                    if (minWindow == 0) {
                        minWindow = cost[j];
                        minWindowIdx = j;
                    } else {
                        if (cost[j] <= minWindow) {
                            minWindow = cost[j];
                            minWindowIdx = j;
                        }
                    }
                    if (qCount >= K) {
                        s = minWindowIdx + 1;
                        ans = minWindow;
                        break;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}