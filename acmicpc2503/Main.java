package acmicpc2503;

import java.io.*;
import java.util.*;

/* 숫자 야구
 * https://www.acmicpc.net/problem/2503
완탐.
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Num[] nums = new Num[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            nums[i] = new Num(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }
        int count = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 1; k <= 9; k++) {
                    if (i == k || j == k) {
                        continue;
                    }
                    boolean allMatch = true;
                    for (int k2 = 0; k2 < N; k2++) {
                        if (!nums[k2].isMatch(i, j, k)) {
                            allMatch = false;
                            break;
                        }
                    }
                    if (allMatch) {
                        System.out.println(i + "" + j + "" + k);
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }

    static class Num {
        int[] nums;
        int strike, ball;
        Set<Integer> digit = new HashSet<>();

        public Num(int num, int strike, int ball) {
            nums = new int[] { num % 10, (num % 100) / 10, num / 100 };
            digit.add(nums[2]);
            digit.add(nums[1]);
            digit.add(nums[0]);
            this.strike = strike;
            this.ball = ball;
        }

        boolean isMatch(int i, int j, int k) {
            int strCount = 0;
            if (nums[2] == i) {
                strCount++;
            }
            if (nums[1] == j) {
                strCount++;
            }
            if (nums[0] == k) {
                strCount++;
            }
            if (strCount != strike) {
                return false;
            }
            int ballCount = -strCount;
            if (digit.contains(i)) {
                ballCount++;
            }
            if (digit.contains(j)) {
                ballCount++;
            }
            if (digit.contains(k)) {
                ballCount++;
            }
            if (ball != ballCount) {
                return false;
            }
            return true;
        }
    }
}
