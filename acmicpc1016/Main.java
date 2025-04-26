package acmicpc1016;

import java.io.*;
import java.util.*;

/* 제곱 ㄴㄴ 수
 * https://www.acmicpc.net/problem/1016
에라토스테네스 체 원리를 이용해서 
제곱으로 나눠지는 수를 boolean true 처리

index를 옵셋으로 처리하기
제곱수 계산을 위해 long으로 변수처리.

 */

public class Main {
    static long min, max;
    static boolean[] canDiv;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        min = Long.parseLong(st.nextToken());
        max = Long.parseLong(st.nextToken());
        int N = (int) (max - min + 2);
        canDiv = new boolean[N];
        for (long j = 2; j * j <= max; j++) {
            setSeive(j * j);
        }
        int count = 0;
        for (long j = min; j <= max; j++) {
            if (!canDiv[getIndex(j)]) {
                count++;
            }
            // if (canDiv[getIndex(j)]) {
            // System.out.print(j + "," + canDiv[getIndex(j)] + " / ");
            // }

        }
        // System.out.println();
        System.out.println(count);
    }

    private static void setSeive(long num) {
        // min보다 작거나 같은 num 제곱수
        long start = (min / num);
        start += (min % num == 0) ? 0 : 1;
        start *= num;
        // System.out.println(num + ", " + start);
        // start로 나눠지는 수
        for (long i = 0; i * num + start <= max; i++) {
            canDiv[getIndex(i * num + start)] = true;
        }
    }

    private static int getIndex(long idx) {
        return (int) (idx - min);
    }
}
