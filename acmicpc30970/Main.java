package acmicpc30970;

import java.util.*;
import java.io.*;

/* 선택의 기로
 * https://www.acmicpc.net/problem/30970
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int q[] = new int[N];
        int p[] = new int[N];
        Integer idx[] = new Integer[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            q[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            idx[i] = i;
        }
        // 품질이 가장 높은 촉석루 미니어처를 골라 가져온다. 만약 그런 미니어처가 여러 개라면 가격이 가장 낮은 것을 골라 가져온다.
        Arrays.sort(idx, (a, b) -> {
            if (q[b] == q[a]) {
                return p[a] - p[b];
            }
            return q[b] - q[a];
        });
        StringBuilder sb = new StringBuilder();
        sb.append(q[idx[0]] + " " + p[idx[0]]);
        sb.append(" " + q[idx[1]] + " " + p[idx[1]]);
        for (int i = 0; i < N; i++) {
            idx[i] = i;
        }
        // 가격이 가장 낮은 촉석루 미니어처를 골라 가져온다. 만약 그런 미니어처가 여러 개라면 품질이 가장 높은 것을 골라 가져온다.
        Arrays.sort(idx, (a, b) -> {
            if (p[b] == p[a]) {
                return q[b] - q[a];
            } else {
                return p[a] - p[b];
            }
        });
        sb.append("\n" + q[idx[0]] + " " + p[idx[0]]);
        sb.append(" " + q[idx[1]] + " " + p[idx[1]]);
        // System.out.println("second" + Arrays.toString(idx));
        System.out.println(sb);
    }
}