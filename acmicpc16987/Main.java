package acmicpc16987;

import java.io.*;
import java.util.*;

/* 계란으로 계란치기
 * https://www.acmicpc.net/problem/16987
 */

public class Main {
    static int[] durability, weight;
    static int n = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        durability = new int[n];
        weight = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            durability[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }
        smash(0);
        System.out.println(max);
    }
    static int max = 0;
    private static void smash(int current) {
        if (current == n) {
            // 남은 durability
            // System.out.println("current: " + current + ":" + Arrays.toString(durability));
            // check max
            int tempSum = 0;
            for (int i = 0; i < durability.length; i++) {
                if (durability[i] <= 0) {
                    tempSum++;
                }
            }
            max = Math.max(max, tempSum);
            return;
        }
        if (durability[current] <= 0) {
            smash(current + 1);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (i == current) {
                continue;
            }
            if (durability[i] > 0) {
                durability[current] -= weight[i];
                durability[i] -= weight[current];
                smash(current + 1);
                durability[current] += weight[i];
                durability[i] += weight[current];
            } else {
                smash(current + 1);
            }
        }
    }
}
