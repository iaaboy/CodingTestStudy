package acmicpc33510;

import java.io.*;

/* 이상한 나누기
 * https://www.acmicpc.net/problem/33510
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        char[] num = bf.readLine().toCharArray();
        int i = num.length - 1;
        while (i > 0 && num[i] != '1') {
            i--;
        }
        int count = 0;
        if (i > 0) {
            count++;
        }
        while (i > 0) {
            if (num[i--] == '0') {
                count++;
            }
        }
        System.out.println(count);
    }
}
