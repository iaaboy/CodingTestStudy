package acmicpc12919;

import java.io.*;

/* A와 B 2
 * https://www.acmicpc.net/problem/12919
 */

public class Main {
    static char[] S;
    static boolean canSwitch = false;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        S = bf.readLine().toCharArray();
        String T = bf.readLine();
        checkNext(T);
        System.out.println(canSwitch ? "1" : "0");
    }

    private static void checkNext(String t) {
        if (canSwitch) {
            return;
        }
        if (S.length == t.length()) {
            char[] tc = t.toCharArray();
            for (int i = 0; i < tc.length; i++) {
                if (tc[i] != S[i]) {
                    return;
                }
            }
            canSwitch = true;
            return;
        }

        // A추가
        // 마지막에 A인 경우 빼기
        if (t.charAt(t.length() - 1) == 'A') {
            String tPrime = t.substring(0, t.length() - 1);
            checkNext(tPrime);
        }

        // B를 추가하고 뒤집기
        // 처음이 B인 경우, 나머지만 취해서 뒤집기
        if (t.charAt(0) == 'B') {
            StringBuilder tB = new StringBuilder(t.substring(1, t.length()));
            String tPrime2 = tB.reverse().toString();
            checkNext(tPrime2);
        }
    }
}
