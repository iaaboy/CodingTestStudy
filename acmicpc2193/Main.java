package acmicpc2193;

import java.io.*;
import java.util.*;

/* 이친수
 * https://www.acmicpc.net/problem/2193
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        long [][] arr = new long[2][N + 1];
        arr[0][1] = 0;
        arr[1][1] = 1;

        for (int i = 2; i <= N; i++) {
            //1의 개수 -> 0으로
            //0의 개수 -> 1하나, 0하나
            arr[0][i] = arr[1][i-1] + arr[0][i-1];
            arr[1][i] = arr[0][i-1];
        }

        // for (int i = 1; i <= N; i++) {
        //     System.out.print(arr[0][i] + " " );
        // }
        // System.out.println();
        // for (int i = 1; i <= N; i++) {
        //     System.out.print(arr[1][i] + " " );
        // }
        long result = arr[0][N] + arr[1][N];
        System.out.println(result);
    }
}
