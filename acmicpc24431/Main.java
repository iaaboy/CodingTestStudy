package acmicpc24431;

import java.io.*;
import java.util.*;

/* 유사 라임 게임
 * https://www.acmicpc.net/problem/24431
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int F = Integer.parseInt(st.nextToken());
            HashMap <String, Integer> wordMap = new HashMap<>();
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                String word = st.nextToken().substring(L - F, L);
                wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
            }
            int sum = 0;
            for (Integer values : wordMap.values()) {
                sum += values / 2;
            }
            answer.append(sum).append("\n");
        }
        System.out.print(answer);
    }
}
