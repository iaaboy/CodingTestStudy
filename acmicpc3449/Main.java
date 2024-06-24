package acmicpc3449;

import java.io.*;

/* 해밍 거리
 * https://www.acmicpc.net/problem/3449
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            char [] arr1 = bf.readLine().toCharArray();
            char [] arr2 = bf.readLine().toCharArray();
            int count = 0;
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] != arr2[j]) {
                    count++;
                }
            }
            sb.append(String.format("Hamming distance is %d." , count) + "\n" );
        }
        System.out.println(sb);
    }
}
