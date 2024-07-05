package acmicpc14910;

import java.io.*;
import java.util.*;

/* 오르막
 * https://www.acmicpc.net/problem/14910
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int prev = -1000001;
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if (prev > num) {
                System.out.println("Bad");
                return;
            }
            prev = num;
        }
        System.out.println("Good");
    }
}
