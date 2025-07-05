package acmicpc11868;

import java.io.*;
import java.util.*;

/* 님 게임 2
 * https://www.acmicpc.net/problem/11868
 * 게임이론, 스프라디 그란디 정리
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long xOrSum = Long.parseLong(st.nextToken());
        for (int i = 1; i < N; i++) {
            xOrSum ^= Long.parseLong(st.nextToken());
        }
        System.out.println(xOrSum == 0 ? "cubelover" : "koosaga");
    }
}
