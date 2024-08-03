package acmicpc12968;

import java.io.*;
import java.util.*;

/* 방문
 * https://www.acmicpc.net/problem/12968
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 짝수칸이면 항상 가능
        // 홀수칸이면 1일때만 가능

        if ((r * c) % 2 == 1 && (k != 1)) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }
}
