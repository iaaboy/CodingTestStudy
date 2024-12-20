package acmicpc25374;

import java.io.*;
import java.util.*;

/* 등급 계산하기
 * https://www.acmicpc.net/problem/25374
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Integer[] arr = new Integer[N];
        int[] percent = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, Collections.reverseOrder());
        int r = 0;
        int cnt = 1;
        for (int i = 1; i < N; i++) {
            if (arr[i] != arr[i - 1]) {
                r = cnt;
                percent[i] = r;
                cnt++;
            } else {
                percent[i] = r;
                cnt++;
            }
        }

        // System.out.println(Arrays.toString(arr));
        // System.out.println(Arrays.toString(percent));
        int[] area = { 0, 4, 11, 23, 40, 60, 77, 89, 96, 110 };
        int[] count = new int[area.length - 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < area.length - 1; j++) {
                if (area[j] <= percent[i] && percent[i] < area[j + 1]) {
                    count[j]++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count.length; i++) {
            sb.append(count[i]).append("\n");
        }
        System.out.println(sb);
    }
}

/*
 * tc
 * 100
 * 1 2 2 2 2 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29
 * 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55
 * 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81
 * 82 83 84 85 86 87 88 89 90 91 92 93 90 90 90 90 90 90 90
 * 
 */
