package acmicpc1174;

import java.io.*;
import java.util.*;

/* 줄어드는 수
 * https://www.acmicpc.net/problem/1174
 */

public class Main {
    static int cnt = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(bf.readLine());

        calcNum(-1, 0, 0);
        System.out.println(getNum(nums, N));
        // System.out.println(nums);

    }

    private static long getNum(TreeSet<Long> nums2, long n) {
        int count = 1;
        for (Long long1 : nums2) {
            if (count == n) {
                return long1;
            }
            count++;
        }
        return -1;
    }

    static TreeSet<Long> nums = new TreeSet<>();

    private static void calcNum(int prevDigit, long num, int depth) {
        if (depth == 15) {
            return;
        }
        // System.out.println(prevDigit + ", " + num + " .. " + depth);
        nums.add(num);
        long digit = (long) Math.pow(10, depth);
        for (int i = 0; i <= 9; i++) {
            if (i > prevDigit) {
                calcNum(i, digit * (long) i + num, depth + 1);
            }
        }
    }
}
