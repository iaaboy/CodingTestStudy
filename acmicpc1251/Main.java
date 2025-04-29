package acmicpc1251;

import java.io.*;
import java.util.*;

/* 단어 나누기
 * https://www.acmicpc.net/problem/1251
 */

public class Main {
    static Set<String> dict = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String inStr = bf.readLine();
        makeDict(inStr);
        ArrayList<String> dictList = new ArrayList<>(dict);
        dictList.sort(null);
        System.out.println(dictList.get(0));
    }

    private static void makeDict(String inStr) {
        for (int first = 1; first < inStr.length(); first++) {
            for (int second = first + 1; second < inStr.length(); second++) {
                // System.out.println(first + "," + second);
                StringBuilder a = new StringBuilder(inStr.substring(0, first)).reverse();
                StringBuilder b = new StringBuilder(inStr.substring(first, second)).reverse();
                StringBuilder c = new StringBuilder(inStr.substring(second, inStr.length())).reverse();
                dict.add(a.toString() + b.toString() + c.toString());
            }
        }
    }
}
