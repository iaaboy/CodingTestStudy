package acmicpc33755;

import java.io.*;
import java.util.*;

/* 물류 작업 최적화
 * https://www.acmicpc.net/problem/33755
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        int[] l = new int[N];
        int[] r = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                if (arr[i] > 0)
                    l[i] = arr[i];
            } else {
                l[i] = arr[i];
                if (l[i - 1] > 0) {
                    l[i] += l[i - 1];
                }
            }
            ;
            if (l[i] < 0) {
                l[i] = 0;
            }
        }
        for (int i = N - 1; i >= 0; i--) {
            if (N - 1 == i) {
                if (arr[i] > 0) {
                    r[i] = arr[i];
                }
            } else {
                r[i] = arr[i];
                if (r[i + 1] > 0) {
                    r[i] += r[i + 1];
                }
            }
            if (r[i] < 0) {
                r[i] = 0;
            }
        }
        for (int i = 0; i < N; i++) {
            if (i != 0 && l[i - 1] > 0) {
                arr[i] += l[i - 1];
            }
            if (i != N - 1 && r[i + 1] > 0) {
                arr[i] += r[i + 1];
            }
        }
        // System.out.println("l: " + Arrays.toString(l));
        // System.out.println("r: " + Arrays.toString(r));
        StringBuilder sb = new StringBuilder();
        for (int n : arr) {
            sb.append(n).append(" ");
        }
        System.out.println(sb);
    }
}