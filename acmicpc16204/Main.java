package acmicpc16204;

import java.io.*;
import java.util.*;

/* 카드 뽑기
 * https://www.acmicpc.net/problem/16204
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int backO = M;
        int backX = N - M;

        int oMatch = Math.min(K, backO);
        int xMatch = Math.min(N - K, backX);
        System.out.println(oMatch + xMatch);
    }
}
