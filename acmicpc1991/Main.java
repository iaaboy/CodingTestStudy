package acmicpc1991;

import java.io.*;
/* 트리 순회
 * https://www.acmicpc.net/problem/1991
 */

public class Main {
    static int LEFT = 0;
    static int RIGHT = 1;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[][] node = new int[N][2]; // 0 left, 1 right
        for (int i = 0; i < N; i++) {
            char[] arr = bf.readLine().toCharArray();
            int me = arr[0] - 'A';
            node[me][LEFT] = arr[2] == '.' ? -1 : arr[2] - 'A';
            node[me][RIGHT] = arr[4] == '.' ? -1 : arr[4] - 'A';
        }

        for (int i = 0; i < 3; i++) {
            traversePre(node, 0, i);
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void traversePre(int[][] node, int current, int type) {
        if (type == 0) {
            sb.append((char) ('A' + current));
        }
        if (node[current][LEFT] != -1) {
            traversePre(node, node[current][LEFT], type);
        }
        if (type == 1) {
            sb.append((char) ('A' + current));
        }
        if (node[current][RIGHT] != -1) {
            traversePre(node, node[current][RIGHT], type);
        }
        if (type == 2) {
            sb.append((char) ('A' + current));
        }
    }
}
