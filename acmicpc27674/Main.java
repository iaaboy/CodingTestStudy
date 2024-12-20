package acmicpc27674;

import java.io.*;
import java.util.*;

/* A+B
 * https://www.acmicpc.net/problem/27674
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            bf.readLine();
            char [] ch = bf.readLine().toCharArray();
            Long [] c = new Long[ch.length];
            for (int j = 0; j < ch.length; j++) {
                c[j] = (long)ch[j] - '0';
            }
            Arrays.sort(c, Collections.reverseOrder());
            // System.out.println(Arrays.toString(c));

            long firstNum = 0;
            long secondNum = c[c.length - 1];
            for (int j = 0; j < c.length - 1; j++) {
                firstNum *= 10;
                firstNum += c[j];
            }
            sb.append(firstNum + secondNum).append("\n");

        }
        System.out.print(sb);
    }
}
