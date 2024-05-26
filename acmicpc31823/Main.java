package acmicpc31823;

import java.io.*;
import java.util.*;

/* 악질 검거
 * https://www.acmicpc.net/problem/31823
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<Integer> count = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int revStric = 0;
            int max = 0;
            for (int j = 0; j <  M; j++) {
                String s = st.nextToken();
                if(s.charAt(0) == '.') {
                    revStric++;
                    max = Math.max(max, revStric);
                } else {
                    revStric = 0;
                }
            }
            count.add(max);
            String Name = st.nextToken();
            sb.append(max + " " + Name + "\n");
        }
        sb.insert(0, count.size() + "\n");
        System.out.println(sb.toString());
    }
}
