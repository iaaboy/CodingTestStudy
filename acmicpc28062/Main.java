package acmicpc28062;

import java.io.*;
import java.util.*;

/* 준석이의 사탕 사기
 * https://www.acmicpc.net/problem/28062
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int minOdd = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (number % 2 != 0) {
                minOdd = Math.min(minOdd, number);
            }
            sum+=number;
        }
        if (sum % 2 != 0) {
            sum -= minOdd;
        }
        System.out.println(sum);
    }
}
