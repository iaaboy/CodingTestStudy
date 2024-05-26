package acmicpc31825;

import java.io.*;
import java.util.*;

/* 알파벳과 쿼리 (Easy)
 * https://www.acmicpc.net/problem/31825
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        char[] arr;
        StringBuilder sb = new StringBuilder();
        arr = bf.readLine().toCharArray();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(bf.readLine());
            boolean isCalc = Integer.parseInt(st.nextToken()) == 1;
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            if (isCalc) {
                sb.append(getCount(arr, start, end) + "\n");
            } else {
                replaceWord(arr, start, end);
            }
        }
        System.out.println(sb.toString());
    }

    private static void replaceWord(char[] arr, int start, int end) {
        for (int i = start; i <= end; i++) {
            arr[i]++;
            if (arr[i] > 'Z') {
                arr[i] = 'A';
            }
        }
    }

    private static int getCount(char[] arr, int start, int end) {
        char prev = '0';
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (prev != arr[i]) {
                count++;
            }
            prev = arr[i];
        }
        return count;
    }
}
