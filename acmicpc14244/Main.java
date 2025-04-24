package acmicpc14244;

import java.io.*;
import java.util.*;

/* 트리 만들기
 * https://www.acmicpc.net/problem/14244
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int leaf = 0;
        if (M == 2) {
            leaf = 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N; i++) {
            if (M > leaf) {
                sb.append(0 + " " + i).append("\n");
                leaf++;
            } else {
                sb.append((i - 1) + " " + i).append("\n");
            }
        }
        System.out.print(sb);
    }
}
