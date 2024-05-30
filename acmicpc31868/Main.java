package acmicpc31868;

import java.io.*;
import java.util.*;

/* 수박 게임
 * https://www.acmicpc.net/problem/31868
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        double num = Math.pow(2, N - 1);
        int result = K / (int) num;
        System.out.println(result);
    }
}
