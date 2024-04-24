package acmicpc12931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 두 배 더하기 풀이
 * https://www.acmicpc.net/problem/12931
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        boolean isAllzero = false;
        int count = 0;
        while (!isAllzero) {
            isAllzero = true;
            boolean isAllEven = true;
            // System.out.println(numbers[0] + ", " + count);
            for (int i = 0; i < n; i++) {
                if (numbers[i] % 2 == 1) {
                    isAllEven = false;
                    isAllzero = false;
                    count++;
                    numbers[i]--;
                } else {
                    if (numbers[i] != 0) {
                        isAllzero = false;
                    }
                }
            }
            if (isAllzero)
                break;
            if (isAllEven) {
                for (int i = 0; i < n; i++) {
                    numbers[i] /= 2;
                }
                count++;
            }
        }
        System.out.println(count);
        br.close();
    }
}