package acmicpc10975;

import java.io.*;
import java.util.*;

/* 데크 소트 2
 * https://www.acmicpc.net/problem/10975
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        ArrayList<Deque<Card>> q = new ArrayList<>();
        int[] arr = new int[N];
        Card[] c = new Card[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
            c[i] = new Card(arr[i], i);
        }
        Arrays.sort(c, (a, b) -> a.num - b.num);
        int[] map = new int[N];
        for (int i = 0; i < c.length; i++) {
            c[i].mapIdx = i;
            map[c[i].idx] = i;
        }
        // System.out.println(Arrays.toString(arr));
        // System.out.println(Arrays.toString(c));
        // System.out.println(Arrays.toString(map));
        q.add(new LinkedList<Card>());
        q.get(0).add(c[map[0]]);

        for (int i = 1; i < arr.length; i++) {
            boolean needHandle = true;
            for (Deque<Card> dq : q) {
                if (dq.peekFirst().mapIdx == map[i] - 1) {
                    needHandle = false;
                    dq.addFirst(c[map[i]]);
                    break;
                }
                if (dq.peekLast().mapIdx == map[i] + 1) {
                    needHandle = false;
                    dq.addLast(c[map[i]]);
                    break;
                }
            }
            if (needHandle) {
                Deque<Card> qC = new LinkedList<>();
                qC.add(c[map[i]]);
                q.add(qC);
            }
        }

        // for (Deque<Card> dq : q) {
        //     System.out.println(dq);
        // }

        System.out.println(q.size());
    }

    static class Card {
        int num;
        int idx;
        int mapIdx;

        public Card(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        @Override
        public String toString() {
            return num + "," + idx + "," + mapIdx + "|";
        }
    }
}
