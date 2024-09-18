package acmicpc2346;

import java.io.*;
import java.util.*;

/* 풍선 터뜨리기
 * https://www.acmicpc.net/problem/2346
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Deque<Number> dq = new ArrayDeque<>();
        // Deque<Number> dq = new LinkedList<>(); //LinkedList 는 속도 및 메모리 효율 떨어짐.
        // 이 문제에서 LinkedList를 쓸 경우 메모리 초과 !!!
        for (int i = 0; i < N; i++) {
            dq.add(new Number(Integer.parseInt(st.nextToken()), i + 1));
        }
        StringBuilder sb = new StringBuilder();
        while (dq.size() > 1) {
            Number n = dq.pollFirst();
            sb.append(n.idx + " ");
            if (n.num > 0) {
                for (int i = 1; i < n.num; i++) {
                    dq.addLast(dq.pollFirst());
                }
            } else {
                for (int i = 0; i < Math.abs(n.num); i++) {
                    dq.addFirst(dq.pollLast());
                }
            }
        }
        sb.append(dq.poll().idx);
        System.out.println(sb);
    }

    static class Number {
        int num;
        int idx;

        public Number(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }
}
