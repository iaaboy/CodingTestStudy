package acmicpc16162;

import java.io.*;
import java.util.*;

/* 가희와 3단 고음
 * https://www.acmicpc.net/problem/16162
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int curNum = A;
        int count = 0;
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            if (curNum == Integer.parseInt(st.nextToken())) {
                count++;
                curNum += D;
            }
        }
        System.out.println(count);
    }
}
