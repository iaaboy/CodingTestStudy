package acmicpc20291;

import java.io.*;
import java.util.*;

/* 파일 정리
 * https://www.acmicpc.net/problem/20291
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        HashMap<String, Integer> shelf = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String[] book = bf.readLine().split("\\.");
            shelf.put(book[1], shelf.getOrDefault(book[1], 0) + 1);
        }
        ArrayList<String> ext = new ArrayList<>(shelf.keySet());
        ext.sort(null);
        StringBuilder sb = new StringBuilder();
        for (String ex : ext) {
            sb.append(ex).append(" ").append(shelf.get(ex)).append("\n");
        }
        System.out.print(sb);
    }
}
