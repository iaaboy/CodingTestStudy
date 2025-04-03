package acmicpc11116;

import java.io.*;
import java.util.*;

/* 교통량
 * https://www.acmicpc.net/problem/11116
문제 이해가 어려웠음.
왼쪽 줄 위로 앞 바퀴가 지나 간 시간 t
왼쪽 줄 위로 뒷 바퀴가 지나 간 시간 t + 500
오른쪽 줄 위로 앞 바퀴가 지나 간 시간 t + 1000
오른쪽 줄 위로 뒷 바퀴가 지나 간 시간 t + 1500
각 조건을 모두 만족하는 쌍을 구하는 문제
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(bf.readLine());
            StringTokenizer st = new StringTokenizer(bf.readLine());
            Set<Integer> a = new HashSet<>();
            Set<Integer> b = new HashSet<>();
            for (int i = 0; i < N; i++) {
                a.add(Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < N; i++) {
                b.add(Integer.parseInt(st.nextToken())); 
            }
            int count = 0;
            for (Integer aNum : a) {
                if (a.contains(aNum + 500) && b.contains(aNum + 1000) && b.contains(aNum + 1500)) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}
