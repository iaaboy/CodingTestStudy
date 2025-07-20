package acmicpc33051;

import java.io.*;
import java.util.*;

/* 나는 이 우마를 지배할 수 있다
 * https://www.acmicpc.net/problem/33051
 * 애드혹
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] rankingCount = new int[5][5];
        int[] totalBaseScore = new int[5];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int[] rank = new int[5]; // index 순위, value 선수
            for (int j = 1; j <= 4; j++) {
                int player = Integer.parseInt(st.nextToken());
                rankingCount[player][j]++;
                rank[j] = player;
            }
            for (int j = 1; j <= 4; j++) {
                totalBaseScore[rank[j]] += Integer.parseInt(st.nextToken());
            }
        }

        // for (int i = 1; i <= 4; i++) {
        //     for (int j = 1; j <= 4; j++) {
        //         System.out.print(rankingCount[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        // System.out.println(Arrays.toString(totalBaseScore));

        boolean hasResult = false;
        loop:
        for (int u1 = 100; u1 >= -100; u1--) {
            for (int u2 = u1; u2 >= -100; u2--) {
                for (int u3 = u2; u3 >= -100; u3--) {
                    int u4 = -u1 - u2 - u3;
                    if (u4 < -100 || u4 > u3)
                        continue;
                    int[] total = new int[4];
                    Integer[] index = new Integer[4];
                    for (int i = 0; i < 4; i++) {
                        total[i] = totalBaseScore[i + 1] +
                                rankingCount[i + 1][1] * u1 +
                                rankingCount[i + 1][2] * u2 +
                                rankingCount[i + 1][3] * u3 +
                                rankingCount[i + 1][4] * u4;
                        index[i] = i;
                    }
                    Arrays.sort(index, (a, b) -> {
                        if (total[a] == total[b]) {
                            return a - b;
                        } else {
                            return total[b] - total[a];
                        }
                    });
                    if (index[M - 1] == K - 1) {
                        // System.out.println("OK");
                        // System.out.println(Arrays.toString(index));
                        // for (int i = 0; i < 4; i++) {
                        //     System.out.print(total[index[i]] + " ");
                        // }
                        // System.out.println();
                        System.out.println(u1 + " " + u2 + " " + u3 + " " + u4);
                        hasResult = true;
                        break loop;
                    }
                }
            }
        }
        if (!hasResult) {
            System.out.println(-1);
        }
    }
}
