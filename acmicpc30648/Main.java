package acmicpc30648;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(bf.readLine());

        int time = 0;
        boolean[][] map = new boolean[R][R];

        map[a][b] = true;
        while (true) {
            time++;

            if (a + b + 2 < R) {
                a++;
                b++;
            } else {
                a >>= 1;
                b >>= 1;
            }

            if (map[a][b]) {
                break;
            }
            map[a][b] = true;
        }
        System.out.println(time);
    }
}
