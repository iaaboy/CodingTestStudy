package acmicpc1543;

import java.io.*;

/* 문서 검색
 * https://www.acmicpc.net/problem/1543
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] strA = bf.readLine().toCharArray();
        char[] strB = bf.readLine().toCharArray();
        int matchcount = 0;
        for (int i = 0; i <= strA.length - strB.length; i++) {
            boolean isMatch = true;
            for (int j = 0; j < strB.length; j++) {
                if (strA[i + j] != strB[j]) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                i += strB.length - 1;
                // System.out.println(i);
                i = Math.min(i, strA.length - strB.length);
                matchcount++;
            }
        }
        System.out.println(matchcount);
    }
}
