package acmicpc11004;

import java.io.*;
import java.util.*;

/* K번째 수
 * https://www.acmicpc.net/problem/11004
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(arr, 0, N - 1, K - 1);
        System.out.println(arr[K - 1]);
    }

    private static void quickSort(int[] arr, int S, int E, int k) {
        int pivot = partition(arr, S, E);
        if (pivot == k) {
            return;
        } else if (pivot > k) {
            quickSort(arr, S, pivot - 1, k);
        } else { // pivot < k
            quickSort(arr, pivot + 1, E, k);
        }
    }

    private static int partition(int[] arr, int s, int e) {
        if (s + 1 == e) {
            if (arr[s] > arr[e]) {
                swap(arr, s, e);
            }
            return e;
        }

        int N = (s + e) / 2;
        swap(arr, s, N);
        int pivot = arr[s];
        int i = s + 1;
        int j = e;

        while (i <= j) {
            while (pivot < arr[j] && j > 0) {
                j--;
            }
            while (pivot > arr[i] && i < arr.length - 1) {
                i++;
            }

            if (i <= j) {
                swap(arr, i++, j--);
            }
        }
        arr[s] = arr[j];
        arr[j] = pivot;
        return j;
    }

    private static void swap(int[] arr, int s, int e) {
        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
    }
}
