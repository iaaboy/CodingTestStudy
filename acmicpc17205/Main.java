package acmicpc17205;

import java.io.*;

/* 진우의 비밀번호
 * https://www.acmicpc.net/problem/17205
 */

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()) - 1;
        char[] num = bf.readLine().toCharArray();
        long ans = 0;

        for (int i = 0; i < num.length; i++) {
            long diff = num[i] - 'a';
            if (diff > 0) {
                ans += diff * 26 * (Math.pow(26, N) - 1) / 25 + diff;
            }
            ans ++;
            N--;
        }

        System.out.println(ans);
    }
}
