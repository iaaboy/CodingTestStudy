package acmicpc30457;

import java.io.*;
import java.util.*;

/* 단체줄넘기
 * https://www.acmicpc.net/problem/30457
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] nums = new int[1001];
        int count = 0;
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (++nums[num] == 1 || nums[num] == 2) {
                count++;
            }
        }
        System.out.println(count);
    }
}
