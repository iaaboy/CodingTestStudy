package acmicpc3018;

import java.io.*;
import java.util.*;

/* 캠프파이어
 * https://www.acmicpc.net/problem/3018
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int E = Integer.parseInt(bf.readLine());
        HashSet<Integer>[] m = new HashSet[N + 1];
        for (int i = 0; i <= N; i++) {
            m[i] = new HashSet<Integer>();
        }
        int songIndex = 0;
        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int K = Integer.parseInt(st.nextToken());
            int[] arr = new int[K];
            boolean hasSY = false;
            for (int j = 0; j < K; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                if (arr[j] == 1) {
                    hasSY = true;
                }
            }
            if (hasSY) {
                for (int member : arr) {
                    m[member].add(songIndex);
                }
                songIndex++;
            } else {
                for (int me : arr) {
                    for (int you : arr) {
                        if (me == you)
                            continue;
                        for (Integer song : m[me]) {
                            m[you].add(song);
                        }
                    }
                }
            }
        }
        int maxSongCount = m[1].size();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (maxSongCount == m[i].size()) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }
}
