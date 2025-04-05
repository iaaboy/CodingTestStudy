package acmicpc33718;

import java.io.*;
import java.util.*;

public class Main {
    static long[] arr, express;
    static boolean[] visit;
    static long T;
    static int NUM = 6;
    static int OPCOUNT = 4;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Long.parseLong(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        arr = new long[NUM];
        visit = new boolean[NUM];
        express = new long[NUM + NUM - 1];
        Arrays.fill(express, -3);
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
        if (depth == NUM + NUM - 1) {
            // printFullExp();
            if (printCalculate(depth)) {
                succeed = true;
            }
            return;
        }

        if (depth % 2 == 0) {
            for (int i = 0; i < NUM; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    express[depth] = arr[i];
                    makeExpress(depth + 1);
                    visit[i] = false;
                }
            }
        } else {
            for (int i = 0; i < OPCOUNT; i++) {
                express[depth] = i;
                makeExpress(depth + 1);
            }
        }
    }
    public static boolean willOverflow(long a, long b) {
        if (a > 0 && b > 0) {
            return a > Long.MAX_VALUE / b;
        } else if (a > 0 && b < 0) {
            return b < Long.MIN_VALUE / a;
        } else if (a < 0 && b > 0) {
            return a < Long.MIN_VALUE / b;
        } else if (a < 0 && b < 0) {
            return a < Long.MAX_VALUE / b;
        }
        return false; // a == 0 or b == 0
    }

    private static void printFullExp() {
        StringBuilder exp = new StringBuilder();
        for (int i = 0; i < express.length; i++) {
            if (i % 2 == 1) {
                exp.append(getOp(express[i]));
            } else {
                exp.append(express[i]);
            }
        }
        System.out.println(exp);
    }

    private static String getOp(long l) {
        if (l == 0) {
            return "+";
        } else if (l == 1) {
            return "-";
        } else if (l == 2) {
            return "*";
        } else {
            return "/";
        }
    }

    static boolean printCalculate(int depth) {
        StringBuilder sb = new StringBuilder();

        long sum = express[0];
        if (sum == T) {
            System.out.println(0);
            return true;
        }
        for (int i = 2; i < depth; i += 2) {
            sb.append(sum);
            int op = (int) express[i - 1];
            if (op == 0) { // +
                sb.append(" + ");
                sum += express[i];
            } else if (op == 1) { // -
                sb.append(" - ");
                sum -= express[i];

                // !!! 음수 체크
                if (sum <= 0) {
                    return false;
                }

            } else if (op == 2) { // *
                sb.append(" * ");
                if (willOverflow(sum, express[i])) {
                    return false;
                } else {
                    sum *= express[i];
                }
                // 
            } else if (op == 3) { // /
                sb.append(" / ");

                // !!! 나누어 떨어지는지 체크
                if (sum % express[i] != 0) {
                    return false;
                }
                sum /= express[i];
                if (sum == 0) {
                    return false;
                }
            }
            sb.append(express[i]).append(" = ").append(sum).append("\n");
            if (sum == T) {
                sb.insert(0, (i / 2) + "\n");
                System.out.print(sb);
                return true;
            }
        }

        return false;
    }
}

