package acmicpc2491;

import java.io.*;
import java.util.*;

/* 수열
 * https://www.acmicpc.net/problem/2491
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int dec = 1;
        int inc = 1;
        int maxInc = 1;
        int maxDec = 1;
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int prevNum = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (prevNum > num) {
                dec++;
                inc = 1;
            } else if (prevNum < num) {
                inc++;
                dec = 1;
            } else {
                inc++;
                dec++;
            }
            maxInc = Math.max(maxInc, inc);
            maxDec = Math.max(maxDec, dec);
            prevNum = num;
        }
        System.out.println(Math.max(maxDec, maxInc));
    }
}
