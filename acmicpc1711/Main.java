package acmicpc1711;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] points;
    static long[][] lengthBetween;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        points = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
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
                System.out.println(Arrays.toString(index) + " ");
                count++;
            } else {
                System.out.println("Not:" + Arrays.toString(index) + " ");
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
        if (max == sum - max) {
            return true;
        }
        return false;
    }

    private static long getLength(Integer a, Integer b) {
        return (long) Math.pow(points[a][0] - points[b][0], 2) + (long) Math.pow(points[a][1] - points[b][1], 2);
    }
}
