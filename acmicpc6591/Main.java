package acmicpc6591;

import java.io.*;
import java.util.*;

/* 이항 쇼다운
 * https://www.acmicpc.net/problem/6591
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            Long n = Long.parseLong(st.nextToken());
            Long r = Long.parseLong(st.nextToken());
            if (n == 0 && r == 0) {
                System.out.println(sb.toString());
                return;
            }
            long result = 1;
            if (r > n - r) {
                r = n - r;
            }

            for (long i = 1; i <= r; i++) {
                result *= n--;
                result /= i;
            }
            sb.append(result + "\n");
        }
    }
}