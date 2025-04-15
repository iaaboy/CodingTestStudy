package acmicpc12437;

import java.io.*;
import java.util.*;

/* 새로운 달력 (Small)
 * https://www.acmicpc.net/problem/12437
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int totalMon = Integer.parseInt(st.nextToken());
            int dayPerMon = Integer.parseInt(st.nextToken());
            int dayPerWeek = Integer.parseInt(st.nextToken());

            int line = 0;
            int weekDay = 0;
            for (int m = 0; m < totalMon ; m++) {
                for (int j = 0; j < dayPerMon; j++) {
                    if (weekDay % dayPerWeek == 0) {
                        weekDay = 0;
                        line++;
                    }
                    weekDay++;
                }
                if (weekDay % dayPerWeek != 0) {
                    line++;
                }
            }
            if (weekDay != dayPerWeek) {
                line--;
            }
            // System.out.println(weekDay + " " + dayPerWeek);
            sb.append("Case #" + i +": " + line + "\n");
        }
        System.out.print(sb);
    }
}
