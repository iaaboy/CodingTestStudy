package acmicpc33718;

import java.io.*;
import java.util.*;

/*
 * 못풀었음..
 */

public class Main {
    static long[] arr, express;
    static boolean[] visit;
    static long T;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Long.parseLong(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        arr = new long[6];
        visit = new boolean[6];
        express = new long[6 + 5];
        // Arrays.fill(express, -3);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        makeExpress(0);
        if (!succeed) {
            System.out.println(-1);
        }
    }

    // op .. -1 go next num, 1 +, 2 - , 3 * , 4 /
    static boolean succeed = false;
    private static void makeExpress(int depth) {
        if (succeed) {
            return;
        }
        long val = calculate(depth);
        // System.out.println("val: " + val + " , " + depth + " , " +
        // Arrays.toString(express));
        if (val == T) {
            // System.out.println("Hit: " + depth + " , " + val + " : " + Arrays.toString(express));
            succeed = printCalculate(depth);;
            return;
        }
        if (val == -2) {
            return;
        }
        if (depth == 11) {
            return;
        }

        if (depth % 2 == 0) {
            for (int i = 0; i < 6; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    express[depth] = arr[i];
                    makeExpress(depth + 1);
                    visit[i] = false;
                }
            }
        } else {
            for (int i = 0; i < 4; i++) {
                express[depth] = i;
                makeExpress(depth + 1);
            }
        }
    }
    
    static boolean printCalculate(int depth) {
        StringBuilder sb = new StringBuilder();
        if (depth == 1) {
            sb.append("0").append("\n");
        } else {
            sb.append(depth / 2).append("\n");
            long sum = express[0];
            for (int i = 2; i < depth; i += 2) {
                sb.append(sum);
                int op = (int) express[i - 1];
                if (op == 0) { // +
                    sb.append(" + ");
                    sum += express[i];
                } else if (op == 1) { // -
                    sb.append(" - ");
                    sum -= express[i];
                } else if (op == 2) { // *
                    sb.append(" * ");
                    sum *= express[i];
                } else if (op == 3) { // /
                    sb.append(" / ");
                    if (sum % express[i] != 0) {
                        return false;
                    }
                    sum /= express[i];
                }
                if (sum < 0) {
                    return false;
                }
                sb.append(express[i]).append(" = ").append(sum).append("\n");
            }
        }
        System.out.print(sb);

        return true;
    }

    private static long calculate(int depth) {
        // System.out.println(depth + " : " + Arrays.toString(express));
        if (depth == 0) {
            return -1;
        }
        if (depth % 2 == 0) {
            return -1;
        }
        long sum = express[0];
        for (int i = 2; i < depth; i += 2) {
            int op = (int) express[i - 1];
            if (op == 0) { // +
                sum += express[i];
            } else if (op == 1) { // -
                sum -= express[i];
                if (sum < 0) {
                    return -2;
                }
            } else if (op == 2) { // *
                sum *= express[i];
            } else if (op == 3) { // /
                if (sum % express[i] != 0) {
                    return -2;
                }
                sum /= express[i];
            }
        }
        return sum;
    }
}
