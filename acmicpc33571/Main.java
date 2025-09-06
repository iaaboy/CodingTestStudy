package acmicpc33571;

import java.io.*;
import java.util.*;

/* 구멍
 * https://www.acmicpc.net/problem/33571
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] inStr = bf.readLine().toCharArray();
        HashMap<Character, Integer> chMap = new HashMap<>();
        chMap.put('A', 1);
        chMap.put('a', 1);
        chMap.put('B', 2);
        chMap.put('b', 1);
        chMap.put('D', 1);
        chMap.put('d', 1);
        chMap.put('e', 1);
        chMap.put('g', 1);
        chMap.put('O', 1);
        chMap.put('o', 1);
        chMap.put('P', 1);
        chMap.put('p', 1);
        chMap.put('Q', 1);
        chMap.put('q', 1);
        chMap.put('R', 1);
        chMap.put('@', 1);
        int count = 0;
        for (char ch : inStr) {
            count += chMap.getOrDefault(ch, 0);
        }
        System.out.println(count);
    }
}
