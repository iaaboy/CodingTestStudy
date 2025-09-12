package acmicpc30641;

import java.io.*;
import java.util.*;

/* 회문 끝말잇기
 * https://www.acmicpc.net/problem/30641
 */

public class Main {
    static Set<String> circular = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int L = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());

        long div = 1000000007L;
        boolean hWin = false;
        if (L == 1 && U == 1) {
            hWin = true;
        } else if (L == 2) {
            hWin = true;
        }
        String winner = hWin ? "H" : "A";

        long count = 0;
        long adds = 1;
        for (int i = 1; i <= U; i++) {
            if (i < 3) {
                // count++;
            } else {
                if (i % 2 == 1) {
                    adds *= 26;
                    adds %= div;
                }
            }
            if (L <= i) {
                count += adds;
                count %= div;
            }
            // System.out.println(i +":" + adds);

        }
        System.out.println(winner + "\n" + count);
    }

    private static void getCircular(char[] c, int depth, int count) {
        if (depth == count) {
            circular.add(new String(c));
            return;
        }
        for (int i = 0; i < 26; i++) {
            c[depth] = (char) ('A' + i);
            if (c.length / 2 <= depth) {
                if (c[c.length - depth - 1] == c[depth]) {
                    getCircular(c, depth + 1, count);
                }
            } else {
                getCircular(c, depth + 1, count);
            }
        }
    }
}
