package acmicpc23825;

import java.io.*;
import java.util.*;

/* SASA 모형을 만들어보자
 * https://www.acmicpc.net/problem/23825
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int s1 = Integer.parseInt(st.nextToken()) / 2;
        int s2 = Integer.parseInt(st.nextToken()) / 2;

        int result = Math.min(s1, s2);
        System.out.println(result);
    }
}
