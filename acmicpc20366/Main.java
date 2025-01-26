package acmicpc20366;

import java.io.*;
import java.util.*;

/* 같이 눈사람 만들래?
 * https://www.acmicpc.net/problem/20366
 */

public class Main {
    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        arr[N] = max;

        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int diff = checkSnowMan(i, j, arr);
                minDiff = Math.min(minDiff, diff);
            }
        }
        System.out.println(minDiff);
    }

    private static int checkSnowMan(int i, int j, int[] arr) {
        int diff = arr[j] - arr[i];

        int l = 0;
        if (l == i) {
            l++;
        }
        if (l == j) {
            l++;
        }
        int r = l + 1;
        if (r == i) {
            r++;
        }
        if (r == j) {
            r++;
        }

        int minDiff = Math.abs((arr[r] - arr[l]) - diff);
        // System.out.println(i + " , " + j + " / " + l + " , " + r + " : " + diff + " :
        // " + minDiff);

        // diff에 가장 가까운 값을 찾는다.
        while (l < N && r < N) {
            if (l == i || l == j) {
                l++;
                continue;
            }
            if (r == j || r == i) {
                r++;
                continue;
            }

            if (arr[r] - arr[l] > diff) {
                int tempDiff = Math.abs((arr[r] - arr[l]) - diff);
                minDiff = Math.min(minDiff, tempDiff);

                l++;
            } else { // curSum < diff
                if (l != r) {
                    int tempDiff = Math.abs((arr[r] - arr[l]) - diff);
                    minDiff = Math.min(minDiff, tempDiff);
                }
                r++;
            }
        }
        // System.out.println("minDiff : " + minDiff);
        return minDiff;
    }
}
