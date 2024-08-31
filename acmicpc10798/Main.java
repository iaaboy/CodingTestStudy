package acmicpc10798;

import java.io.*;

/* 세로읽기
 * https://www.acmicpc.net/problem/10798
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[][] arr = new char[5][];
        for (int i = 0; i < 5; i++) {
            arr[i] = bf.readLine().toCharArray();
        }
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < arr.length; y++) {
                if (x < arr[y].length) {
                    sb.append(arr[y][x]);
                }
            }
        }
        System.out.println(sb);
    }
}
