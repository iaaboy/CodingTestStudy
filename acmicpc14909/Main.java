package acmicpc14909;

import java.io.*;

/* 양수 개수 세기
 * https://www.acmicpc.net/problem/14909
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] inStr = bf.readLine().split(" ");
        int plusCount = 0;
        for (String str : inStr) {
            int num = Integer.parseInt(str);
            if (num > 0) {
                plusCount++;
            }
        }
        System.out.println(plusCount);
    }
}
