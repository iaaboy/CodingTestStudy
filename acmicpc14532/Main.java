package acmicpc14532;

import java.io.*;
import java.util.*;

/*
 * 풀이중
 */

public class Main {
    static int N;
    static int[][] num;
    static int xMax, xMin, yMax, yMin;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        num = new int[N][N];
        boolean [] colorHandled = new boolean [11];
        for (int i = 0; i < N; i++) {
            char[] nChar = bf.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                num[i][j] = nChar[j] - '0';
                colorHandled[num[i][j]] = true;
            }
        }
        int latsUpdated = 0;
        boolean haItem = true;
        while (haItem) {
            latsUpdated = 0;
            ArrayList<Integer> eraseCandidate = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                if (colorHandled[i]) {
                    xMin = Integer.MAX_VALUE;
                    xMax = -1;
                    yMin = Integer.MAX_VALUE;
                    yMax = -1;
                    getPoint(i);
                    if (checkSquare(xMin, yMin, xMax, yMax, i)) {
                        System.out.println("Its square: " + i);
                        colorHandled[i] = false;
                        latsUpdated++;
                        eraseCandidate.add(i);
                    }
                }
            }
            setSqare(eraseCandidate);
            
            // System.out.println();
            if (eraseCandidate.isEmpty()) {
                haItem = false;
                break;
            }
            haItem = false;
            for (int i = 1; i < colorHandled.length; i++) {
                if (colorHandled[i]) {
                    haItem = true;
                    break;
                }
            }
        }
        System.out.println(latsUpdated);
    }

    private static void setSqare(ArrayList<Integer> eraseCandidate) {
        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < N; j++) {
                if (eraseCandidate.contains(num[i][j])) {
                    num[i][j] = -1;
                }
            }
        }
    }

    private static boolean checkSquare(int x1, int y1, int x2, int y2, int n) {
        for (int i = y1; i <= y2; i++) {
            for (int j = x1; j <= x2; j++) {
                if (num[i][j] != n && num[i][j] != -1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void getPoint(int n) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (num[i][j] == n) {
                    xMin = Math.min(xMin, j);
                    yMin = Math.min(yMin, i);
                    xMax = Math.max(xMax, j);
                    yMax = Math.max(yMax, i);
                }
            }
        }
    }
}
