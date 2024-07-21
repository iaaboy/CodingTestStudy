package acmicpc3009;

import java.io.*;
import java.util.*;

/* 네 번째 점
 * https://www.acmicpc.net/problem/3009
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        HashMap<Integer, Integer> xMap = new HashMap<>();
        HashMap<Integer, Integer> yMap = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            if (xMap.containsKey(x)) {
                xMap.put(x, 2);
            } else {
                xMap.put(x, 1);
            }
            int y = Integer.parseInt(st.nextToken());
            if (yMap.containsKey(y)) {
                yMap.put(y,  2);
            } else {
                yMap.put(y, 1);
            }
        }
        // System.out.println(xMap);
        // System.out.println(yMap);
        int resultX = 0;
        for (Integer key : xMap.keySet()) {
            if (xMap.get(key) == 1) {
                resultX = key;
            }
        }
        int resultY = 0;
        for (Integer key : yMap.keySet()) {
            if (yMap.get(key) == 1) {
                resultY = key;
            }
        }
        System.out.println(resultX + " " + resultY);
    }
}
