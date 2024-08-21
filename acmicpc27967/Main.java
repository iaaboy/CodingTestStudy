package acmicpc27967;

import java.io.*;

/* 고추장 괄호 문자열
 * https://www.acmicpc.net/problem/27967
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        char[] arr = bf.readLine().toCharArray();
        int braceCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                braceCount++;
            } else if (arr[i] == ')') {
                braceCount--;
                if (braceCount == -1) {
                    setLeft(arr, i);
                    braceCount = 0;
                }
            }
        }
        braceCount = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == ')') {
                braceCount++;
            } else if (arr[i] == '(') {
                braceCount--;
                if (braceCount == -1) {
                    setRight(arr, i);
                    braceCount = 0;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean isOpen = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'G') {
                if (isOpen) {
                    sb.append(')');
                } else {
                    sb.append('(');
                }
                isOpen = !isOpen;
            } else {
                sb.append(arr[i]);
            }
        }
        System.out.println(sb);
    }

    private static void setRight(char[] arr, int idx) {

        for (int i = idx + 1; i < arr.length; i++) {
            if (arr[i] == 'G') {
                arr[i] = ')';
                break;
            }
        }
        // System.out.println("setRight" + idx + ":" + Arrays.toString(arr));
    }

    private static void setLeft(char[] arr, int idx) {

        for (int i = idx - 1; i >= 0; i--) {
            if (arr[i] == 'G') {
                arr[i] = '(';
                break;
            }
        }
        // System.out.println("setLeft" + idx + ":" + Arrays.toString(arr));
    }
}
