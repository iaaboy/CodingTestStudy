package acmicpc32628;

import java.io.*;
import java.util.*;

/* 두 스택
 * https://www.acmicpc.net/problem/32628
 */

public class Main {
    static Stack<Integer> a = new Stack<>();
    static Stack<Integer> b = new Stack<>();
    static long sumA = 0;
    static long sumB = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            a.add(Integer.parseInt(st.nextToken()));
            sumA += a.peek();
        }
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            b.add(Integer.parseInt(st.nextToken()));
            sumB += b.peek();
        }
        for (int i = 0; i < K; i++) {
            boolean popA = true;
            if (a.isEmpty()) {
                popA = false;
            } else if (b.isEmpty()) {
                popA = true;
            } else if (sumA == sumB) {
                if (a.peek() > b.peek()) {
                    popA = true;
                } else {
                    popA = false;
                }
            } else if (sumA > sumB) {
                popA = true;
            } else {
                popA = false;
            }

            if (popA) {
                sumA -= a.peek();
                a.pop();
            } else {
                sumB -= b.peek();
                b.pop();
            }
        }

        System.out.println(Math.max(sumA, sumB));
    }
}
