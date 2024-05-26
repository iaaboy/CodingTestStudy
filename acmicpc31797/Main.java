package acmicpc31797;

import java.io.*;
import java.util.*;

/* 아~파트 아파트
 * https://www.acmicpc.net/problem/31797
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] mm = new int[M * 2];
        Integer[] index = new Integer[M * 2];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            mm[i * 2] = Integer.parseInt(st.nextToken());
            mm[i * 2 + 1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(index, (a, b) -> mm[a] - mm[b]);
        int seq = (N - 1) % (M * 2);
        // System.out.println(Arrays.toString(mm));
        // System.out.println(Arrays.toString(index));
        System.out.println(index[seq] / 2 + 1);
    }
}
