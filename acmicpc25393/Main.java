package acmicpc25393;

import java.io.*;
import java.util.*;

/* 교집합 만들기
 * https://www.acmicpc.net/problem/25393
 */

public class Main {
    static int[] leftToRight = new int[1000001];
    static int[] rightToLeft = new int[1000001];
    static Set<Interval> set = new HashSet<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Arrays.fill(rightToLeft, Integer.MAX_VALUE);

        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            leftToRight[l] = Math.max(leftToRight[l], r);
            rightToLeft[r] = Math.min(rightToLeft[r], l);

            set.add(new Interval(l, r));
        }

        int Q = Integer.parseInt(bf.readLine());

        for (int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if (set.contains(new Interval(l, r))) {
                sb.append(1).append("\n");
            } else if (leftToRight[l] >= r && rightToLeft[r] <= l) {
                sb.append(2).append("\n");
            } else {
                sb.append(-1).append("\n");
            }
        }

        System.out.print(sb);
    }

    static class Interval {
        int l, r;

        Interval(int l, int r) {
            this.l = l;
            this.r = r;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (!(obj instanceof Interval))
                return false;
            Interval other = (Interval) obj;
            return this.l == other.l && this.r == other.r;
        }

        @Override
        public int hashCode() {
            return Objects.hash(l, r);
        }
    }
}