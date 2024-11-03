package acmicpc1931;

import java.io.*;
import java.util.*;

/* 
 * https://www.acmicpc.net/problem/1931
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[][] mRoom = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            mRoom[i][0] = Integer.parseInt(st.nextToken());// st
            mRoom[i][1] = Integer.parseInt(st.nextToken());// ed
        }
        Arrays.sort(mRoom, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        int prevHandled = 0;
        int count = 0;
        for (int i = 0; i < mRoom.length; i++) {
            if (mRoom[i][0] >= prevHandled) {
                count++;
                prevHandled = mRoom[i][1];
            }
        }
        System.out.println(count);
    }
}
