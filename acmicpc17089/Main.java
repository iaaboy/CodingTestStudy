package acmicpc17089;

import java.io.*;
import java.util.*;

/* 세 친구
 * https://www.acmicpc.net/problem/17089
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean [][] relation = new boolean[N + 1][N + 1];
        int [] friendCount = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            relation[from][to] = true;
            relation[to][from] = true;
            friendCount[from]++;
            friendCount[to]++;
        }
        int minFriend = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (!relation[i][j]) {
                    continue;
                }
                for (int k = j + 1; k <= N; k++) {
                    if (relation[i][j] && relation[j][k] && relation[i][k]) {
                        minFriend = Math.min(minFriend, friendCount[i] + friendCount[j] + friendCount[k] - 6);
                    }
                }
            }
        }
        if (minFriend == Integer.MAX_VALUE) {
            minFriend = -1;
        }
        System.out.println(minFriend);
    }
}
