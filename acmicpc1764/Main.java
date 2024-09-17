package acmicpc1764;

import java.io.*;
import java.util.*;

/* 듣보잡
 * https://www.acmicpc.net/problem/1764
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> nameSet = new HashMap<>();
        for (int i = 0; i < N; i++) {
            nameSet.put(bf.readLine(), 1);
        }
        int count = 0;
        for (int i = 0; i < M; i++) {
            String name = bf.readLine();
            if (nameSet.containsKey(name)) {
                count++;
                nameSet.put(name, 2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(count + "\n");
        ArrayList<String> nList = new ArrayList<>();
        for (String name : nameSet.keySet()) {
            if (nameSet.get(name) == 2) {
                nList.add(name + "\n");
            }
        }
        nList.sort(null);
        for (String string : nList) {
            sb.append(string);
        }
        System.out.print(sb);
    }
}
