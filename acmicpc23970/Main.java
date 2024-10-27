package acmicpc23970;

import java.io.*;
import java.util.*;

/* 알고리즘 수업 - 버블 정렬 3
 * https://www.acmicpc.net/problem/23970
 */

public class Main {
    static int N = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        int[] ori = new int[N];
        int[] target = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            ori[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        boolean isSame = true;
        for (int k = 0; k < N; k++) {
            if (ori[k] != target[k]) {
                isSame = false;
                break;
            }
        }
        if (isSame) {
            System.out.println("1");
            return;
        }
        int k = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N - i; j++) {
                if (ori[j] > ori[j + 1]) {
                    int temp = ori[j];
                    ori[j] = ori[j + 1];
                    ori[j + 1] = temp;

                    isSame = true;
                    // k = 0;
                    for (; k < N; k++) {
                        if (ori[k] != target[k]) {
                            isSame = false;
                            break;
                        }
                    }
                    if (isSame) {
                        // System.out.println(Arrays.toString(ori));
                        System.out.println("1");
                        return;
                    }
                    // System.out.println(k + "," + j + ":" + Arrays.toString(ori));
                }
            }
        }
        System.out.println("0");
    }
}