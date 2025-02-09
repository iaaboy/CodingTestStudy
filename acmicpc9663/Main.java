package acmicpc9663;

import java.io.*;

/* N-Queen
 * https://www.acmicpc.net/problem/9663
 */

public class Main {
    static int N;
    static boolean visited[];
    static int board[];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        visited = new boolean[N];
        board = new int[N];

        traverse(0);
        System.out.println(countTT);
    }

    static int countTT = 0;

    private static void traverse(int count) {
        if (count == N) {
            countTT++;
            return;
        }

        for (int i = 0; i < N; i++) {
            board[count] = i;
            if (promising(count)) {
                traverse(count + 1);
            }
        }
    }

    static boolean promising(int count) {
        for (int i = 0; i < count; i++) {
            if (board[count] == board[i] || count - i == Math.abs(board[count] - board[i])) {
                return false;
            }
        }
        return true;
    }
}
