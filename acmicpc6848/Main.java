package acmicpc6848;

import java.io.*;
import java.util.*;

/* Waterpark
 * https://www.acmicpc.net/problem/6848
 * DP
 */

public class Main {
    static Vector<Vector<Integer>> tree = new Vector<>();
    static long [] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        dp = new long[N + 1];
        Arrays.fill(dp, -1);

        for (int i = 0; i <= N; i++) {
            tree.add(new Vector<>());
        }
        while (true) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            if (from == 0 && to == 0) {
                break;
            }
            tree.get(to).add(from);
        }
        long routes = getRoute(N);
        System.out.println(routes);
    }

    private static long getRoute(int node) {
        if (dp[node] != -1) {
            return dp[node];
        }
        long count = 0;
        for (Integer p : tree.get(node)) {
            if (p == 1) {
                count++;
            } else {
                count += getRoute(p);
            }
        }
        // System.out.println(node + ":" + count);
        dp[node] = count;
        return count;
    }
}



