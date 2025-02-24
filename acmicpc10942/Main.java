package acmicpc10942;

import java.io.*;
import java.util.*;

/* 팰린드롬?
 * https://www.acmicpc.net/problem/10942
 */

/*
1. 양끝부터 같은지 비교한다.
2. 값이 같을 경우 양끝을 하나씩 좁혀서 검사.
3. 결과가 나온 경우 memoization한다(pelin[][] 에 저장)
4. 결과가 없을 경우 직접 계산하고 메모에 저장, 있을 경우 메모를 그냥 참조
5. pelindrom검사 결과를 printout.
 */

public class Main {
    static Boolean[][] pelin;
    static int[] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        pelin = new Boolean[N][N];

        int M = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            if (checkPelin(s, e)) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }

        System.out.print(sb);
    }

    private static Boolean checkPelin(int s, int e) {
        if (pelin[s][e] != null) {
            // System.out.println(s + "," + e + " : cached");
            return pelin[s][e];
        }
        if (e - s <= 2) {
            pelin[s][e] = arr[s] == arr[e];
            return pelin[s][e];
        }
        if (arr[s] == arr[e]) {
            pelin[s][e] = checkPelin(s + 1, e - 1);
            return pelin[s][e];
        } else {
            pelin[s][e] = false;
            return pelin[s][e];
        }
    }
}