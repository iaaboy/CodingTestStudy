package acmicpc1535;

import java.io.*;
import java.util.*;

/* 안녕
 * https://www.acmicpc.net/problem/1535
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] health = new int[N];
        int[] joy = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            health[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            joy[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int[][] spent = new int[N][101];
        for (int i = 0; i < N; i++) {
            Arrays.fill(spent[i], -1);
            spent[i][0] = 0;
        }
        if (health[0] < 100) {
            spent[0][health[0]] = joy[0];
            max = Math.max(spent[0][health[0]], max);
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 100; j++) {
                if (j - health[i] >= 0 && spent[i - 1][j - health[i]] != -1) {
                    spent[i][j] = Math.max(spent[i - 1][j], spent[i - 1][j - health[i]] + joy[i]);
                    max = Math.max(spent[i][j], max);
                } else if (spent[i - 1][j] >= 0) {
                    spent[i][j] = spent[i - 1][j];
                    max = Math.max(spent[i][j], max);
                }
            }
        }

        // for (int i = 0; i < N; i++) {
        // System.out.println(Arrays.toString(spent[i]));
        // }

        System.out.println(max);
    }
}
