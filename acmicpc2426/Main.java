package acmicpc2426;

import java.io.*;
import java.util.*;

/* 주사위 게임
 * https://www.acmicpc.net/problem/2476
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int price = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int eqCount = 0;
            int eqNum = a;
            if (a == b) {
                eqNum = a;
                eqCount++;
            }
            if (b == c) {
                eqNum = b;
                eqCount++;
            }
            if (a == c) {
                eqNum = a;
                eqCount++;
            }
            if (eqCount == 3) {
                price = Math.max(price, 10000 + eqNum * 1000);
            } else if (eqCount == 1) {
                price = Math.max(price, 1000 + eqNum * 100);
            } else {
                price = Math.max(price, Math.max(c, Math.max(a, b)) * 100);
            }
        }
        System.out.println(price);
    }
}
