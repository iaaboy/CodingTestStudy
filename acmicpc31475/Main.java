package acmicpc31475;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); // y
        int M = Integer.parseInt(st.nextToken()); // x

        String s = bf.readLine();

        int[][] arr = new int[N][M];
        int x = 0, y = 0;
        int offset = 1;
        int count = N;
        int index = 1;
        boolean isVertical = true;
        if (s.charAt(0) == 'U') {
            // y = 0;
            x = M / 2;
        } else if (s.charAt(0) == 'D') {
            y = N - 1;
            x = M / 2;
            offset = -1;
        } else if (s.charAt(0) == 'L') {
            y = N / 2;
            x = M - 1;
            offset = -1;
            isVertical = false;
            count = M;
        } else if (s.charAt(0) == 'R') {
            y = N / 2;
            // x = 0;
            isVertical = false;
            count = M;
        }
        for (int i = 0; i < count - 1; i++) {
            arr[y][x] = index++;
            if (isVertical) {
                y += offset;
            } else {
                x += offset;
            }
        }
        if (isVertical) {
            y -= offset;
        } else {
            x -= offset;
        }
        printArr(arr);
        int dir = 0;
        for (int i = 0; i < 4; i++) {
            if (dirIndex[i] == s.charAt(0)) {
                dir = i;
                break;
            }
        }
        setNext(arr, y, x, dir /* dir시작 */, index);
    }

    static int[] offsetY = { 0, -1, 0, 1 }; // R, D, L, U
    static int[] offsetX = { 1, 0, -1, 0 };
    static char[] dirIndex = { 'R', 'D', 'L', 'U' };

    private static void setNext(int[][] arr, int nY, int nX, int curOffset, int index) {
        boolean isSet = false;
        if (nY < 0 || nX < 0 || nY >= arr.length || nX >= arr[0].length) {
            if (arr[nY][nX] == 0) {
                isSet = true;
                arr[nY][nX] = index++;
                nY += offsetY[curOffset];
                nX += offsetX[curOffset];
            }
        }
        
        while (true) {
            nY += offsetY[curOffset];
            nX += offsetX[curOffset];
            boolean isOOR = false;
            if (nY < 0 || nX < 0 || nY >= arr.length || nX >= arr[0].length) {
                isOOR = true;
            }
            if (!isOOR && arr[nY][nX] == 0) {
                isSet = true;
                arr[nY][nX] = index++;
            } else {
                if (isSet) {
                    int nextOffset = curOffset + 1;
                    if (nextOffset == 4) {
                        nextOffset = 0;
                    }
                    nX = nX -offsetX[curOffset] + offsetX[nextOffset];
                    nY = nY -offsetY[curOffset] + offsetY[nextOffset];
                    setNext(arr, nY, nX, nextOffset, index);
                    return;
                }
                break;
            }
            // index++;
        }
    }

    private static void printArr(int[][] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println(i + " " + Arrays.toString(arr[i]));
        }
    }
}
