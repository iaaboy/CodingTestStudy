package acmicpc12934;

import java.io.*;
import java.util.*;

/* 턴 게임
 * https://www.acmicpc.net/problem/12934
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long yun = Long.parseLong(st.nextToken());
        Long dong = Long.parseLong(st.nextToken());

        if (yun == 0 && dong == 0) {
            System.out.println("0");
        }

        long k = 1;
        while (yun + dong >= (k * (k + 1) / 2)) {
            if (yun + dong == (k * (k + 1) / 2)) {
                long result = 0;
                // 제일 큰 수부터 뺀다
                for (long i = k; i >= 1; i--) {
                    if (yun == 0)
                        break;

                    yun -= Math.min(yun, i);
                    result++;
                }
                System.out.println(result);
                return;
            }
            k++;
        }
        System.out.println("-1");
    }
}
