package acmicpc9012;

import java.io.*;
/* 괄호
 * https://www.acmicpc.net/problem/9012
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            char[] arr = bf.readLine().toCharArray();
            int braceCount = 0;
            boolean isCorrect = true;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == '(') {
                    braceCount++;
                } else {
                    braceCount--;
                }
                if (braceCount < 0) {
                    isCorrect = false;
                    break;
                }
            }
            if (!isCorrect || braceCount != 0) {
                sb.append("NO\n");
                continue;
            }
            for (int j = arr.length - 1; j >= 0; j--) {
                if (arr[j] == ')') {
                    braceCount++;
                } else {
                    braceCount--;
                }
                if (braceCount < 0) {
                    isCorrect = false;
                    break;
                }
            }
            if (isCorrect && braceCount == 0) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.print(sb);
    }
}
