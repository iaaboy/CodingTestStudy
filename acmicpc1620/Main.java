package acmicpc1620;

import java.io.*;
import java.util.*;

/* 나는야 포켓몬 마스터 이다솜
 * https://www.acmicpc.net/problem/1620
 */

/*
1. 이름 / ID 로 HashMap을 만든다.
2. ID로 이름 찾는 배열을 만든다.
3. 입력받은 값이 숫자면 배열에서 이름을 찾아 출력.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> pocketMonMap = new HashMap<>();
        String[] idMap = new String[N + 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            String pocketMon = bf.readLine();
            idMap[i] = pocketMon;
            pocketMonMap.put(pocketMon, i);
        }
        for (int i = 0; i < M; i++) {
            String q = bf.readLine();
            if (q.charAt(0) >= '0' && q.charAt(0) <= '9') {
                sb.append(idMap[Integer.parseInt(q)]).append("\n");
            } else {
                sb.append(pocketMonMap.get(q)).append("\n");
            }
        }
        System.out.print(sb);
    }
}
