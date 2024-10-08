package acmicpc24460;

import java.io.*;
import java.util.*;

/* 특별상이라도 받고 싶어
 * https://www.acmicpc.net/problem/24460
 */

public class Main {
    static int[][] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = getNum(0, 0, N);
        System.out.println(result);
    }

    private static int getNum(int x, int y, int n) {
        if (n == 1) {
            return arr[y][x];
        } else {
            int[] a = new int[4];
            a[0] = getNum(x, y, n / 2);
            a[1] = getNum(x + n / 2, y, n / 2);
            a[2] = getNum(x, y + n / 2, n / 2);
            a[3] = getNum(x + n / 2, y + n / 2, n / 2);
            Arrays.sort(a);
            return a[1];
        }
    }
}
