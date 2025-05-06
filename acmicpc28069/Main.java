package acmicpc28069;

import java.io.*;
import java.util.*;

/* 김밥천국의 계단
 * https://www.acmicpc.net/problem/28069
1부터 N까지 최소 회수로 진행하는 dp를 업데이트
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int INF = Integer.MAX_VALUE;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] dp = new int[N + 1];
        Arrays.fill(dp, INF);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        dp[0] = 0;
        boolean canReach = false;
        while (!q.isEmpty()) {
            Integer c = q.poll();
            int nextCount = dp[c] + 1;
            if (nextCount <= M && (c + 1 <= N) && nextCount < dp[c + 1]) {
                dp[c + 1] = nextCount;
                if (c + 1 == N) {
                    canReach = true;
                    break;
                }
                q.add(c + 1);
            }

            if (nextCount <= M && (c + c / 2 <= N) && nextCount < dp[c + c / 2]) {
                dp[c + c / 2] = nextCount;
                if (c + c / 2 == N) {
                    canReach = true;
                    break;
                }
                q.add(c + c / 2);
            }
        }
        // System.out.println(Arrays.toString(dp));
        System.out.println(canReach ? "minigimbob" : "water");
    }
}
