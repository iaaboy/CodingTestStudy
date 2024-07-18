package acmicpc31964;

import java.io.*;
import java.util.*;

/* 반품 회수
 * https://www.acmicpc.net/problem/31964
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int[] distance = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }
        int[] time = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }

        int delay = 0;
        for (int i = distance.length - 1; i >= 0; i--) {
            int returnTime = distance[distance.length - 1] + (distance[distance.length - 1] - distance[i]);
            if (time[i] > returnTime + delay) {
                delay = time[i] - (returnTime);
            }
        }
        System.out.println(distance[distance.length - 1] * 2 + delay);
    }
}
