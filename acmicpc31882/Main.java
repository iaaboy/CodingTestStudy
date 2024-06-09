package acmicpc31882;

import java.io.*;

/* 근수
 * https://www.acmicpc.net/problem/31882
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        char[] str = bf.readLine().toCharArray();

        long sum = 0, count = 0;
        for (int i = 0; i < N; i++) {
            if (str[i] == '2')
                count++;
            else
                count = 0;
            sum += count * (count + 1) / 2;
        }
        System.out.println(sum);
    }
}