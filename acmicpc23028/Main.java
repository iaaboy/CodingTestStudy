package acmicpc23028;

import java.io.*;
import java.util.*;

/* 5학년은 다니기 싫어요
 * https://www.acmicpc.net/problem/23028
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int major = 0;
        int minor = 0;
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(bf.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            if (N + i < 8) {
                if (X + Y <= 6) {
                    major += X;
                    minor += Y;
                } else {
                    major += X;
                    int remained = 6 - X;
                    if (remained <= Y) {
                        minor += remained;
                    } else {
                        minor += Y;
                    }
                    
                }
            }
        }
        major *= 3;
        minor *= 3;
        if (major + A >= 66 && minor + major + B >= 130) {
            System.out.println("Nice");
        } else {
            System.out.println("Nae ga wae");
        }
    }
}
