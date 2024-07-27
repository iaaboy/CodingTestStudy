package acmicpc3231;

import java.io.*;
import java.util.*;

/* 카드놀이
 * https://www.acmicpc.net/problem/3231
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int [] nums = new int[N];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(bf.readLine());
            boolean isHandled = false;
            for (int j = 0; j < idx; j++) {
                if (nums[j] == num - 1) {
                    nums[j]++;
                    isHandled = true;
                    break;
                }
            }
                
            if (!isHandled) {
                nums[idx++] = num;
            }
        }
        System.out.println(idx - 1);
    }
}
