package acmicpc1475;

import java.io.*;
import java.util.Arrays;

/* 방 번호
 * https://www.acmicpc.net/problem/1475
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] inStr = bf.readLine().toCharArray();
        int[] arr = new int[11];
        for (char c : inStr) {
            int num = c - '0';
            if (num == 9) {
                num = 6;
            }
            arr[num]++;
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 6) {
                max = Math.max(max, arr[i] / 2 + arr[i] % 2);
            } else {
                max = Math.max(max, arr[i]);
            }
        }
        // System.out.println(Arrays.toString(arr));
        System.out.println(max);
    }
}
