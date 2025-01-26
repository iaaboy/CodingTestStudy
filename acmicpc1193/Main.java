package acmicpc1193;

import java.io.*;

/* 분수찾기
 * https://www.acmicpc.net/problem/1193
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(bf.readLine());

        int i = 1;
        for (; i < Integer.MAX_VALUE; i++) {
            x -= i;
            if (x <= 0) {
                x += i;
                break;
            }
        }

        // System.out.println(i + "," + sum + "," + x);
        if (i % 2 == 0)
            System.out.println((1 + x - 1) + "/" + (i - x + 1));
        else {
            System.out.println((i - x + 1) + "/" + (1 + x - 1));
        }
    }
}
