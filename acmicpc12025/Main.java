package acmicpc12025;

import java.io.*;
import java.util.*;

/* 장난꾸러기 영훈
 * https://www.acmicpc.net/problem/12025
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        char[] num = bf.readLine().toCharArray();
        long K = Long.parseLong(bf.readLine());
        int digit = 0;
        for (Character ch : num) {
            if (ch == '1' || ch == '2' || ch == '6' || ch == '7') {
                digit++;
            }
        }
        if (K > Math.pow(2, digit)) {
            System.out.println(-1);
        } else {
            // System.out.println("digit: " + digit);
            boolean[] choose = new boolean[digit];
            char[] idxN = Long.toBinaryString(K - 1).toCharArray();
            int handled = 0;
            for (int i = idxN.length - 1; i >= 0; i--) {
                choose[choose.length - 1 - handled] = idxN[i] == '1';
                handled++;
            }
            // System.out.println(Arrays.toString(choose));

            handled = 0;
            for (int i = 0; i < num.length; i++) {
                if (num[i] == '1' || num[i] == '6') {
                    if (choose[handled]) {
                        num[i] = '6';
                    } else {
                        num[i] = '1';
                    }
                    handled++;
                }
                if (num[i] == '2' || num[i] == '7') {
                    if (choose[handled]) {
                        num[i] = '7';
                    } else {
                        num[i] = '2';
                    }
                    handled++;
                }
            }
            StringBuilder sbb = new StringBuilder();
            for (char c : num) {
                sbb.append(c);
            }
            System.out.println(sbb);
        }
    }
}
