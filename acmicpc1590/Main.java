package acmicpc1590;

import java.io.*;
import java.util.*;

/* 캠프가는 영식
 * https://www.acmicpc.net/problem/1590
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int minWait = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int wait = getWait(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), T);
            if (wait != -1) {
                minWait = Math.min(minWait, wait);
            }
        }
        minWait = minWait == Integer.MAX_VALUE ? -1 : minWait;
        System.out.println(minWait);
    }

    private static int getWait(int start, int term, int count, int targetTime) {
        for (int i = 0; i < count; i++) {
            if (start + i * term >= targetTime) {
                return start + i * term - targetTime;
            }
        }

        return -1;
    }
}
