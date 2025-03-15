package acmicpc2108;

import java.io.*;
import java.util.*;

/* 통계학
 * https://www.acmicpc.net/problem/2108
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Integer arr[] = new Integer[N];
        double sum = 0f;
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Integer[] count = new Integer[8004]; // -4000 ~ 4000
        Integer[] cIdx = new Integer[8004];
        for (int i = 0; i < 8004; i++) {
            cIdx[i] = i;
            count[i] = 0;
        }
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
            sum += arr[i];
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
            count[arr[i] + 4000]++;
        }
        Arrays.sort(arr);
        Arrays.sort(cIdx, (a, b) -> {
            if (count[b] == count[a]) {
                return a - b;
            }
            return count[b] - count[a];
        });
        int i = 0;
        for (; i < count.length; i++) {
            if (count[cIdx[i]] == 0) {
                i--;
                break;
            }
        }

        
        sum = Math.round(sum / (double)N);
        System.out.println((long)sum);
        System.out.println(arr[N / 2]);
        if (N != 1 && count[cIdx[0]] == count[cIdx[1]]) {
            System.out.println(cIdx[1] - 4000);
        } else {
            System.out.println(cIdx[0] - 4000);
        }
        System.out.println(max - min);
    }
}
