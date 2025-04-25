package acmicpc2422;

import java.io.*;
import java.util.*;

/* 한윤정이 이탈리아에 가서 아이스크림을 사먹는데 풀이
 * https://www.acmicpc.net/problem/2422
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            numSet.add(first * 1000 + second);
            numSet.add(second * 1000 + first); 
        }
        // System.out.println(numSet);
        int count = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                for (int k = j + 1; k <= N; k++) {
                    // System.out.println(i + "," + j + "," + k);
                    if (numSet.contains(i * 1000 + j) || numSet.contains(i * 1000 + k) || numSet.contains(j * 1000 + k)) {
                        continue;
                    }
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}


