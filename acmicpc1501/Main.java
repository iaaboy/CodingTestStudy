package acmicpc1501;

import java.io.*;
import java.util.*;

/* 영어 읽기
 * https://www.acmicpc.net/problem/1501
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        HashMap<String, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < N; i++) {
            char[] str = bf.readLine().toCharArray();
            String converted = convertToDic(str);
            if (!dictionary.containsKey(converted)) {
                dictionary.put(converted, 1);
            } else {
                dictionary.put(converted, dictionary.get(converted) + 1);
            }
        }
        // System.out.println(dictionary);
        int M = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int answer = 0;
            String str = bf.readLine();
            String[] words = str.split(" ");
            for (int j = 0; j < words.length; j++) {
                if (words[j].length() > 0) {
                    String converted = convertToDic(words[j].toCharArray());
                    if (dictionary.containsKey(converted)) {
                        if (answer == 0) {
                            answer += dictionary.get(converted);
                        } else {
                            answer *= dictionary.get(converted);
                        }

                    }
                }
            }
            sb.append(answer + "\n");
        }
        System.out.println(sb.toString());
        bf.close();
        dictionary.clear();
    }

    private static String convertToDic(char[] str) {
        int[] upper = new int[28];
        int[] lower = new int[28];
        StringBuilder sb = new StringBuilder();
        if (str.length == 1) {
            sb.append(str[0]);
            return sb.toString();
        } else if (str.length == 2) {
            sb.append(str[1]);
            sb.append(str[0]);
            return sb.toString();
        }

        for (int i = 1; i < str.length - 1; i++) {
            if (str[i] >= 'a' && str[i] <= 'z') {
                lower[str[i] - 'a']++;
            } else {
                upper[str[i] - 'A']++;
            }
        }

        sb.append(str[0]);
        for (int i = 0; i < lower.length; i++) {
            if (lower[i] > 0) {
                char ch = 'a';
                ch += i;
                sb.append(ch + Integer.toString(lower[i]));
            }
            if (upper[i] > 0) {
                char ch = 'A';
                ch += i;
                sb.append(ch + Integer.toString(upper[i]));
            }
        }
        sb.append(str[str.length - 1]);
        return sb.toString();
    }
}
