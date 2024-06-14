package acmicpc31908;

import java.io.*;
import java.util.*;

/* 커플링 매치
 * https://www.acmicpc.net/problem/31908
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        HashMap<String, ArrayList<String>> nameMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] sepa = bf.readLine().split(" ");
            if (sepa[1].contentEquals("-"))
                continue;
            if (!nameMap.containsKey(sepa[1])) {
                nameMap.put(sepa[1], new ArrayList<>());
            }
            nameMap.get(sepa[1]).add(sepa[0]);
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (ArrayList<String> names : nameMap.values()) {
            if (names.size() == 2) {
                count++;
                sb.append(names.get(0) + " " + names.get(1) + "\n");
            }
        }
        sb.insert(0, count + "\n");
        System.out.println(sb);
    }
}
