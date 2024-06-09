package acmicpc1900;

import java.io.*;
import java.util.*;

/* 레슬러
 * https://www.acmicpc.net/problem/1900
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] strength = new int[N];
        int[] ringPower = new int[N];
        int[] wins = new int[N];
        Integer[] order = new Integer[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            strength[i] = Integer.parseInt(st.nextToken());
            ringPower[i] = Integer.parseInt(st.nextToken());
            order[i] = i;
        }
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                if ((strength[i] + ringPower[i] * strength[j]) > (strength[j] + ringPower[j] * strength[i])) {
                    wins[i]++;
                } else {
                    wins[j]++;
                }
            }
        }
        Arrays.sort(order, (a, b) -> (wins[b] - wins[a]));
        StringBuilder sb = new StringBuilder();
        for (Integer i : order) {
            sb.append(i + 1 + "\n");
        }
        System.out.println(sb);
    }
}
