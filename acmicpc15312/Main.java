package acmicpc15312;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 이름 궁합
 * https://www.acmicpc.net/problem/15312
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] key = { 3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1 };
        char[] me = bf.readLine().toCharArray();
        char[] you = bf.readLine().toCharArray();
        int[] nums = new int[me.length + you.length];
        for (int i = 0; i < me.length; i++) {
            nums[i * 2] = key[me[i] - 'A'];
        }
        for (int i = 0; i < you.length; i++) {
            nums[i * 2 + 1] = key[you[i] - 'A'];
        }
        int length = nums.length - 1;
        // System.out.println(Arrays.toString(nums));
        while (length > 1) {
            for (int i = 0; i <= length - 1; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
            length--;
            // System.out.println(Arrays.toString(nums));
        }
        System.out.println(Integer.toString(nums[0]) + Integer.toString(nums[1]));
    }
}
