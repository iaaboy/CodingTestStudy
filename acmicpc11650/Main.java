package acmicpc11650;

import java.util.*;
import java.io.*;

/* 좌표 정렬하기
 * https://www.acmicpc.net/problem/11650
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Integer[][] arr = new Integer[N][2];
        Integer idx[] = new Integer[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // x
            arr[i][1] = Integer.parseInt(st.nextToken()); // y
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> {
            if (arr[a][0] > arr[b][0]) {
                return 1;
            } else if (arr[a][0] < arr[b][0]) {
                return -1;
            } else {
                return arr[a][1] - arr[b][1];
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[idx[i]][0] + " " + arr[idx[i]][1] + "\n");
        }
        System.out.print(sb);
    }
}
