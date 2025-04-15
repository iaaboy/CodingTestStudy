package acmcicp15719;

import java.io.*;
import java.util.*;

/* 중복된 숫자
 * https://www.acmicpc.net/problem/15719
 */

public class Main {
    private static byte[] buffer = new byte[78888905];
    private static int next;
    private static int b;

    public static void main(String[] args) throws NumberFormatException, IOException {
        System.in.read(buffer, 0, buffer.length);
        long M = nextInt();
        long sum = 0;

        for (int i = 0; i < M; i++) {
            sum += nextInt();
        }
        System.out.println(sum - (M * (M - 1) / 2));
    }

    private static long nextInt() {
        long n = buffer[next++] - '0';
        while ((b = buffer[next++]) >= '0')
            n = (n * 10) + (b - '0');
        return n;
    }
}