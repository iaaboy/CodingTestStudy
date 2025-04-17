package acmicpc25178;

import java.io.*;

/* 두라무리 휴지
 * https://www.acmicpc.net/problem/25178
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        String a = bf.readLine();
        String b = bf.readLine();
        boolean isPW = true;
        // 두 단어의 첫 글자와 마지막 글자는 서로 동일해야 한다.
        if (a.charAt(0) != b.charAt(0) || a.charAt(a.length() - 1) != b.charAt(b.length() - 1)) {
            isPW = false;
        }
        // 각 단어에서 모음(a, e, i, o, u)을 제거한 문자열은 동일해야 한다.
        String filteredA = a.replaceAll("a|e|i|o|u", "");
        String filteredB = b.replaceAll("a|e|i|o|u", "");
        if (!filteredA.contentEquals(filteredB)) {
            isPW = false;
        }
        // if (a.contentEquals(b)) {
        //     isPW = false;
        // }

        // a e i o u 개수 체크
        if (!check(a.toCharArray(), b.toCharArray())) {
            isPW = false;
        }

        if (a.length() != b.length()) {
            isPW = false;
        }

        if (isPW) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean check(char[] a, char[] b) {
        char[] cChar = { 'a', 'e', 'i', 'o', 'u' };
        for (int i = 0; i < cChar.length; i++) {
            int aCount = 0;
            int bCount = 0;
            for (int j = 0; j < a.length; j++) {
                if (a[j] == cChar[i]) {
                    aCount++;
                }
                if (b[j] == cChar[i]) {
                    bCount++;
                }
            }
            if (aCount != bCount) {
                return false;
            }
        }
        return true;
    }
}
