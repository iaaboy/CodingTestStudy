package acmicpc22252;

import java.io.*;
import java.util.*;

/* 정보 상인 호석
 * https://www.acmicpc.net/problem/22252
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        HashMap<String, PriorityQueue<Integer>> infoMap = new HashMap<>();
        PriorityQueue<Integer> pq;
        String key;
        int count;
        long totalVaue = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            if (st.nextToken().charAt(0) == '1') {
                key = st.nextToken();
                if (!infoMap.containsKey(key)) {
                    pq = new PriorityQueue<>(Collections.reverseOrder());
                    infoMap.put(key, pq);
                } else {
                    pq = infoMap.get(key);
                }
                count = Integer.parseInt(st.nextToken());
                while (count > 0) {
                    pq.add(Integer.parseInt(st.nextToken()));
                    count--;
                }
            } else { // 2
                key = st.nextToken();
                count = Integer.parseInt(st.nextToken());
                pq = infoMap.get(key);
                if (pq == null) {
                    continue;
                }
                while (count > 0 && !pq.isEmpty()) {
                    totalVaue += pq.poll();
                    count--;
                }
            }
        }
        System.out.println(totalVaue);
    }
}
