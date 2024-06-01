package acmicpc31287;

import java.io.*;
import java.util.*;

/* 장난감 강아지 풀이
 * https://www.acmicpc.net/problem/31287
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String s = bf.readLine();
        char[] inArr = s.toCharArray();

        int x = 0;
        int y = 0;

        if (K > (N / 2)) {
            K = (N / 2);
        }

        for (int j = 0; j < K; j++) {
            for (int i = 0; i < inArr.length; i++) {
                if (inArr[i] == 'L') {
                    x--;
                } else if (inArr[i] == 'R') {
                    x++;
                } else if (inArr[i] == 'U') {
                    y++;
                } else if (inArr[i] == 'D') {
                    y--;
                }
                if (x == 0 && y == 0) {
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");
    }
}
