package acmicpc1074;

import java.io.*;
import java.util.*;

/* Z
 * https://www.acmicpc.net/problem/1074
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long result = calcNum(N, r, c);
        System.out.println(result);
    }

    static long[][] sq = { { 0, 1 }, { 2, 3 } };

    private static long calcNum(int n, int r, int c) {
        int div = (int) Math.pow(2, n - 1);
        int idxR = r / div;
        int idxC = c / div;
        long result = sq[idxR][idxC] * (long) Math.pow(4, n - 1);
        // System.out.println(
        //         n + ":" + idxR + "," + idxC + " - " + sq[idxR][idxC] * (long) Math.pow(4, n - 1) + " .. " + div);

        if (n == 1) {
            return result;
        }

        result += calcNum(n - 1, r % div, c % div);
        return result;
    }
}
