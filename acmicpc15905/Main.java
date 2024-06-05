package acmicpc15905;

import java.io.*;
import java.util.*;

/* 스텔라(STELLA)가 치킨을 선물했어요
 * https://www.acmicpc.net/problem/15905
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int[] solved = new int[N];
        int[] penalty = new int[N];
        Integer[] index = new Integer[N];

        for (int i = 0; i < index.length; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            solved[i] = Integer.parseInt(st.nextToken());
            penalty[i] = Integer.parseInt(st.nextToken());
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> {
            if (solved[a] == solved[b]) {
                return penalty[a] - penalty[b];
            } else {
                return solved[b] - solved[a];
            }
        });

        // for (int i = 0; i < index.length; i++) {
        // System.out.println(solved[index[i]] + "," + penalty[index[i]]);
        // }
        int refSolved = solved[index[4]];
        int count = 0;
        for (int i = 5; i < index.length; i++) {
            if (refSolved == solved[index[i]]) {
                count++;
            } else {
                break;
            }
        }
        System.out.println(count);
    }
}
