package acmicpchttps:.www.acmicpc.net.problem.1711;

import java.io.*;
import java.util.*;

/* 직각삼각형
 * https://www.acmicpc.net/source/97515457
 */

public class Main {
    static int N;
    static long[][] points;
    static long[][] lengthBetween;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        points = new long[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            points[i][0] = Long.parseLong(st.nextToken());
            points[i][1] = Long.parseLong(st.nextToken());
        }
        lengthBetween = new long[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                lengthBetween[i][j] = getLength(i, j);
            }
        }
        int[] index = new int[3];
        combination2(index, 0, 0);
        System.out.println(count);
    }

    static int count = 0;

    static private void combination2(int[] index, int cnt, int idx) {
        if (cnt == 3) {
            if (isTriangle(index)) {
                // for (Integer c2 : c) {
                // System.out.print(Arrays.toString(points[c2]) + " ");
                // }
                // System.out.println();
                count++;
            } else {
                // System.out.println("No :" + c);
            }
            return;
        }
        for (int i = idx; i < N; i++) {
            index[cnt] = i;
            combination2(index, cnt + 1, i + 1);
        }
    }

    private static boolean isTriangle(int[] c) {
        long sum = 0;
        long max = 0;
        long calc = lengthBetween[c[0]][c[1]];
        sum += calc;
        max = Math.max(max, calc);
        calc = lengthBetween[c[1]][c[2]];
        sum += calc;
        max = Math.max(max, calc);
        calc = lengthBetween[c[0]][c[2]];
        sum += calc;
        max = Math.max(max, calc);
        // System.out.print(Arrays.toString(byun) + " .. ");
        if (max == sum - max) {
            return true;
        }
        return false;
    }

    private static long getLength(int a, int b) {
        return (points[a][0] - points[b][0]) * (points[a][0] - points[b][0]) + (points[a][1] - points[b][1]) * (points[a][1] - points[b][1]);
    }
}
