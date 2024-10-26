package acmicpc2884;

import java.io.*;
import java.util.*;

/* 알람 시계
 * https://www.acmicpc.net/problem/2884
 */

public class Main {
   public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    int h = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    m -= 45;
    if (m < 0) {
        h--;
        m+=60;
        if (h < 0) {
            h+=24;
        }
    }
    System.out.println(h +" " + m);
   } 
}
