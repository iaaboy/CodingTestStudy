package acmicpc4090;

import java.io.*;
import java.util.*;

/*
 * 풀이중
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = 1000000;
        ArrayList<Integer> vampier = new ArrayList<>();
        // StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int right = 1; right * right <= i; right++) {
                if (i % right != 0)
                    continue;
                int left = i / right;

                if (right > left)
                    continue;

                if (checkNum(left, right, i)) {
                    vampier.add(i);
                    break;
                }
            }
        }
        System.out.println("size: " + vampier.size());
        while (true) {
            int num = Integer.parseInt(bf.readLine());
            if (num == 0) {
                break;
            }
            for (int i : vampier) {
                if (num <= i) {
                    // sb.append(i).append("\n");
                    System.out.println(i);
                    break;
                }
            }
        }
        // System.out.print(sb);
    }

    private static boolean checkNum(int left, int right, int num) {
        int[] count = new int[10];

        while (left > 0) {
            count[left % 10]++;
            left /= 10;
        }
        while (right > 0) {
            count[right % 10]++;
            right /= 10;
        }

        while (num > 0) {
            count[num % 10]--;
            num /= 10;
        }

        for (int c : count) {
            if (c != 0)
                return false;
        }
        return true;
    }
}