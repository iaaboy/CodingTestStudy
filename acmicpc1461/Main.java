package acmicpc1461;

import java.io.*;
import java.util.*;

/* 도서관
 * https://www.acmicpc.net/problem/1461
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer> plusList = new ArrayList<>();
        ArrayList<Integer> minusList = new ArrayList<>();
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num > 0) {
                plusList.add(num);
            } else if (num < 0) {
                minusList.add(-num);
            }
        }
        minusList.sort(Comparator.reverseOrder());
        plusList.sort(Comparator.reverseOrder());

        // System.out.println(plusList);
        // System.out.println(minusList);

        int max = 0;
        int sum = 0;
        for (int i = 0; i < plusList.size(); i += m) {
            int num = plusList.get(i);
            // System.out.println(num);
            sum += 2 * num;
            max = Math.max(max, num);
        }
        for (int i = 0; i < minusList.size(); i += m) {
            int num = minusList.get(i);
            // System.out.println(num);
            sum += 2 * num;
            max = Math.max(max, num);
        }
        System.out.println(sum - max);
    }
}
