package acmicpc17247;

import java.io.*;
import java.util.*;

/* 택시 거리
 * https://www.acmicpc.net/problem/17247
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] coord = new int[4];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    coord[idx++] = i;
                    coord[idx++] = j;
                }
            }
        }
        System.out.println(Math.abs(coord[0] - coord[2]) + Math.abs(coord[1] - coord[3]));
    }
}
