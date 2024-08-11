package acmicpc1157;

import java.io.*;

/* 단어 공부
 * https://www.acmicpc.net/problem/1157
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] cArr = bf.readLine().toCharArray();
        int[] count = new int[26];
        for (int i = 0; i < cArr.length; i++) {
            if (cArr[i] >= 'a' && cArr[i] <= 'z') {
                count[cArr[i] - 'a']++;
            } else {
                count[cArr[i] - 'A']++;
            }
        }
        int maxIdx = 0;
        int maxCount = 1;
        for (int i = 1; i < count.length; i++) {
            if (count[maxIdx] < count[i]) {
                maxIdx = i;
                maxCount = 1;
            } else if (count[maxIdx] == count[i]) {
                maxCount++;
            }
        }
        if (maxCount > 1) {
            System.out.println("?");
        } else {
            char result = 'A';
            result += maxIdx;
            System.out.println(result);
        }
    }
}
