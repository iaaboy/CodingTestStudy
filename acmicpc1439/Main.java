package acmicpc1439;

import java.io.*;

/* 뒤집기
 * https://www.acmicpc.net/problem/1439
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] nums = bf.readLine().toCharArray();
        char prev = 'a';
        int zeroCnt = 0;
        int oneCnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (prev != nums[i]) {
                if (nums[i] == '0') {
                    zeroCnt++;
                } else {
                    oneCnt++;
                }
                prev = nums[i];
            }
        }
        System.out.println(Math.min(zeroCnt, oneCnt));
    }
}
