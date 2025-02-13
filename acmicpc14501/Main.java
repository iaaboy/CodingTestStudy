package acmicpc14501;

import java.io.*;
import java.util.*;

/* 퇴사
 * https://www.acmicpc.net/problem/14501
 */

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] day = new int[N];
        int[] cost = new int[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            day[i] = Integer.parseInt(st.nextToken());
            cost[i] = Integer.parseInt(st.nextToken());
        }
        int[] sum = new int[N + 2];
        for (int i = N - 1; i >= 0; i--) {
            int nextIdx = i + day[i];
            if (nextIdx > N) {
                sum[i] = sum[i + 1];
                continue;
            }
            sum[i] = Math.max(sum[i + 1], cost[i] + sum[nextIdx]);
            // System.out.println(i + "," + nextIdx + ":" + sum[i]);
        }
        // System.out.println(Arrays.toString(sum));
        System.out.println(sum[0]);
    }
}