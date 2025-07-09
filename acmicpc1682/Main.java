package acmicpc1682;

import java.io.*;
import java.util.*;

/* 돌리기
 * https://www.acmicpc.net/problem/1682
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] initial = { 1, 2, 3, 4, 8, 7, 6, 5 };
        int[] target = new int[8];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 8; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }
        target = new int[] {
                target[0], target[1], target[2], target[3],
                target[7], target[6], target[5], target[4]
        };
        Queue<Cube> pq = new ArrayDeque<>();
        pq.add(new Cube(initial, 0));
        HashSet<String> numSet = new HashSet<>();
        numSet.add(Arrays.toString(initial));
        while (!pq.isEmpty()) {
            Cube c = pq.poll();
            // System.out.println(c);
            if (Arrays.equals(c.target, target)) {
                System.out.println(c.switchCount);
                return;
            }

            int[] ntA = { // A: 윗줄과 아랫줄에 있는 수 4개를 모두 바꾼다.
                    c.target[4], c.target[5], c.target[6], c.target[7],
                    c.target[0], c.target[1], c.target[2], c.target[3] };
            String strA = Arrays.toString(ntA);
            if (!numSet.contains(strA)) {
                numSet.add(strA);
                pq.add(new Cube(ntA, c.switchCount + 1));
            }

            int[] ntB = { // B: 두 줄에 있는 수를 오른쪽으로 한 칸씩 옮기고, 맨 오른쪽에 있던 수를 맨 왼쪽으로 옮긴다.
                    c.target[3], c.target[0], c.target[1], c.target[2],
                    c.target[7], c.target[4], c.target[5], c.target[6], };
            String strB = Arrays.toString(ntB);
            if (!numSet.contains(strB)) {
                numSet.add(strB);
                pq.add(new Cube(ntB, c.switchCount + 1));
            }

            int[] ntC = { // C: 가운데에 있는 네 정사각형의 수를 반 시계 방향으로 한 번 돌린다.
                    c.target[0], c.target[2], c.target[6], c.target[3],
                    c.target[4], c.target[1], c.target[5], c.target[7] };
            String strC = Arrays.toString(ntC);
            if (!numSet.contains(strC)) {
                numSet.add(strC);
                pq.add(new Cube(ntC, c.switchCount + 1));
            }

            int[] ntD = { // D: 1번과 5번을 바꾼다. (1번과 5번이라는 것은 위치를 말함. 1,5번 위치는 위의 표의 숫자의 위치와 같음)
                    c.target[7], c.target[1], c.target[2], c.target[3],
                    c.target[4], c.target[5], c.target[6], c.target[0], };
            String strD = Arrays.toString(ntD);
            if (!numSet.contains(strD)) {
                numSet.add(strD);
                pq.add(new Cube(ntD, c.switchCount + 1));
            }
        }
    }

    static class Cube {
        int[] target;
        int switchCount;

        public Cube(int[] target, int switchCount) {
            this.target = target;
            this.switchCount = switchCount;
        }

        @Override
        public String toString() {
            return switchCount + Arrays.toString(target);
        }
    }
}
