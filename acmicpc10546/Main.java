package acmicpc10546;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

/* 배부른 마라토너
 * https://www.acmicpc.net/problem/10546
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        HashMap<String, Integer> paricipant = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String name = bf.readLine();
            paricipant.put(name, paricipant.getOrDefault(name, 0) + 1);
        }
        for (int i = 0; i < N - 1; i++) {
            String name = bf.readLine();
            paricipant.put(name, paricipant.getOrDefault(name, 0) + 1);
        }
        for (Entry<String, Integer> entrySet : paricipant.entrySet()) {
            if (entrySet.getValue() % 2 == 1) {
                System.out.println(entrySet.getKey());
                break;
            }
        }
    }
}
