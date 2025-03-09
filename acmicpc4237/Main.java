package acmicpc4237;

import java.io.*;
import java.util.*;

/* 비 단조성
 * https://www.acmicpc.net/problem/4237
A1 > A2 < A3 > A4 ...
값이 올랐다. 값이 내렸다 .. 를 반복하는 회수를 구하면 된다 (adHoc)
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] arr = new int[N + 1];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            boolean direction = true; // true. up // false. down
            int tweakCount = 0;
            for (int i = 1; i < N; i++) {
                if (direction) {
                    if (arr[i] < arr[i - 1]) { // 내려가면 tweak
                        tweakCount++;
                        direction = !direction;
                    }
                } else {
                    if (arr[i] > arr[i - 1]) { // 내려가면 tweak
                        tweakCount++;
                        direction = !direction;
                    }
                }
            }
            sb.append(tweakCount + 1).append("\n");
        }
        System.out.print(sb);
    }
}
