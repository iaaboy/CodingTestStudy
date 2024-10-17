package acmicpc25628;

import java.io.*;
import java.util.*;

/* 햄버거 만들기
 * https://www.acmicpc.net/problem/25628
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        System.out.println(Math.min(N / 2, M));
    }
}