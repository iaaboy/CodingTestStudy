package acmicpc14888;

import java.io.*;
import java.util.*;

/* 연산자 끼워넣기
 * https://www.acmicpc.net/problem/14888
완전탐색, 재귀
 */

public class Main {
    static int[] arr;
    static int[] op;
    static long min = Long.MAX_VALUE, max = Long.MIN_VALUE;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        int pl = Integer.parseInt(st.nextToken());
        int mi = Integer.parseInt(st.nextToken());
        int mul = Integer.parseInt(st.nextToken());
        int div = Integer.parseInt(st.nextToken());
        op = new int[N - 1];
        calculate(pl, mi, mul, div, 0);
        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n");
        sb.append(min);
        System.out.println(sb);
    }

    private static void calculate(int pl, int mi, int mul, int div, int depth) {
        if (depth == op.length) {
            // calculate
            // System.out.println(Arrays.toString(op));
            long result = (long)arr[0];
            for (int i = 0; i < op.length; i++) {
                if (op[i] == 0) {
                    result += arr[i + 1];
                } else if (op[i] == 1) {
                    result -= arr[i + 1];
                } else if (op[i] == 2) {
                    result *= arr[i + 1];
                } else {
                    result /= arr[i + 1];
                }
            }
            min = Math.min(min, result);
            max = Math.max(max, result);

            return;
        }
        if (pl > 0) {
            op[depth] = 0;
            calculate(pl - 1, mi, mul, div, depth + 1);
        }
        if (mi > 0) {
            op[depth] = 1;
            calculate(pl, mi - 1, mul, div, depth + 1);
        }
        if (mul > 0) {
            op[depth] = 2;
            calculate(pl, mi, mul - 1, div, depth + 1);
        }
        if (div > 0) {
            op[depth] = 3;
            calculate(pl, mi, mul, div - 1, depth + 1);
        }
    }
}
