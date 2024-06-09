package acmicpc31654;

import java.io.*;
import java.util.*;

/* Adding Trouble
 * https://www.acmicpc.net/problem/31654
 */

public class Main {
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer((new BufferedReader(new InputStreamReader(System.in))).readLine());
        System.out.println((Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) == Integer
                .parseInt(st.nextToken())) ? "correct!" : "wrong!");
    }
}