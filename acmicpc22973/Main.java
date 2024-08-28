package acmicpc22973;

import java.io.*;

/* TODO
*/

public class Main {
    static int count = -1;
    static long N;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Math.abs(Long.parseLong(bf.readLine()));
        
        checkNext(N, 1, 1);
        System.out.println(count);
    }
    private static void checkNext(long n, long jump, int cnt) {
        // System.out.println(n + " " + jump + " "+ count);
        if (count != -1) {
            return;
        }
        long nextN = n + jump;
        if(nextN == 0) {
            count = cnt;
            return;
        } else {
            if (Math.abs(N) > jump * 2) {
                checkNext(nextN, jump * 2, cnt + 1);
            }
        }
        nextN = n - jump;
        if(nextN == 0) {
            count = cnt;
            return;
        } else {
            if (Math.abs(N) > jump * 2) {
                checkNext(nextN, jump * 2, cnt + 1);
            }
        }
    }
}
