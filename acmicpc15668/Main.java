package acmicpc15668;

import java.io.*;
import java.util.*;

/* 방 번호
 * https://www.acmicpc.net/problem/15668
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int MAX = Math.min (87655, N);
        for (int i = 1; i < MAX; i++) {
            if (isUnique(i, N - i)) {
                System.out.println(i + " + " + (N - i));
                return;
            };
        }
        System.out.println(-1);
    }

    static boolean [] nums = new boolean[10];
    private static boolean isUnique(int a, int b) {
        Arrays.fill(nums, false);
        while (a > 0) {
            int lastDigit = a % 10;
            if (!nums[lastDigit]) {
                nums[lastDigit] = true;
            } else {
                return false;
            }
            a /= 10;
        }
        while (b > 0) {
            int lastDigit = b % 10;
            if (!nums[lastDigit]) {
                nums[lastDigit] = true;
            } else {
                return false;
            }
            b /= 10;
        }
        return true;
    }
}
