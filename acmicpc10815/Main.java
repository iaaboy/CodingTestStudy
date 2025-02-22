package acmicpc10815;

import java.io.*;
import java.util.*;

/* 숫자 카드
 * https://www.acmicpc.net/problem/10815
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        Set<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        int M = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(set.contains(Integer.parseInt(st.nextToken())) ? 1 : 0).append(" ");
        }
        System.out.println(sb);
    }
}
