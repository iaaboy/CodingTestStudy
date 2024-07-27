package acmicpc24552;

import java.io.*;

/* 올바른 괄호
 * https://www.acmicpc.net/problem/24552
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = bf.readLine().toCharArray();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                count++;
            } else {
                count--;
            }
        }
        int bCount = 0;
        int depth = 0;
        // System.out.println(count);
        if (count > 0) {
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] == '(') {
                    bCount++;
                    depth++;
                    if (depth >= 1) {
                        // System.out.println(i);
                        break;
                    }
                } else {
                    depth--;
                }
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == ')') {
                    bCount++;
                    depth++;
                    if (depth >= 1) {
                        break;
                    }
                } else {
                    depth--;
                }
            }
        }
        System.out.println(bCount);
    }
}