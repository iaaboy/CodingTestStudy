package acmicpc15702;

import java.io.*;
import java.util.*;

/* 중간고사 채점
 * https://www.acmicpc.net/problem/15702
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] score = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }
        int[] subTotal = new int[M];
        int[] idNum = new int[M];
        Integer[] index = new Integer[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            idNum[i] = Integer.parseInt(st.nextToken());
            index[i] = i;
            for (int j = 0; j < N; j++) {
                if (st.nextToken().charAt(0) == 'O') {
                    subTotal[i] += score[j];
                }
            }
        }

        // System.out.println(Arrays.toString(index));
        // System.out.println(Arrays.toString(subTotal));

        Arrays.sort(index, (a, b) -> {
            if (subTotal[a] == subTotal[b]) {
                return idNum[a] - idNum[b];
            } else {
                return subTotal[b] - subTotal[a];
            }
        });
        System.out.println(idNum[index[0]] + " " + subTotal[index[0]]);
    }
}
