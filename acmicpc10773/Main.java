package acmicpc10773;

import java.util.*;
import java.io.*;

/* 제로
 * https://www.acmicpc.net/problem/10773
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        int zeroCount = 0;
        int sum = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 0) {
                zeroCount++;
            } else {
                if (zeroCount > 0) {
                    zeroCount--;
                } else {
                    sum+=arr[i];
                }
            }
        }
        System.out.println(sum);
    }
}
