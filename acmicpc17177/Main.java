package acmicpc17177;

import java.io.*;
import java.util.*;

/* 내접사각형 만들기
 * https://www.acmicpc.net/problem/17177
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int result = -1;
        for (int i = 1; i <= a; ++i) {
            int tmp1 = (a * i + b * c) * (a * i + b * c) - (a * a - b * b) * (a * a - c * c);
            int tmp2 = (a * c + b * i) * (a * c + b * i) - (a * a - i * i) * (a * a - b * b);

            if (tmp1 == 0 || tmp2 == 0) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
