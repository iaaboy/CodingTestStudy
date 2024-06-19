package acmicpc1316;

import java.io.*;

/* 그룹 단어 체커
 * https://www.acmicpc.net/problem/1316
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int gWordCount = 0;
        for (int i = 0; i < N; i++) {
            char[] cArr = bf.readLine().toCharArray();
            boolean[] appearance = new boolean[26];
            boolean isGroupWord = true;
            for (int j = 0; j < cArr.length; j++) {
                if (j == 0) {
                    appearance[cArr[j] - 'a'] = true;
                    continue;
                }
                if (cArr[j - 1] == cArr[j])
                    continue;
                if (!appearance[cArr[j] - 'a']) {
                    appearance[cArr[j] - 'a'] = true;
                } else {
                    isGroupWord = false;
                    break;
                }
            }
            if (isGroupWord) {
                gWordCount++;
            }
        }
        System.out.println(gWordCount);
    }
}
