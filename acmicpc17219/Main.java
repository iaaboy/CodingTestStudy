package acmicpc17219;

import java.io.*;
import java.util.*;

/* 비밀번호 찾기
 * https://www.acmicpc.net/problem/17219
Hashmap
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap <String, String> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String site = st.nextToken();
            String password = st.nextToken();
            map.put(site, password);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(map.get(bf.readLine())).append("\n");
        }
        System.out.print(sb);
    }
}
