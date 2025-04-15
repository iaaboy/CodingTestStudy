package acmicpc26595;

import java.io.*;
import java.util.*;

/* 전투의 신
 * https://www.acmicpc.net/problem/26595
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long A = Integer.parseInt(st.nextToken());
        long pA = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long pB = Integer.parseInt(st.nextToken());
        long maxValue = 0;
        long value = 0;
        long countA = 0;
        long countB = 0;
        for (int i = 0; i <= N; i++) {
            value = A * i;
            long remainedMoney = (N - (i * pA));
            if (remainedMoney < 0) {
                break;
            }
            long cB = remainedMoney / pB;
            value += B * cB;
            if (value > maxValue) {
                maxValue = value;
                countA = i;
                countB = cB;
            }
        }
        System.out.println(countA + " " + countB);
    }
}
