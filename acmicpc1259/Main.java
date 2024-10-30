package acmicpc1259;

import java.io.*;

/* 팰린드롬수
 * https://www.acmicpc.net/problem/status/1259
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = { '1' };
        StringBuilder sb = new StringBuilder();
        while (arr[0] != '0') {
            arr = bf.readLine().toCharArray();
            if (arr[0] == '0') {
                break;
            }
            boolean isPelin = true;
            for (int i = 0; i < arr.length / 2; i++) {
                if (arr[i] != arr[arr.length - 1 - i]) {
                    isPelin = false;
                    break;
                }
            }
            if (isPelin) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }
        System.out.print(sb);
    }
}
