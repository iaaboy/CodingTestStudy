package acmicpc11003;

import java.io.*;
import java.util.*;

/* 최솟값 찾기
 * https://www.acmicpc.net/problem/11003
 * 윈도우 내의 순서를 ArrayDeque로 관리.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        ArrayDeque<Num> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            if (dq.isEmpty())
                dq.add(new Num(Integer.parseInt(st.nextToken()), i));
            else {
                int num = Integer.parseInt(st.nextToken());
                if (dq.peek().index <= i - L) {
                    dq.poll();
                }
                while (!dq.isEmpty() && dq.peekLast().num > num) {
                    dq.pollLast();
                }
                dq.add(new Num(num, i));
            }
            sb.append(dq.peek().num).append(" ");
        }
        System.out.println(sb);
    }

    static class Num {
        int num;
        int index;

        public Num(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }
}
