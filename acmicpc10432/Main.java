package acmicpc10432;

import java.io.*;
import java.util.*;

/* 데이터 스트림의 섬
 * https://www.acmicpc.net/problem/10432
나보다 크면 stack에서 pop하면서 count
나와 같으면 stack에서 pop하는데 count하지 않음.
나보다 작으면 stack에 push.
마지막에 count를 출력
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int T = Integer.parseInt(st.nextToken());
            Stack<Integer> s = new Stack<>();
            int count = 0;
            for (int j = 0; j < 12; j++) {
                int me = Integer.parseInt(st.nextToken());
                while (!s.isEmpty() && s.peek() >= me) {
                    if (s.pop() > me) {
                        count++;
                    }
                }
                s.push(me);

                // System.out.println(me + " count:" + count + " s:" + s);
            }
            // System.out.println(s);
            sb.append(T).append(" ").append(count).append("\n");
        }
        System.out.println(sb);
    }
}
