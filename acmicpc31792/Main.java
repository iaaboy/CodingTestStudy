package acmicpc31792;

import java.io.*;
import java.util.*;

/* 한빛미디어 (Hard)
 * https://www.acmicpc.net/problem/31792
 * map 이분탐색.
 */

public class Main {
    static TreeMap<Integer, Integer> shelf = new TreeMap<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        while (Q-- > 0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int q = Integer.parseInt(st.nextToken());
            if (q == 1) {
                int price = Integer.parseInt(st.nextToken());
                shelf.put(price, shelf.getOrDefault(price, 0) + 1);
            } else if (q == 2) {
                int price = Integer.parseInt(st.nextToken());
                if (shelf.containsKey(price)) {
                    if (shelf.get(price) == 1) {
                        shelf.remove(price);
                    } else {
                        shelf.put(price, shelf.get(price) - 1);
                    }
                }
            } else { // 3
                int shelfCount = countShelves();
                sb.append(shelfCount).append("\n");
            }
        }
        System.out.print(sb);
    }

    private static int countShelves() {
        if (shelf.size() == 0) {
            return 0;
        }
        int count = 0;
        // 가격이 두 배 이상 차이 나는 책을 한 페이지에 함께 진열할 수 없다.
        Integer prevPrice = shelf.firstKey();
        while (true) {
            count++;
            prevPrice = shelf.ceilingKey(prevPrice * 2);
            if (prevPrice == null) {
                break;
            }
        }
        return count;
    }
}
