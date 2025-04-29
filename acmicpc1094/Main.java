package acmicpc1094;

import java.io.*;

/* 막대기
 * https://www.acmicpc.net/problem/1094
 * 2진수로 변환시 1의 개수를 의미.
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        for (char c : Integer.toBinaryString(Integer.parseInt(bf.readLine())).toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        System.out.println(count);
    }
}
