package acmicpc31796;

import java.io.*;
import java.util.*;

/* 한빛미디어 (Easy)
 * https://www.acmicpc.net/problem/31796
 * map 이분탐색.
 */

public class Main {
    static TreeSet<Integer> books = new TreeSet<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            books.add(Integer.parseInt(st.nextToken()));
        }
        System.out.println(countShelves());
    }

    private static int countShelves() {
        if (books.size() == 0) {
            return 0;
        }
        int count = 0;
        // 가격이 두 배 이상 차이 나는 책을 한 페이지에 함께 진열할 수 없다.
        Integer prevPrice = books.first();
        while (true) {
            count++;
            prevPrice = books.ceiling(prevPrice * 2);
            if (prevPrice == null) {
                break;
            }
        }
        return count;
    }
}
