package acmicpc32942;

import java.io.*;
import java.util.*;

/* 그래프와 그래프
 * https://www.acmicpc.net/problem/32942
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        List<List<Integer>> coord = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            coord.add(new ArrayList<>());
        }

        for (int x = 1; x <= 10; x++) {
            for (int y = 1; y <= 10; y++) {
                if (A * x + B * y == C) {
                    coord.get(x).add(y);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            if (!coord.get(i).isEmpty()) {
                Collections.sort(coord.get(i));
                for (int dest : coord.get(i)) {
                    sb.append(dest + " ");
                }
            } else {
                sb.append("0");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}