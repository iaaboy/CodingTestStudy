package acmicpc18869;

import java.io.*;
import java.util.*;

/*
 * 풀이중
 */

public class Main {
    static int k = 0;
    static ArrayList<ArrayList<Integer>> index = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        for (int j = 0; j < N; j++) {
                index.add(new ArrayList<>());
            }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                arr[j][i] = Integer.parseInt(st.nextToken());
                index.get(j).add(i);
            }
        }

        for (; k < N; k++) {
            index.get(k).sort((a, b) -> arr[k][a] - arr[k][b]);
        }

        for (int i = 0; i < N; i++) {
            System.out.println(index.get(i));
        }

        int ans= Collections.binarySearch(index.get(0),40);
        System.out.println(ans);
    }
}
