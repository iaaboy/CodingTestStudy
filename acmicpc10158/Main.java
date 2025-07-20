package acmicpc10158;

import java.io.*;
import java.util.*;

/* 개미
 * https://www.acmicpc.net/problem/10158
 * 수학문제 .. for문을 더 간결할게 할 수 있다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        int x = Integer.parseInt(st.nextToken());// 가로
        int y = Integer.parseInt(st.nextToken());// 세로

        int t = Integer.parseInt(bf.readLine());
        int tw = t % (w * 2);
        int th = t % (h * 2);
        boolean dirPlus = true;
        for (int i = 0; i < tw; i++) {
            if (x == w || x == 0) {
                dirPlus = !dirPlus;
            }
            if (dirPlus) {
                x++;
            } else {
                x--;
            }
        }
        dirPlus = true;
        for (int i = 0; i < th; i++) {
            if (y == h || y == 0) {
                dirPlus = !dirPlus;
            }
            if (dirPlus) {
                y++;
            } else {
                y--;
            }
        }
        System.out.println(x + " " + y);
    }
}
