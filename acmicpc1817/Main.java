package acmicpc1817;

import java.io.*;
import java.util.*;

/* 짐 챙기는 숌
 * https://www.acmicpc.net/problem/1817
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (N > 0) {
            st = new StringTokenizer(bf.readLine());
        }
        int amount = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            int box = Integer.parseInt(st.nextToken());
            amount += box;
            if (amount > M) {
                count++;
                amount = box;
            } else if (amount == M) {
                count++;
                amount = 0;
            }
        }
        if (amount > 0) {
            count++;
        }
        System.out.println(count);
    }
}
