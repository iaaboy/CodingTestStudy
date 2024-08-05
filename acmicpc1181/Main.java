package acmicpc1181;

import java.io.*;
import java.util.*;

/* 단어 정렬 
 * https://www.acmicpc.net/problem/1181
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Set<String> words1 = new HashSet<>();
        for (int i = 0; i < N; i++) {
            words1.add(bf.readLine());
        }
        String[] words = new String[words1.size()];
        int i = 0;
        Integer[] idx = new Integer[words1.size()];
        for (String s : words1) {
            words[i] = s;
            idx[i] = i;
            i++;
        }
        Arrays.sort(idx, (a, b) -> {
            if (words[a].length() == words[b].length()) {
                return words[a].compareTo(words[b]);
            } else
                return words[a].length() - words[b].length();
        });

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < idx.length; j++) {
            sb.append(words[idx[j]] + "\n");
        }
        System.out.print(sb);
    }
}
