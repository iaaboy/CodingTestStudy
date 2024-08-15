package acmicpc28431;

import java.io.*;
import java.util.*;

/* 양말 짝 맞추기
 * https://www.acmicpc.net/problem/28431
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> mMap = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            int n = Integer.parseInt(bf.readLine());
            if (!mMap.containsKey(n)) {
                mMap.put(n, 1);
            } else {
                mMap.put(n, mMap.get(n) + 1);
            }
        }
        for (int key : mMap.keySet()) {

            if (mMap.get(key) % 2 == 1) {
                System.out.println(key);
            }
        }
    }
}
