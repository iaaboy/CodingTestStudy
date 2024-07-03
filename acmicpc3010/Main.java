package acmicpc3010;

import java.io.*;

/* 페그
 * https://www.acmicpc.net/problem/3010
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[][] cArr = new char[7][7];
        for (int i = 0; i < 7; i++) {
            cArr[i] = bf.readLine().toCharArray();
        }

        int sum = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < cArr.length; j++) {
                if (cArr[i][j] == '.') {
                    int c = checkCount(cArr, i, j);
                    // System.out.println(i + "," + j + " : " + c);
                    sum += c;
                }
            }
        }
        System.out.println(sum);
    }

    private static int checkCount(char[][] cArr, int y, int x) {
        int sum = 0;
        int nX = x + 1;
        int nXX = x + 2;
        if (nX < 7 && nXX < 7) {
            if (cArr[y][nX] == 'o' && cArr[y][nXX] == 'o') {
                sum++;
            }
        }
        nX = x - 1;
        nXX = x - 2;
        if (nX >= 0 && nXX >= 0) {
            if (cArr[y][nX] == 'o' && cArr[y][nXX] == 'o') {
                sum++;
            }
        }
        int nY = y + 1;
        int nYY = y + 2;
        if (nY < 7 && nYY < 7) {
            if (cArr[nY][x] == 'o' && cArr[nYY][x] == 'o') {
                sum++;
            }
        }
        nY = y - 1;
        nYY = y - 2;
        if (nY >= 0 && nYY >= 0) {
            if (cArr[nY][x] == 'o' && cArr[nYY][x] == 'o') {
                sum++;
            }
        }
        return sum;
    }
}
