package acmicpc3980;

import java.io.*;
import java.util.*;

/* 선발 명단
 * https://www.acmicpc.net/problem/3980
 */

public class Main {
    static int N = 11;
    static int[][] playerAbility;
    static int maxAbility = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < C; i++) {
            maxAbility = 0;
            playerAbility = new int[N][N];
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for (int k = 0; k < N; k++) {
                    playerAbility[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            int[] idx = new int[N];
            for (int j = 0; j < N; j++) {
                idx[j] = j;
            }
            permutation(idx, 0, N, N);
            sb.append(maxAbility).append("\n");
        }
        System.out.print(sb);
    }

    static void permutation(int[] pIdx, int depth, int n, int r) {
        if (depth == r) {

            int subTotal = 0;
            for (int i = 0; i < pIdx.length; i++) {
                subTotal += playerAbility[i][pIdx[i]];
            }
            if (subTotal > maxAbility) {
                maxAbility = subTotal;
            }
            // System.out.println(subTotal + ": " + Arrays.toString(pIdx));
            // for (int i = 0; i < pIdx.length; i++) {
            // System.out.print(playerAbility[i][pIdx[i]] + " ");
            // }
            // System.out.println();
            return;
        }

        for (int i = depth; i < n; i++) {
            if (playerAbility[depth][pIdx[i]] != 0) {
                swap(pIdx, depth, i);

                permutation(pIdx, depth + 1, n, r);

                swap(pIdx, depth, i);
            }
        }
    }

    static void swap(int[] pIdx, int depth, int i) {
        int temp = pIdx[depth];
        pIdx[depth] = pIdx[i];
        pIdx[i] = temp;
    }
}
