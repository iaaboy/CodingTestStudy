package acmicpc32201;

import java.io.*;
import java.util.*;

/* 눈사람
 * https://www.acmicpc.net/problem/32201
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        Integer arrBefore[] = new Integer[N];
        Integer idxBefore[] = new Integer[N];
        Integer arrAfter[] = new Integer[N];
        Integer idxAfter[] = new Integer[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arrBefore[i] = Integer.parseInt(st.nextToken());
            idxBefore[i] = i;
            idxAfter[i] = i;
        }
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arrAfter[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(idxBefore, (a, b) -> arrBefore[a] - arrBefore[b]);
        Arrays.sort(idxAfter, (a, b) -> arrAfter[a] - arrAfter[b]);

        int maxDiff = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            maxDiff = Math.max(maxDiff, idxBefore[i] - idxAfter[i]);
        }
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            if (idxBefore[i] - idxAfter[i] == maxDiff) {
                arr[idxAfter[i]] = 1;
                // System.out.println(arrAfter[idxAfter[i]] + " " + idxAfter[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (arr[i] == 1) {
                sb.append(arrAfter[i] + " ");
            }
        }
        System.out.println(sb);
    }
}
