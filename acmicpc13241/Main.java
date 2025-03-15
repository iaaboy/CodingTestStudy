package acmicpc13241;

import java.io.*;
import java.util.*;

/* 최소공배수
 * https://www.acmicpc.net/problem/13241
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        Set<Long> aMulti = new HashSet<>();
        int idx = 1;
        long a = A;
        long b = B;
        while (a < A * B) {
            a = A * idx++;
            aMulti.add(a);
        }
        idx = 1;
        while (b < A * B) {
            b = B * idx++;
            if (aMulti.contains(b)) {
                break;
            }
        }
        System.out.println(b);
    }
}