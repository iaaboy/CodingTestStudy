package acmicpc11943;

import java.io.*;
import java.util.*;

/* 파일 옮기기
 * https://www.acmicpc.net/problem/11943
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int o1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int a2 = Integer.parseInt(st.nextToken());
        int o2 = Integer.parseInt(st.nextToken());

        int a = a2 + o1;
        int b = a1 + o2;
        System.out.println(Math.min(a,b));
    }
}
