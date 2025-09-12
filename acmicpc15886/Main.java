package acmicpc15886;

import java.io.*;

/* 내 선물을 받아줘 2
 * https://www.acmicpc.net/problem/15886
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        char[] str = bf.readLine().toCharArray();
        int count = 0;
        for (int i = 0; i < N - 1; i++) {
            if (str[i] == 'E' && str[i + 1] == 'W')
                count++;
        }
        System.out.println(count);
    }
}
