package acmicpc6550;

import java.io.*;
import java.util.*;

/* 부분 문자열
 * https://www.acmicpc.net/problem/6550
 */

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        while (s.hasNext()) {

            char[] a = s.next().toCharArray();
            char[] b = s.next().toCharArray();

            int bidx = 0;
            int matchCount = 0;
            for (int i = 0; i < a.length; i++) {
                for (int j = bidx; j < b.length; j++) {
                    if (a[i] == b[j]) {
                        bidx = j + 1;
                        matchCount++;
                        break;
                    }
                }
            }
            if (matchCount == a.length) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
