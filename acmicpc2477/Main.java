package acmicpc2477;

import java.io.*;
import java.util.*;

/* 참외밭
 * https://www.acmicpc.net/problem/2477
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(bf.readLine());
        Line[] ls = new Line[6];
        int[] dirCount = new int[5];
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int dir = Integer.parseInt(st.nextToken());
            dirCount[dir]++;
            int len = Integer.parseInt(st.nextToken());
            ls[i] = new Line(dir, len);
        }

        for (int i = 0; i < 6; i++) {
            if (dirCount[ls[i].dir] == 1) {
                ls[i].isLong = true;
            }
        }
        int startIdx = 0;
        boolean prev = ls[5].isLong;
        for (int i = 0; i < 6; i++) {
            if (prev && ls[i].isLong) {
                startIdx = i;
                break;
            }
            prev = ls[i].isLong;
        }
        // System.out.println(Arrays.toString(ls));
        int max1 = startIdx;
        int max2 = (startIdx + 5) % 6;
        int min1 = (startIdx + 2) % 6;
        int min2 = (startIdx + 3) % 6;

        int width = ls[max1].len * ls[max2].len - ls[min1].len * ls[min2].len;

        System.out.println(K * width);
    }

    static class Line {
        int dir;
        int len;
        boolean isLong;

        public Line(int dir, int len) {
            this.dir = dir;
            this.len = len;
        }

        @Override
        public String toString() {
            return dir + "," + len + "," + isLong;
        }
    }
}


