package acmicpc11866;

import java.io.*;
import java.util.*;

/* 요세푸스 문제 0
 * https://www.acmicpc.net/problem/11866
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> s = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            s.add(i + 1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int idx = 0;
        for (int i = 0; i < N - 1; i++) {
            idx += K - 1;
            idx %= s.size();
            sb.append(s.get(idx) + ", ");
            s.remove(idx);
        }
        sb.append(s.get(0) + ">");
        System.out.println(sb);
    }
}
