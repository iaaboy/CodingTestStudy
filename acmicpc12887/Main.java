package acmicpc12887;

import java.io.*;

/* 경로 게임
 * https://www.acmicpc.net/problem/12887
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        char[][] arr = new char[2][N];
        arr[0] = bf.readLine().toCharArray();
        arr[1] = bf.readLine().toCharArray();
        int dotCount = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == '.') {
                    dotCount++;
                }
            }
        }
        int pathCount = Integer.MAX_VALUE;
        if (arr[0][0] == '.') {
            pathCount = checkRoad(arr, 0);
        }
        int pathCount2 = Integer.MAX_VALUE;
        if (arr[1][0] == '.') {
            pathCount2 = checkRoad(arr, 1);
        }
        System.out.println(dotCount - Math.min(pathCount, pathCount2));
    }

    private static int checkRoad(char[][] arr, int prev) {
        int count = 1;
        for (int i = 1; i < arr[0].length; i++) {
            if (arr[prev][i] == '#') {
                count += 2;
                prev = (prev + 1) % 2;
            } else {
                count++;
            }
        }
        return count;
    }
}
