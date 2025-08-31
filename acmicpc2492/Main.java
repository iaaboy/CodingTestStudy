package acmicpc2492;

import java.io.*;
import java.util.*;

/*
 * later
 */

public class Main {
    static int[][] coord;
    static Integer[] xAligned;
    static Integer[] yAligned;
    static int K, T;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        coord = new int[T][2];
        xAligned = new Integer[T];
        yAligned = new Integer[T];

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(bf.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            coord[i][0] = X;
            coord[i][1] = Y;
            xAligned[i] = i;
            yAligned[i] = i;
        }
        Arrays.sort(xAligned, (a, b) -> {
            if (coord[a][0] == coord[b][0]) {
                return coord[a][1] - coord[b][1];
            } else {
                return coord[a][0] - coord[b][0];
            }
        });

        int maxCount = 0;
        int maxIndex = 0;
        for (int xi = 0; xi < xAligned.length; xi++) {
            int count = getCount(xi);
            System.out.println("xi: " + xAligned[xi] + " : " + count);
            if (count >= maxCount) {
                maxCount = count;
                maxIndex = xi;
            }
        }
        System.out.println(coord[maxIndex][1] + " " + coord[maxIndex][0] + "\n" + maxCount);
    }

    private static int getCount(int startX) {
        int startCoord = coord[xAligned[startX]][0];
        int maxCoord = coord[xAligned[startX]][0] + K;
        int count = 0;
        for (int i = startX; i < xAligned.length; i++) {
            int ix = xAligned[i];
            if (coord[ix][0] > maxCoord) {
                break;
            }
            if (coord[ix][1] <= maxCoord && coord[ix][1] >= startCoord) {
                count++;
            }
        }
        return count;
    }
}
