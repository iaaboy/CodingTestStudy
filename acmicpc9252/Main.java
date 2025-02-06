package acmicpc9252;

import java.io.*;
import java.util.*;

/* LCS 2
 * https://www.acmicpc.net/problem/9252
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] a = bf.readLine().toCharArray();
        char[] b = bf.readLine().toCharArray();
        int[][] dp = new int[a.length + 1][b.length + 1];

        Stack<LCSChar> stack = new Stack<>();
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    
                    // if (stack.isEmpty() || stack.peek().depth < dp[i][j]) {
                        // System.out.print(i + " " + j + " " + a[i - 1] + " " + dp[i][j] + " / ");
                        stack.add(new LCSChar(j, i, a[i - 1], dp[i][j]));
                    // }
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // for (int i = 0; i < dp.length; i++) {
        // System.out.println(Arrays.toString(dp[i]));
        // }
        int nextDept = dp[a.length][b.length];
        int y = Integer.MAX_VALUE;
        int x = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            LCSChar cur = stack.pop();
            if (nextDept == cur.depth && x > cur.x && y > cur.y) {
                sb.insert(0, cur.ch);
                nextDept--;
                x = cur.x;
                y = cur.y;
            }
        }
        System.out.println(dp[a.length][b.length]);
        if (dp[a.length][b.length] != 0) {
            System.out.println(sb);
        }
    }

    static class LCSChar {
        int y;
        int x;
        char ch;
        int depth;

        public LCSChar(int y, int x, char ch, int depth) {
            this.y = y;
            this.x = x;
            this.ch = ch;
            this.depth = depth;
        }
    }
}