package acmicpc17505;

import java.io.*;
import java.util.*;

/* 링고와 순열
 * https://www.acmicpc.net/problem/17505
 */

public class Main {
    static int[] arr;
    static int N;
    static long K;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());
        arr = new int[N];
        int idx = 0;
        for (int i = 0 ; i < N ; i++) {
            arr[idx++] = i + 1;
        }

        
        int [] switches = new int[N];
        Arrays.fill(switches, -1);
        long remainedK = K;
        for (int i = N - 1; i > 0; i--) {
            if (remainedK >= i) {
                switches[N - 1 - i] = 1;
                remainedK -= i;
            }
        }

        idx = 0;
        for (int i = 0; i < N; i++) {
            if (switches[i] == 1) {
                switches[i] = idx++;
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            if (switches[i] == -1) {
                switches[i] = idx++;
            }
        }

        for (int i = 0; i < N; i++) {
            switches[i] = N - switches[i];
        }

        System.out.println(Arrays.toString(switches).replaceAll("[\\[\\],]", ""));

        // int index = N - 1;
        // while (K > 0) {
        //     if (K >= index) {
        //         switchArr(index);
        //         K -= index;
        //     }
        //     index--;
        // }
        // System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]", ""));

        // int count = 0;
        // for (int i = 0; i < N - 1; i++) {
        //     for (int j = i + 1; j < N; j++) {
        //         if (switches[i] < switches[j]) {
        //             count++;
        //         }
        //     }
        // }
        // System.out.println(count);

    }

    private static void switchArr(int count) {
        int temp = arr[N - 1];
        int i = N - 1;
        for (; i > N - 1 - count; i--) {
            arr[i] = arr[i - 1];
        }
        arr[i] = temp;
    }
}
