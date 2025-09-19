package acmicpc1419;

import java.io.*;
import java.util.*;

/* 등차수열의 합
 * https://www.acmicpc.net/problem/1419
 */

public class Main {
    static int l,m,k;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        l = Integer.parseInt(bf.readLine());
        m = Integer.parseInt(bf.readLine());
        k = Integer.parseInt(bf.readLine());

        int count = 0;
        if (k == 2) {
            //3 이상의 모든 자연수
            int from = Math.max(l, 3);
            count = (m - from + 1);
            if (count < 0) {
                count = 0;
            }
        } else if (k == 3) {
            int from = Math.max(l, 6);
            for (int i = from; i <= m; i++) {
                if (i % 3 == 0) {
                    count++;
                }
            }
        } else if (k == 4) {
            int from  = Math.max(10, l);
            for (int i = from; i <= m; i++) {
                if (i % 2 == 0 && i != 12) {
                    count++;
                }
            }
        } else {
            int from = Math.max(15, l);
            for (int i = from; i <= m; i++) {
                if (i % 5 == 0) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

}
