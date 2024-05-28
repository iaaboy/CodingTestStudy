package acmicpc31867;

import java.io.*;
import java.util.*;

/* 홀짝홀짝
 * https://www.acmicpc.net/problem/31867
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        char[] cList = bf.readLine().toCharArray();
        HashMap<Character, Integer> chMap = new HashMap<>();
        chMap.put('1', 1);
        chMap.put('3', 1);
        chMap.put('5', 1);
        chMap.put('7', 1);
        chMap.put('9', 1);
        chMap.put('2', 0);
        chMap.put('4', 0);
        chMap.put('6', 0);
        chMap.put('8', 0);
        chMap.put('0', 0);
        int[] count = new int[2];

        for (int i = 0; i < N; i++) {
            count[chMap.get(cList[i])]++;
        }

        String result = "";
        if (count[0] == count[1]) {
            result = "-1";
        } else if (count[0] > count[1]) {
            result = "0";
        } else {
            result = "1";
        }
        System.out.println(result);
    }
}
