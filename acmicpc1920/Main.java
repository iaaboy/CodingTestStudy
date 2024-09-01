package acmicpc1920;

import java.io.*;
import java.util.*;

/* 수 찾기
 * https://www.acmicpc.net/problem/1920
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if (findNum(arr, Integer.parseInt(st.nextToken()))) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }
        System.out.println(sb);
    }

    private static boolean findNum(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int center = (left + right) / 2;
            if (arr[center] == key) {
                return true;
            }

            if (arr[center] < key) {
                left = center + 1;
            } else {
                right = center - 1;
            }
        }

        return false;
    }
}
