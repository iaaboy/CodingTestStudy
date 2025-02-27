package acmicpc11008;

import java.io.*;
import java.util.*;

/* 복붙의 달인
 * https://www.acmicpc.net/problem/11008
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String a = st.nextToken();
            int old_size = a.length();
            String b = st.nextToken();
            a = a.replace(b, "");
            int result = a.length() + ((old_size - a.length()) / b.length());
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}
