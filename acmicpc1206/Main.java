package acmicpc1206;

import java.io.*;
import java.util.*;

/* 사람의 수
 * https://www.acmicpc.net/problem/1206
 */

public class Main {
    static int[] averageScores;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        averageScores = new int[n];

        for (int i = 0; i < n; i++) {
            averageScores[i] = Integer.parseInt(bf.readLine().replace(".", ""));
        }

        for (int count = 1; count <= 1000; count++) {
            if (possibleCount(count, averageScores)) {
                System.out.println(count);
                return;
            }
        }
    }

    static boolean possibleCount(int count, int[] averageScores) {
        for (int score : averageScores) {
            int left = 0;
            int right = 10 * count;
            boolean isPossible = false;
            while (left <= right) {
                int next = (left + right) / 2;
                int currentAverage = (next * 1000) / count;
                if (currentAverage == score) {
                    if (currentAverage > 10 * 1000) {
                        continue;
                    }
                    isPossible = true;
                    break;
                } else if (currentAverage > score) {
                        right = (next - 1);
                    } else {
                        left = (next + 1);
                }
            }
            if (!isPossible) {
                return false;
            }
        }
        return true;
    }
}
