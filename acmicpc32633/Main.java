package acmicpc32633;

import java.io.*;
import java.util.*;

/* 두더지 찾기
 * https://www.acmicpc.net/problem/32633
 * 정수론, 유클리드 호제법
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        long L = Long.parseLong(st.nextToken());
        long[] num = new long[N];
        ArrayList<Long> canDiv = new ArrayList<>();
        ArrayList<Long> canNotDiv = new ArrayList<>();
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            if (Integer.parseInt(st.nextToken()) == 1) {
                canDiv.add(num[i]);
            } else {
                canNotDiv.add(num[i]);
            }
        }
        long lcmNum = lcmOfArray(canDiv, L);
        if (lcmNum == -1) {
            System.out.println(-1);
            return;
        }

        boolean passed = true;
        for (Long cnd : canNotDiv) {
            if (lcmNum % cnd == 0) {
                passed = false;
                break;
            }
        }
        if (passed) {
            System.out.println(lcmNum);
            return;
        }
        System.out.println(-1);
    }

    static long gcd(long a, long b) {
        while (b != 0) {
            long tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }

    // public static long lcm(long a, long b) {
    //     return a * (b / gcd(a, b));
    // }
    static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    public static long lcmOfArray(ArrayList<Long> numbers, Long L) {
        long result = 1;
        for (Long nn : numbers) {
            result = lcm(result, nn);
            if (result > L) {
                return -1;
            }
        }
        return result;
    }
}
