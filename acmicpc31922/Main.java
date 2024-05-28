package acmicpc31922;

import java.io.*;
import java.util.*;

/* 이 대회는 이제 제 겁니다
 * https://www.acmicpc.net/problem/31922
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int A = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int result = A + P > C ? A + P : C;

        System.out.println(result);
    }
}
