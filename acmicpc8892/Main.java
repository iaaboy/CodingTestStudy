package acmicpc8892;

import java.io.*;

/* 팰린드롬
 * https://www.acmicpc.net/problem/8892
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(bf.readLine());
            String[] words = new String[N];
            for (int i = 0; i < N; i++) {
                words[i] = bf.readLine();
            }
            boolean hasPelin = false;
            loop: for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (checkPelin(words[i], words[j])) {
                        sb.append(words[i] + words[j]).append("\n");
                        hasPelin = true;
                        break loop;
                    }
                }
            }
            if (!hasPelin) {
                sb.append(0).append("\n");
            }
        }
        System.out.print(sb);
    }

    private static boolean checkPelin(String a, String b) {
        char[] word = (a + b).toCharArray();
        for (int i = 0; i < word.length / 2; i++) {
            if (word[i] != word[word.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
