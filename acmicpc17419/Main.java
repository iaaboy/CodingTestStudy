package acmicpc17419;

import java.io.*;

/* 비트가 넘쳐흘러
 * https://www.acmicpc.net/problem/17419
 */

public class Main {
    static long[] arr;
    static long sum = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        char[] K = bf.readLine().toCharArray();
        int count = 0;
        for (char k : K) {
            if (k == '1') {
                count++;
            }
        }
        System.out.println(count);
    }
}
