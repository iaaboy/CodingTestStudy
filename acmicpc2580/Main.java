package acmicpc2580;

import java.io.*;
import java.util.*;

/*
 * 풀이중
 */

public class Main {
    static int N = 9;
    static int[][] arr = new int[N][N];
    static boolean[][][] candi = new boolean[N][N][N + 1];
    static int[][] filledCount = new int[N][N];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                if (num != 0) {
                    updateCandidate(i, j, num);
                }
            }
        }
        printCandi("Initial state");
        while (true) {
            boolean handled = false;
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (filledCount[y][x] == 8 && arr[y][x] == 0) {
                        handled = true;
                        int num = getNum(y, x);
                        arr[y][x] = num;
                        updateCandidate(y, x, num);

                        printCandi("handled: " + y + "," + x);
                        System.out.println();
                        for (int i = 0; i < N; i++) {
                            System.out.println(Arrays.toString(arr[i]).replaceAll("[\\[\\],]", ""));
                        }
                        System.out.println();
                    }

                }
            }
            if (!handled) {
                int handleX = 0;
                int handleY = 0;
                for (int y = 0; y < N; y++) {
                    for (int x = 0; x < N; x++) {
                        int leftCount = 9;
                        if (arr[y][x] == 0 && filledCount[y][x] < leftCount) {
                            handleY = y;
                            handleX = x;
                            leftCount = filledCount[y][x];
                            handled = true;
                        }
                    }
                }
                if (handled) {
                    int num = getNum(handleY, handleX);
                    handled = true;
                    arr[handleY][handleX] = num;
                    updateCandidate(handleY, handleX, num);

                    System.out.println();
                    printCandi("handled: " + handleY + "," + handleX);
                    System.out.println();
                    for (int i = 0; i < N; i++) {
                        System.out.println(Arrays.toString(arr[i]).replaceAll("[\\[\\],]", ""));
                    }
                } else {
                    break;
                }
            }
        }
        // printCandi("result");
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(arr[i]).replaceAll("[\\[\\],]", ""));
        }
    }

    private static int getNum(int y, int x) {
        for (int i = 1; i <= N; i++) {
            if (!candi[y][x][i]) {
                return i;
            }
        }
        return -1;
    }

    private static void updateCandidate(int y, int x, int num) {
        // 가로
        int nx = x - (x % 3) + 1;
        int ny = y - (y % 3) + 1;
        for (int i = 0; i < N; i++) {
            if (!candi[y][i][num]) {
                candi[y][i][num] = true;
                filledCount[y][i]++;
            }
            if (!candi[i][x][num]) {
                candi[i][x][num] = true;
                filledCount[i][x]++;
            }
            if (!candi[ny + dy[i]][nx + dx[i]][num]) {
                candi[ny + dy[i]][nx + dx[i]][num] = true;
                filledCount[ny + dy[i]][nx + dx[i]]++;
            }

        }
    }

    private static void printState(String msg) {
        // System.out.println(msg);
        // for (int i = 0; i < N; i++) {
        // for (int j = 0; j < N; j++) {
        // System.out.print(arr[i][j] + " ");
        // }
        // System.out.println();
        // }
    }

    private static void printCandi(String msg) {
        System.out.println(msg);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0) {
                    sb.append(i + " " + j + "(");
                    sb.append(filledCount[i][j] + ") : ");
                    for (int j2 = 1; j2 <= N; j2++) {
                        if (!candi[i][j][j2]) {
                            sb.append(j2 + " ");
                        }
                    }
                    sb.append("\n");
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                sb.append(filledCount[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static int[] dy = { 0, 0, -1, 1, 1, 0, -1, -1, -1 };
    static int[] dx = { 0, -1, 1, 0, 1, 1, 1, 0, -1 };
}
/*
6 5 4 1 3 7 2 0 9
2 1 3 9 8 5 7 4 6
8 7 9 2 4 6 1 3 5
5 3 2 4 1 9 0 7 8
1 4 0 8 7 2 5 6 3
7 9 8 5 6 3 4 1 2
4 2 1 3 0 0 9 8 7
3 0 0 7 2 1 6 5 4
9 8 7 6 5 4 3 2 1
 */