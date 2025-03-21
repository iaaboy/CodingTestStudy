package acmicpc1361;

import java.io.*;
import java.util.*;

/* 두 스트링 마스크
 * https://www.acmicpc.net/problem/1361
별을 word*2 사이즈까지 하나씩 추가하면서 두 단어를 비교. 같으면 합쳐진 단어를 print.
 */

public class Main {
    static int[] cities;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String a = bf.readLine();
        String b = bf.readLine();
        if (b.length() > a.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        String result = "-1";
        for (int i = -1; i <= a.length(); i++) {
            boolean isSame = checkDiff(a, b, i);
            if (isSame) {
                result = combineWord(a, b, i);
                break;
            }
        }
        System.out.println(result);
    }

    private static String combineWord(String a, String b, int starCount) {
        if (starCount <= 0) {
            return a.replace("*", "");
        }
        a = a.replace("*", new StringBuilder("*".repeat(starCount)));
        b = b.replace("*", new StringBuilder("*".repeat(a.length() - b.length() + 1)));
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != '*') {
                result.append(a.charAt(i));
            } else if (b.charAt(i) != '*') {
                result.append(b.charAt(i));
            }
        }
        return result.toString();
    }

    private static boolean checkDiff(String s1, String s2, int starCount) {
        if (starCount == 0) {
            if (s1.length() == s2.length()) {
                s1 = s1.replace("*", "");
            }
            s2 = s2.replace("*", "");
            if (s2.isEmpty()) {
                return true;
            }
            return checkDiff(s1.toCharArray(), s2.toCharArray());
        }
        StringBuilder star1;
        if (starCount != -1) {
            star1 = new StringBuilder("*".repeat(starCount));
        } else {
            star1 = new StringBuilder("");
        }
        s1 = s1.replace("*", star1);
        int s2Count = s1.length() - s2.length() + 1;
        StringBuilder star = new StringBuilder("*".repeat(s2Count));
        s2 = s2.replace("*", star);
        return checkDiff(s1.toCharArray(), s2.toCharArray());
    }

    private static boolean checkDiff(char[] c1, char[] c2) {
        // System.out.println("checkDiff: " + Arrays.toString(c1) + ".." +
        // Arrays.toString(c2));
        if (c1.length != c2.length) {
            return false;
        }
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i] && c1[i] != '*' && c2[i] != '*') {
                return false;
            }
        }
        return true;
    }
}