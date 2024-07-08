package acmicpc2238;

import java.io.*;
import java.util.*;

/* 경매
 * https://www.acmicpc.net/problem/2238
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int U = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        HashMap<Integer, Attendant> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String name = st.nextToken();
            int price = Integer.parseInt(st.nextToken());

            if (!map.containsKey(price)) {
                map.put(price, new Attendant(name, 0, i));
            }
            map.get(price).count++;
        }
        int minCount = Integer.MAX_VALUE;
        for (Attendant at : map.values()) {
            minCount = Math.min(minCount, at.count);
        }
        int minIdx = Integer.MAX_VALUE;
        int resultKey = Integer.MAX_VALUE;
        String resultName = "";
        for (int key : map.keySet()) {
            Attendant curAtt = map.get(key);
            if (minCount == curAtt.count) {
                if (resultKey > key) {
                    resultKey = key;
                    resultName = map.get(key).name;
                    minIdx = curAtt.index;
                } else if (resultKey == key && minIdx > curAtt.index) {
                    resultKey = key;
                    resultName = map.get(key).name;
                    minIdx = curAtt.index;
                }
            }
        }
        System.out.println(resultName + " " + resultKey);
    }

    static class Attendant {
        String name;
        int count;
        int index;

        public Attendant(String name, int count, int index) {
            this.name = name;
            this.count = count;
            this.index = index;
        }

        @Override
        public String toString() {
            return name + ":" + count;
        }
    }
}
