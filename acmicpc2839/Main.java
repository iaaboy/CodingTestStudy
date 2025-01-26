package acmicpc2839;

import java.util.Scanner;

/* 설탕 배달
 * https://www.acmicpc.net/problem/2839
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int n = scanner.nextInt();
            int max5 = n / 5;
            for (int i = max5; i >= 0; i--) {
                int remain = n - i * 5;
                if (remain % 3 == 0) {
                    System.out.println(i + remain / 3);
                    return;
                }
            }
            System.out.println(-1);
        } finally {
            scanner.close();
        }
    }
}
