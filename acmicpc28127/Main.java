package acmicpc28127;

import java.io.*;
import java.util.*;

/* 숫자탑과 쿼리
 * https://www.acmicpc.net/problem/28127
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            int flower = 1;
            int currentTotal = a;
            int baseNum = 1;
            while (baseNum < x) {
                baseNum += currentTotal;
                if (baseNum > x) {
                    baseNum -= currentTotal;
                    break;
                }
                currentTotal = currentTotal + b;
                flower++;
            }
            sb.append(flower + " " + (x - baseNum + 1) + "\n");
        }
        System.out.print(sb);
    }
}
