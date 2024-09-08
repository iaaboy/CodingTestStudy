package acmicpc1599;

import java.io.*;
import java.util.*;

/* 민식어 
 * https://www.acmicpc.net/problem/1599
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        char[][] words = new char[N][];
        Integer[] index = new Integer[N];
        // a b k d e g h i l m n ng o p r s t u w y
        char[] keys = { 'a', 'b', 'k', 'd', 'e', 'g', 'h', 'i', 'l', 'm', 'n',
                'z'/* ng */, 'o', 'p', 'r', 's', 't',
                'u', 'w', 'y' };
        Map<Character, Integer> iMap = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            iMap.put(keys[i], i + 1);

        }
        for (int i = 0; i < N; i++) {
            words[i] = bf.readLine().replace("ng", "z").toCharArray();
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> {
            int n = Math.min(words[a].length, words[b].length);
            for (int i = 0; i < n; i++) {
                if (iMap.get(words[a][i]) > iMap.get(words[b][i])) {
                    return 1;
                } else if (iMap.get(words[a][i]) < iMap.get(words[b][i])) {
                    return -1;
                }
            }
            return words[a].length - words[b].length;
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String word = new String(words[index[i]]);
            // System.out.println(word.replace("z", "ng"));
            sb.append(word.replace("z", "ng") + "\n");
        }
        System.out.println(sb);
    }
}
