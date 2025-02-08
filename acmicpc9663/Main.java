package acmicpc9663;

import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        boolean visited[] = new boolean[N * N];

        traverse(visited, 0, 0);
    }

    private static void traverse(boolean visited [], int count, int at) {
        if (count == N) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i * N + j]) {
                        System.out.print(i + "," + j + " / ");
                    }
                }
            }
            System.out.println();
            // System.out.println(Arrays.toString(visited));
            return;
        }

        for (int i = at; i < N * N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                traverse(visited, count + 1, i);
                visited[i] = false;
            }
        }
    }
}
