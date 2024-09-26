package acmicpc21276;

import java.io.*;
import java.util.*;

/* 계보 복원가 호석
 * https://www.acmicpc.net/problem/21276
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        ArrayList<String> names = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            names.add(st.nextToken());
        }
        names.sort(null);
        HashMap<String, Integer> nameMap = new HashMap<>();
        Family[] families = new Family[N];
        for (int i = 0; i < N; i++) {
            nameMap.put(names.get(i), i);
            families[i] = new Family();
        }
        int M = Integer.parseInt(bf.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int me = nameMap.get(st.nextToken());
            int f = nameMap.get(st.nextToken());
            families[me].pCount++;
            families[f].sons.add(me);
        }

        Queue<Integer> q = new LinkedList<>();
        StringBuilder ancester = new StringBuilder();
        int ancCount = 0;
        for (String name : names) {
            if (families[nameMap.get(name)].pCount == 0) {
                ancCount++;
                q.add(nameMap.get(name));
                ancester.append(name + " ");
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Integer son : families[cur].sons) {
                if (--families[son].pCount <= 0) {

                    families[cur].directSons.add(son);
                    q.add(son);
                }
            }
        }

        ancester = new StringBuilder(ancester.substring(0, ancester.length() - 1));
        ancester.insert(0, ancCount + "\n");
        System.out.println(ancester);

        StringBuilder sb2 = new StringBuilder();
        for (String name : names) {
            ArrayList<Integer> dSons = families[nameMap.get(name)].directSons;
            dSons.sort(null);
            sb2.append(name + " " + dSons.size());
            for (int s : dSons) {
                sb2.append(" " + names.get(s));
            }
            sb2.replace(sb2.length(), sb2.length(), "\n");
        }
        System.out.print(sb2);
    }

    static class Family {
        int pCount = 0;
        ArrayList<Integer> sons = new ArrayList<>();
        ArrayList<Integer> directSons = new ArrayList<>();

        @Override
        public String toString() {
            return pCount + "," + "," + sons + " ds:" + directSons;
        }
    }
}
