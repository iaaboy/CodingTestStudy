package acmicpc24060;

import java.io.*;
import java.util.*;

/* 알고리즘 수업 - 병합 정렬 1
 * https://www.acmicpc.net/problem/24060
병합정렬의 pseudo를 그대로 구현하고, 
조건에 맞게 K번째 수를 print한다.
 */

public class Main {
    static int K;
    static int kSaved = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        merge_sort(arr, 0, arr.length - 1);
        // System.out.println(Arrays.toString(arr));
        System.out.println(kSaved);
    }

    static void merge_sort(int[] arr, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            merge_sort(arr, p, q);
            merge_sort(arr, q + 1, r);
            merge(arr, p, q, r);
        }
    }

    static void merge(int[] arr, int p, int q, int r) {
        int i = p, j = q + 1, t = 0;
        int[] temp = new int[r - p + 1];
        while (i <= q && j <= r) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }

        while (i <= q) {
            temp[t++] = arr[i++];
        }
        while (j <= r) {
            temp[t++] = arr[j++];
        }
        i = p;
        t = 0;
        while (i <= r) {
            K--;
            if (K == 0) {
                kSaved = temp[t];
            }
            arr[i++] = temp[t++];
        }
    }
}
