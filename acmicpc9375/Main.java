package acmicpc9375;

import java.io.*;
import java.util.*;

/* 패션왕 신해빈
 * https://www.acmicpc.net/problem/9375
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(bf.readLine());
            HashMap < String, Integer> map = new HashMap<>();
            if (N == 0) {
                sb.append(0).append("\n");
                continue;
            }
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(bf.readLine());
                String name = st.nextToken();
                String type = st.nextToken();
                map.put(type, map.getOrDefault(type, 0) + 1);
            }
            int Sum = 1;
            for (Integer n : map.values()) {
                Sum *= (n + 1);
            }
            sb.append(Sum - 1).append("\n");
        }
        System.out.print(sb);
    }
}
