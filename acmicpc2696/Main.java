package acmicpc2696;

import java.io.*;
import java.util.*;

/* 중앙값 구하기
 * https://www.acmicpc.net/problem/2696
중앙기준으로 좌측, 우측을 pq로 구성.
값이 들어왔을때 가운데 값을 계속 관리하면서 중앙값을 print.
 */

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int M = sc.nextInt();
            PriorityQueue<Integer> pqL = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> pqR = new PriorityQueue<>();
            pqL.add(Integer.MIN_VALUE);
            pqR.add(Integer.MAX_VALUE);
            int count = 0;
            sb.append(M/2+1 + "\n");
            for (int i = 0; i < M; i++) {
                int num = sc.nextInt();
                // L R 사이값이면 우측
                if (num > pqL.peek() && num < pqR.peek()) {
                    pqR.add(num);
                } else if (num <= pqL.peek()) { // L 보다 작으면
                    pqL.add(num);
                    pqR.add(pqL.poll()); 
                } else if (num >= pqR.peek()) { // R 보다 크면
                    pqR.add(num);
                    pqL.add(pqR.poll());
                } else {
                    pqR.add(num);
                }

                if (pqL.size() > pqR.size()) {
                    pqR.add(pqL.poll());
                } else if (pqL.size() + 1 < pqR.size()) {
                    pqL.add(pqR.poll());
                }

                if (i % 2 == 0) {
                    count++;
                    if (pqL.size() > pqR.size()) {
                        sb.append(pqL.peek());
                    } else {
                        sb.append(pqR.peek());
                    }
                    if (count % 10 == 0) {
                        sb.append("\n");
                    } else {
                        sb.append(" ");
                    }
                    count++;
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
        sc.close();
    }
}