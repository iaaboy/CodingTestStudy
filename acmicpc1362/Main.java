package acmicpc1362;

import java.io.*;
import java.util.*;

/* 펫
 * https://www.acmicpc.net/problem/1362
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int O = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int count = 1;
        StringBuilder sb = new StringBuilder();
        while (O != 0 && W != 0) {
            st = new StringTokenizer(bf.readLine());
            char cmd = st.nextToken().charAt(0);
            int n = Integer.parseInt(st.nextToken());
            boolean isBankrupt = false;
            while (cmd != '#' && n != 0) {
                if (cmd == 'F') {
                    W += n;
                } else {
                    W -= n;
                }
                if (W <= 0) {
                    isBankrupt = true;
                }
                st = new StringTokenizer(bf.readLine());
                cmd = st.nextToken().charAt(0);
                n = Integer.parseInt(st.nextToken());
            }
            boolean isHappy = O / 2 < W && O * 2 > W;
            if (isBankrupt) {
                sb.append(count + " RIP").append("\n");
            } else if (isHappy) {
                sb.append(count + " :-)").append("\n");
            } else {
                sb.append(count + " :-(").append("\n");
            }
            count++;

            st = new StringTokenizer(bf.readLine());
            O = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
        }
        System.out.print(sb);
    }
}
