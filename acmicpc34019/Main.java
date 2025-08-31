package acmicpc34019;

import java.io.*;

/* [G] Grounded Number
 * https://www.acmicpc.net/problem/34019
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(bf.readLine());
        System.out.println(n%2 == 0? "Yes" : "No");
    }
}
