package acmicpc34408;

import java.io.*;
import java.util.*;

/* 문자열 분해기
 * https://www.acmicpc.net/problem/34408
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char [] base = bf.readLine().toCharArray();
        char [] target = bf.readLine().toCharArray();
        int [] count = new int[26];
        for (int i = 0; i < base.length; i++) {
            count[base[i] - 'A'] ++;
        }
        for (int i = 0; i < target.length; i++) {
            count[target[i] - 'A']--;
            if (count[target[i] - 'A'] < 0) {
                System.out.println("NEED FIX");
                return;
            }
        }
        System.out.println("OK");
    }
}
