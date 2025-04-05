package acmicpc32133;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

/* 가위바위보
 * https://www.acmicpc.net/problem/32133
문제 설명이 조금 어렵게 느껴짐.
P번째 라운드까지 똑같이 이긴 사람수는 
P번째 문자열까지 같은 수임.
HashMap에 각 문자열 카운트를 저장하고, 
K이하일 경우 그때까지 문자열길이와
그때까지 문자열의 반대(지는 경우) 문자를 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[][] gbb = new char[N][M];
        for (int i = 0; i < N; i++) {
            gbb[i] = bf.readLine().toCharArray();
        }
        HashMap<String, Integer> history = new HashMap<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                String key = new String(Arrays.copyOf(gbb[j], i + 1));
                // System.out.println(key);
                history.put(key, history.getOrDefault(key, 0) + 1);
            }

            // System.out.println(history);
            for (Entry<String, Integer> entrySet : history.entrySet()) {
                if (entrySet.getValue() <= K) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(entrySet.getKey().length()).append("\n");
                    for (char c : entrySet.getKey().toCharArray()) {
                        if (c == 'S') {
                            sb.append("P");
                        } else if (c == 'R') {
                            sb.append("S");
                        } else { // P
                            sb.append("R");
                        }
                    }
                    sb.append("\n");
                    System.out.print(sb);
                    return;
                }
            }
            history.clear();
        }
        System.out.println(-1);
    }
}


/*
10 10 2
RRRRRRRRRR
RRRRRRRRRR
RRRRRRRRRR
RRRRRRRRRR
RRRRRRRRRR
RRRRRRRRRR
RRRRRRRRRR
RRRRRRRRRR
RRRRRRRRRR
RRRRRRRRRP
 */