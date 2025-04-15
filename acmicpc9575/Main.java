package acmicpc9575;

import java.io.*;
import java.util.*;

/* 행운의 수
 * https://www.acmicpc.net/problem/9575
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int n = 0; n < N; n++) {
            int A = Integer.parseInt(bf.readLine());
            StringTokenizer st = new StringTokenizer(bf.readLine());
            Set<Integer> a = new HashSet<>();
            for (int i = 0; i < A; i++) {
                a.add(Integer.parseInt(st.nextToken()));
            }
            int B = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine());
            Set<Integer> b = new HashSet<>();
            for (int i = 0; i < B; i++) {
                b.add(Integer.parseInt(st.nextToken()));
            }
            int C = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine());
            Set<Integer> c = new HashSet<>();
            for (int i = 0; i < C; i++) {
                c.add(Integer.parseInt(st.nextToken()));
            }

            Set<Integer> luckyNum = new HashSet<>();
            for (Integer a2 : a) {
                for (Integer b2 : b) {
                    for (Integer c2 : c) {
                        int sum = a2 + b2 + c2;
                        if (checkLunck(sum)) {
                            luckyNum.add(sum);
                        }
                    }
                }
            }
            sb.append(luckyNum.size()).append("\n");
        }
        System.out.print(sb);
    }

    private static boolean checkLunck(int sum) {
        while (sum != 0) {
            if (sum % 10 == 5 || sum % 10 == 8) {

            } else {
                return false;
            }
            sum /= 10;
        }
        return true;
    }
}
