package acmicpc13904;

import java.io.*;
import java.util.*;

/* 과제 
 * https://www.acmicpc.net/problem/13904
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        HashMap<Integer, ArrayList<Integer>> workMap = new HashMap<>();
        ArrayList<Integer> keyTree = new ArrayList<>();
        int maxDate = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int date = Integer.parseInt(st.nextToken());
            int work = Integer.parseInt(st.nextToken());
            if (!workMap.containsKey(date)) {
                workMap.put(date, new ArrayList<>());
                keyTree.add(date);
            }
            workMap.get(date).add(work);
            maxDate = Math.max(date, maxDate);
        }
        keyTree.sort((a, b) -> b - a);
        PriorityQueue<Integer> works = new PriorityQueue<>((a, b) -> b - a);
        int totalworks = 0;
        for (int i = maxDate; i >= 1; i--) {
            if (workMap.containsKey(i)) {
                works.addAll(workMap.get(i));
            }
            if (!works.isEmpty()) {
                int w = works.poll();
                totalworks += w;
                // System.out.println("k:" + i + ":" + w);
            }
        }
        System.out.println(totalworks);
    }
}
