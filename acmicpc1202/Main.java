package acmicpc1202;

import java.io.*;
import java.util.*;

/* 보석 도둑
 * https://www.acmicpc.net/problem/1202
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Gem[] gems = new Gem[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            gems[i] = new Gem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Integer[] bags = new Integer[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(gems, (a, b) -> a.weight - b.weight);
        Arrays.sort(bags, (a, b) -> a - b);
        PriorityQueue<Gem> gemCandidates = new PriorityQueue<>((a, b) -> b.value - a.value);
        int gIndex = 0;
        long jewelSum = 0;
        for (int i = 0; i < K; i++) {
            while (gIndex < N && gems[gIndex].weight <= bags[i]) {
                gemCandidates.add(gems[gIndex++]);
            }
            if (!gemCandidates.isEmpty()) {
                jewelSum += gemCandidates.poll().value;
            }
        }
        System.out.println(jewelSum);
    }

    static class Gem {
        int weight, value;

        public Gem(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
