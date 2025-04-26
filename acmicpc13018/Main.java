package acmicpc13018;

import java.io.*;
import java.util.*;

/* 특이한 수열
 * https://www.acmicpc.net/problem/13018
해 구성하기
gcd(n, n + 1) = 1
gcd(n,n) = n
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        if (N == K) {
            sb.append("Impossible");
        } else if (N == K + 1) {
            for (int i = 1; i <= N; i++) {
                sb.append(i + " ");
            }
        } else {
            sb.append((K + 2) + " ");
            for (int i = 2; i <= K + 1; i++) {
                sb.append(i + " ");
            }
            for (int i = K + 2; i <= N; i++) {
                sb.append((i < N ? i + 1 : 1) + " ");
            }
        }
        System.out.println(sb);
    }
}
