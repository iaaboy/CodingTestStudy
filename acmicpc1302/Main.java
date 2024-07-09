package acmicpc1302;

import java.io.*;
import java.util.*;

/* 베스트셀러
 * https://www.acmicpc.net/problem/1302
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        HashMap<String, Integer> bookMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String inStr = bf.readLine();
            if (!bookMap.containsKey(inStr)) {
                bookMap.put(inStr, 0);
            }
            bookMap.put(inStr, bookMap.get(inStr) + 1);
        }
        int maxCount = 0;
        String maxBook = "";
        for (String key : bookMap.keySet()) {
            if (bookMap.get(key) > maxCount) {
                maxBook = key;
                maxCount = bookMap.get(key);
            } else if (bookMap.get(key) == maxCount) {
                if (key.compareTo(maxBook) < 0) {
                    maxBook = key;
                    maxCount = bookMap.get(key);
                }
            }
        }
        System.out.println(maxBook);
    }
}
