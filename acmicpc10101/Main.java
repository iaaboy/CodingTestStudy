package acmicpc10101;

import java.io.*;

/* 삼각형 외우기
 * https://www.acmicpc.net/problem/10101
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bf.readLine());
        int b = Integer.parseInt(bf.readLine());
        int c = Integer.parseInt(bf.readLine());

        if (a + b + c != 180) {
            System.out.println("Error");
            return;
        }

        if (a == 60 && b == 60 && c == 60) {
            System.out.println("Equilateral");
        } else if (a == b || b == c || a == c) {
            System.out.println("Isosceles");
        } else {
            System.out.println("Scalene");
        }
    }
}
