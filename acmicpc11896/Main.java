package acmicpc11896;

import java.io.*;
import java.util.*;

/* 다각형
 * https://www.acmicpc.net/problem/11896
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long sum = 0;
        for (int i = N; i <= M; i++) {
            if (i > 3 && i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}