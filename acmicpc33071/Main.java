package acmicpc33071;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Map<Integer, List<Integer>> numSet = new HashMap<>();

        TreeSet<Integer> bVal = new TreeSet<>();//중복허용하지 않음.

        System.out.println(bVal);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            numSet.putIfAbsent(a, new ArrayList<>());
            numSet.get(a).add(b);

            bVal.add(b);
        }

        int max = Integer.MIN_VALUE;

        for (Map.Entry<Integer, List<Integer>> entry : numSet.entrySet()) {
            int a = entry.getKey();
            List<Integer> v = entry.getValue();
            for (int val : numSet.get(a)) {
                bVal.remove(val);
            }

            for (int i : v) {
                int remnant = K - i;
                Integer iter = bVal.floor(remnant);
                if (iter == null || iter == i) {
                    continue;
                }
                max = Math.max(max, i + iter);
            }

            for (int val : numSet.get(a)) {
                bVal.add(val);
            }
        }

        if (max == Integer.MIN_VALUE) {
            System.out.println("NO");
        } else {
            System.out.println(max);
        }
    }
}

/*
4 11
1 5
1 5
2 5
2 5
 */