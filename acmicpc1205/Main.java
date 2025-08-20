package acmicpc1205;

import java.io.*;
import java.util.*;

/* 등수 구하기
 * https://www.acmicpc.net/problem/1205
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        Integer[] arr = new Integer[N + 1];
        if (N == 0) {
            System.out.println(1);
            return;
        }
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[N] = score;
        Arrays.sort(arr, (a, b) -> b - a);
        int rank = 1;
        int [] ranks = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (arr[i - 1] > arr[i]) {
                ranks[i - 1] = rank;
                rank = i + 1;
            } else {
                ranks[i - 1] = rank;
            }
        }
        ranks[N] = rank;
        for (int i = 0; i < ranks.length; i++) {
            if (arr[i] == score) {
                rank = ranks[i];
            }
        }
        if (P == N && arr[P] == score) {
            rank = -1;
        }
        // System.out.println(Arrays.toString(arr));
        // System.out.println(Arrays.toString(ranks));
        System.out.println(rank);
    }
}