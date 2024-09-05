package acmicpc20928;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Cart[] carts = new Cart[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            carts[i] = new Cart(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            carts[i].dist = carts[i].p + Integer.parseInt(st.nextToken());
        }
        if (carts[0].p != 1) {
            System.out.println("-1");
        }
        carts[0].count = 0;
        carts[0].visited = true;
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if (!carts[i].visited) {
                continue;
            }
            if (carts[i].dist >= K) {
                // System.out.println(carts[i].count);
                // System.out.println(Arrays.toString(carts));
                count = Math.min(count, carts[i].count);
            }
            for (int j = i + 1; j < N; j++) {

                if (carts[i].dist < carts[j].p) {
                    break;
                }
                if (carts[j].count == Integer.MAX_VALUE) {
                    carts[j].count = carts[i].count + 1;
                } else {
                    carts[j].count = Math.min(carts[j].count, carts[i].count + 1);
                }
                carts[j].visited = true;
            }
        }
        System.out.println(Arrays.toString(carts));
        if (count == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }

    }

    static class Cart {
        int p;
        int dist;
        int count = Integer.MAX_VALUE;
        boolean visited;

        public Cart(int p) {
            this.p = p;
        }

        @Override
        public String toString() {
            return p + ">" + dist + "(" + count + ")";
        }
    }
}
