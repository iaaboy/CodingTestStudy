package acmicpc2628;

import java.io.*;
import java.util.*;

/* 종이자르기
 * https://www.acmicpc.net/problem/2628
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(bf.readLine());

        ArrayList <Integer> xPtr = new ArrayList<>();
        ArrayList <Integer> yPtr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int xy = Integer.parseInt(st.nextToken());
            if(xy == 1) {
                xPtr.add(Integer.parseInt(st.nextToken()));
            } else {
                yPtr.add(Integer.parseInt(st.nextToken()));
            }
        }
        xPtr.sort(null);
        yPtr.sort(null);

        int prev = 0;
        int maxX = 0;
        for (Integer ptr : xPtr) {
            maxX = Math.max(maxX, ptr - prev);
            prev = ptr;
        }
        maxX = Math.max(maxX, X - prev);
        prev = 0;
        int maxY = 0;
        for (Integer ptr : yPtr) {
            maxY = Math.max(maxY, ptr - prev);
            prev = ptr;
        }

        maxY = Math.max(maxY, Y - prev);

        // System.out.println(maxX + ":" + xPtr);
        // System.out.println(maxY + ":" + yPtr);

        System.out.println(maxX * maxY);
    }
}
