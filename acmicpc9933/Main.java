package acmicpc9933;

import java.io.*;
import java.util.*;

/* 민균이의 비밀번호
 * https://www.acmicpc.net/problem/9933
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Set <String> names = new HashSet<>();
        for (int i = 0; i < N; i++) {
            names.add(bf.readLine());
        }
        for (String n : names) {
            if (names.contains(new StringBuffer(n).reverse().toString())) {
                System.out.println(n.length() + " " + n.charAt(n.length() / 2));
                break;
            }
        }
    }
}
