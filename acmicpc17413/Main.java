package acmicpc17413;

import java.io.*;

/* 단어 뒤집기 2
 * https://www.acmicpc.net/problem/17413
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = bf.readLine().toCharArray();
        boolean inBrace = false;
        int left = -1;
        int right = -1;
        int i = 0;
        for (; i < arr.length; i++) {
            if (arr[i] == '<') {
                if (left != -1) {
                    right = i - 1;
                    reverseWord(arr, left, right);
                    left = -1;
                    right = -1;
                }
                inBrace = true;
            } else if (arr[i] == '>') {
                inBrace = false;
            } else if (!inBrace && arr[i] == ' ') {
                right = i - 1;
                reverseWord(arr, left, right);
                left = -1;
                right = -1;
            } else if (!inBrace && left == -1) {
                left = i;
            }
        }
        if (left != -1) {
            right = i - 1;
            reverseWord(arr, left, right);
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < arr.length; j++) {
            sb.append(arr[j]);
        }

        System.out.println(sb);
    }

    private static void reverseWord(char[] arr, int left, int right) {
        // System.out.println("reverseWord" + left + "," + right);
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}