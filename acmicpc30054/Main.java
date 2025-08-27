package acmicpc30054;

import java.io.*;
import java.util.*;

/* 웨이팅
 * https://www.acmicpc.net/problem/30054
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Guest[] g = new Guest[N];
        int maxTime = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int reserved = Integer.parseInt(st.nextToken());
            int arrived = Integer.parseInt(st.nextToken());
            g[i] = new Guest(reserved, arrived);
            maxTime = Math.max(maxTime, Math.max(arrived, reserved));
        }
        Arrays.sort(g, (a, b) -> {
            if (a.arrivedTime == b.arrivedTime) {
                return a.reservedTime - b.reservedTime;
            } else {
                return a.arrivedTime - b.arrivedTime;
            }
        });
        // System.out.println(Arrays.toString(g));

        int index = 0;
        Queue<Integer> waitQ = new ArrayDeque<>();
        int [] waitingReserved = new int[maxTime + 1];
        int i = 1;
        int maxDiff = 0;
        for (; i <= maxTime; i++) {
            boolean isHandled = false;
            while (index < N && g[index].arrivedTime <= i) {
                if (g[index].arrivedTime == i && g[index].reservedTime == i) {
                    // 정시 도착
                    // System.out.println("c1 " + i + ":" + g[index]);
                    index++;
                    isHandled = true;
                    break;
                }
                if (g[index].reservedTime >= i) {
                    waitingReserved[g[index].reservedTime] = index;
                }
                waitQ.add(index);
                index++;
            }
            if (waitingReserved[i] != 0) {
                // System.out.println("c2 " + i + ":" + g[waitingReserved[i]]);
                g[waitingReserved[i]].isServed = true;
                maxDiff = Math.max(maxDiff, (i - g[waitingReserved[i]].arrivedTime));
            } else if (!isHandled) {
                while (!waitQ.isEmpty()) {
                    Guest c =  g[waitQ.poll()];
                    if (!c.isServed) {
                        waitingReserved[c.reservedTime] = 0;
                        // System.out.println("c3 " + i + ":" + c);
                        maxDiff = Math.max(maxDiff, i - c.arrivedTime);
                        break;
                    }
                }
            }
        }
        while (!waitQ.isEmpty()) {
            Guest c =  g[waitQ.poll()];
            if (!c.isServed) {
                c.isServed = true;
                // System.out.println("c3 " + i + ":" + c);
                maxDiff = Math.max(maxDiff, i - c.arrivedTime);
                i++;
            }
        }
        System.out.println(maxDiff);
    }

    static class Guest {
        int reservedTime, arrivedTime;
        boolean isServed;

        public Guest(int reservedTime, int arrivedTime) {
            this.reservedTime = reservedTime;
            this.arrivedTime = arrivedTime;
        }

        @Override
        public String toString() {
            return reservedTime + "," + arrivedTime;
        }
    }
}
