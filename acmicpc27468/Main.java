package acmicpc27468;

import java.io.*;
import java.util.*;

/* 2배 또는 0.5배
 * https://www.acmicpc.net/problem/27468
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        
        StringBuilder sb = new StringBuilder();
        if (N < 3) {
            sb.append("NO");
        } else {
            
            
            int curVal = 0;
            sb.append("YES\n");

            if (N % 2 == 1 || N % 4 == 0) {
                sb.append("3 1 2 ");
                N -= 3;
                curVal = 2;
            } else {
                sb.append("1 2 4 3 ");
                N -= 4;
                curVal = 3;
            }

            int curIndex = 0;
            int[] offset = { 2, 1, 2, -1 };
            while (N-- > 0) {
                curVal = curVal + offset[curIndex++];
                if (curIndex == 4)
                    curIndex = 0;
                sb.append(curVal + " ");
            }
        }

        System.out.println(sb);
    }
}
