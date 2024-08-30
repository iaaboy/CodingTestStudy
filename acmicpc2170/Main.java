package acmicpc2170;

import java.io.*;
import java.util.*;

/* 선 긋기
 * https://www.acmicpc.net/problem/2170
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Coord> pQ = new PriorityQueue<>((a, b) -> a.p - b.p);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pQ.add(new Coord(start, true));
            pQ.add(new Coord(end, false));
        }

        int nowOn = 0;
        int prevC = 0;
        int prevOn = 0;
        int sum = 0;
        while (!pQ.isEmpty()) {
            int c = pQ.peek().p;
            while (!pQ.isEmpty() && (pQ.peek().p == c)) {
                Coord currentPtr = pQ.poll();
                if (currentPtr.isStart) {
                    nowOn++;
                } else {
                    nowOn--;
                }
            }

            if (prevOn == 0 && nowOn > 0) {
                // System.out.println(prevC + "->" + c + " , " + prevOn + "->" + nowOn);
                prevC = c;
            } else if (prevOn > 0 && nowOn == 0) {
                // System.out.println(prevC + "->" + c + " , " + prevOn + "->" + nowOn);
                sum += c - prevC;
                prevC = c;
            }
            prevOn = nowOn;
        }
        System.out.println(sum);
    }

    static class Coord {
        int p;
        boolean isStart;

        public Coord(int p, boolean isStart) {
            this.p = p;
            this.isStart = isStart;
        }
    }
}
