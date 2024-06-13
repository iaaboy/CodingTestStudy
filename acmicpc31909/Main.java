package acmicpc31909;

import java.io.*;
import java.util.*;

/* FOCUS
 * https://www.acmicpc.net/problem/31909
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        HashMap<Integer, Pair> binMap = new HashMap<>();
        for (int i = 0; i <= 7; i++) {
            for (int j = i + 1; j <= 7; j++) {
                if (i == j)
                    continue;
                int binMul = (int) Math.pow(2, i) + (int) Math.pow(2, j);
                if (binMap.containsKey(binMul)) {
                    System.out.println("Duplicated");
                }
                binMap.put(binMul, new Pair(i, j));
                // System.out.println(binMul + ": " + i + "," + j);
            }
        }

        int[] keyMap = new int[8];
        for (int i = 0; i < 8; i++) {
            keyMap[i] = i;
        }
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (binMap.containsKey(num)) {
                Pair p = binMap.get(num);
                int temp = keyMap[p.x];
                keyMap[p.x] = keyMap[p.y];
                keyMap[p.y] = temp;
            }
            // System.out.println(binMap.get(num));
        }
        int K = Integer.parseInt(bf.readLine());
        System.out.println(keyMap[K]);
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + "," + y;
        }
    }
}
