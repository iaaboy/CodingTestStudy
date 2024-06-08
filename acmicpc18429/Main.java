package acmicpc18429;

import java.io.*;
import java.util.*;

/* 근손실
 * https://www.acmicpc.net/problem/18429
 */

public class Main {
    static int K;
    static int count = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        int[] kits = new int[N];
        int[] index = new int[N];
        for (int i = 0; i < N; i++) {
            kits[i] = Integer.parseInt(st.nextToken());
            index[i] = i;
        }
        visit(index, kits, 0);
        System.out.println(count);
    }

    private static void visit(int[] index, int[] kits, int depth) {
        if (kits.length == depth) {
            if (checkWeight(index, kits)) {
                count++;
                // System.out.println(Arrays.toString(index));
            }
            return;
        }
        for (int i = depth; i < kits.length; i++) {
            swap(index, depth, i);
            visit(index, kits, depth + 1);
            swap(index, depth, i);
        }
    }

    private static boolean checkWeight(int[] index, int[] kits) {
        int amount = 500;
        boolean result = true;
        for (int i = 0; i < kits.length; i++) {
            amount -= K;
            amount += kits[index[i]];
            if (amount < 500) {
                result = false;
                break;
            }
        }
        return result;
    }

    private static void swap(int[] index, int me, int you) {
        int temp = index[me];
        index[me] = index[you];
        index[you] = temp;
    }
}
