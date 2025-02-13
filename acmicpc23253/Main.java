package acmicpc23253;

import java.io.*;
import java.util.*;

/* 자료구조는 정말 최고야
 * https://www.acmicpc.net/problem/23253
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        boolean result = true;
        for (int i = 0; i < M; i++) {
            int K = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine());
            int prev = Integer.MAX_VALUE;
            for (int j = 0; j < K; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (prev <= num) {
                    result = false;
                }
                prev = num;
            }
        }

        if (result) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
