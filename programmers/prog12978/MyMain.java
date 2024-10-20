package prog12978;

import java.util.Arrays;

/* 배달
 * https://school.programmers.co.kr/learn/courses/30/lessons/12978
 */

public class MyMain {
    public static void main(String[] args) {
        int[] k = { 3, 4 };
        int[][][] roads = {
                { { 1, 2, 1 }, { 2, 3, 3 }, { 5, 2, 2 }, { 1, 4, 2 }, { 5, 3, 1 }, { 5, 4, 2 } },
                { { 1, 2, 1 }, { 1, 3, 2 }, { 2, 3, 2 }, { 3, 4, 3 }, { 3, 5, 2 }, { 3, 5, 3 }, { 5, 6, 1 } }
        };
        int[] n = { 5, 6 };
        Solution mSol = new Solution();
        for (int i = 0; i < n.length; i++) {
            System.out.println("answer:" + mSol.solution(n[i], roads[i], k[i]));
        }
    }
}

class Solution {
    public int solution(int N, int[][] road, int K) {
        int INF = 100000000;
        N++;
        int[][] distance = new int[N][N];
        for (int i = 0; i < distance.length; i++) {
            Arrays.fill(distance[i], INF);
        }

        for (int i = 0; i < road.length; i++) {
            distance[road[i][0]][road[i][1]] = Math.min(road[i][2], distance[road[i][0]][road[i][1]]);
            distance[road[i][1]][road[i][0]] = Math.min(road[i][2], distance[road[i][1]][road[i][0]]);
        }

        for (int k = 1; k < N; k++) {
            for (int i = 1; i < N; i++) {
                for (int j = 1; j < N; j++) {
                    if (i == j)
                        continue;
                    if (distance[j][i] > distance[i][k] + distance[k][j]) {
                        distance[j][i] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }

        // for (int i = 1; i < distance.length; i++) {
        // System.out.print(i + ": ");
        // for (int j = 1; j < distance.length; j++) {
        // System.out.print((distance[j][i] == INF ? "0" : distance[j][i]) + ",");
        // }
        // System.out.println();
        // }

        int count = 0;
        for (int i = 0; i < distance[1].length; i++) {
            if (distance[1][i] <= K) {
                count++;
            }
        }

        return count + 1;
    }
}