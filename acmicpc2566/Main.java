package acmicpc2566;

import java.io.*;
import java.util.*;

/* 최댓값
 * https://www.acmicpc.net/problem/2566
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int y = 0;
        int x = 0;
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 9; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num > max) {
                    max = num;
                    y = i;
                    x = j;
                }
            }
        }
        System.out.println(max);
        System.out.println(++y + " " + ++x);
    }
}
