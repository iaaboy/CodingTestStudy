package acmicpc11723;

import java.io.*;
import java.util.*;

/* 집합
 * https://www.acmicpc.net/problem/11723
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BitSet bit = new BitSet();
        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String command = st.nextToken();
            if (command.contentEquals("add")) {
                bit.set(Integer.parseInt(st.nextToken()));
            } else if (command.contentEquals("remove")) {
                bit.clear(Integer.parseInt(st.nextToken()));
            } else if (command.contentEquals("check")) {
                int result = bit.get(Integer.parseInt(st.nextToken())) ? 1 : 0;
                sb.append(result + "\n");
            } else if (command.contentEquals("toggle")) {
                bit.flip(Integer.parseInt(st.nextToken()));
            } else if (command.contentEquals("all")) {
                bit.set(1, 21, true);
            } else if (command.contentEquals("empty")) {
                bit.set(1, 21, false);
            }
        }
        System.out.print(sb);
    }
}
