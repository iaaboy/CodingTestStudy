package acmicpc16563;

import java.io.*;
import java.util.*;

/* 어려운 소인수분해
 * https://www.acmicpc.net/problem/16563
 * 정수론, 에라토스 체네스
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {

        int[] erastos = new int[5000001];
        for (int i = 0; i < erastos.length; i++) {
            erastos[i] = i;
        }
        for (int i = 2; i < erastos.length / 2; i++) {
            if (erastos[i] == i) {
                for (int j = i; j < erastos.length; j += i) {
                    erastos[j] = i;
                }
            }
        }

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            StringBuilder sbPartial = new StringBuilder();
            sbPartial.append("\n");
            while (erastos[num] != num) {
                sbPartial.insert(0, erastos[num] + " ");
                num /= erastos[num];
            }
            sbPartial.insert(0, num + " ");
            sb.append(sbPartial);
        }
        System.out.print(sb);
    }
}
