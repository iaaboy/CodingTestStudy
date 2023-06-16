package prog154540;

import java.util.*;

public class TestMain_0318 {

    public static void main(String[] args) {
        String maps[] = {
                "11x8999",
        };
        // String maps[] = {
        // "XXX",
        // "XXX",
        // "XXX", };

        Solution mSolution = new Solution();
        System.out.println("maps result" + Arrays.toString(mSolution.solution(maps)));
    }
}

class Solution {
    int[][] ids;
    int wide;
    String[] maps;
    HashMap<Integer, Integer> counts = new HashMap<>();

    public int[] solution(String[] maps) {
        // int[] answer = {};
        this.maps = maps;
        wide = maps[0].length();
        ids = new int[maps.length][maps[0].length()];

        for (int y = 0; y < maps.length; y++) {
            for (int x = 0; x < wide; x++) {
                ids[y][x] = -1;
            }
        }

        for (int y = 0; y < maps.length; y++) {
            for (int x = 0; x < wide; x++) {
                Character ch = maps[y].charAt(x);
                if (ch != 'X' && ch != 'x') {
                    // System.out.print(ch + ",");
                    ids[y][x] = y * wide + x;
                    // 상하좌우 숫자가 있는지 찾는다.
                    counts.put(ids[y][x], ch - '0');
                    findGroup(y, x);

                    // 숫자가 있으면, Union
                }
            }
            System.out.println(Arrays.toString(ids[y]));
        }

        // System.out.println(counts);

        if (counts.size() == 0) {
            int[] answer = { -1 };
            return answer;
        } else {
            int[] answer = new int[counts.size()];
            int i = 0;
            for (int a : counts.values()) {
                answer[i++] = a;
            }

            Arrays.sort(answer);

            // System.out.println((Arrays.toString(counts.values().stream().sorted().toArray())));

            return answer;
        }
    }

    void findGroup(int y, int x) {
        // 위
        if (y > 0) {
            if (ids[y - 1][x] != -1) {
                union(y, x, y - 1, x);
            }
        }

        // 좌
        if (x > 0) {
            if (ids[y][x - 1] != -1) {
                union(y, x, y, x - 1);
            }
        }

        // 우
        if (x < wide - 1) { // 범위 체크
            if (ids[y][x + 1] != -1) {
                union(y, x, y, x + 1);
            }
        }
    }

    int findRoot(int y, int x) {
        if (ids[y][x] == y * wide + x) {
            return y * wide + x;
        } else {
            return findRoot(ids[y][x] / wide, ids[y][x] % wide);
        }
    }

    void union(int ay, int ax, int by, int bx) {
        int rootA = findRoot(ay, ax);
        int rootB = findRoot(by, bx);

        if (rootA == rootB) {
            // do nothing
            return;
        }

        if (rootA < rootB) {
            counts.put(rootA, counts.get(rootB) + counts.get(rootA));
            counts.remove(rootB);
            ids[by][bx] = rootA;
            // System.out.println(counts);
        } else {
            counts.put(rootB, counts.get(rootA) + counts.get(rootB));
            counts.remove(rootA);
            ids[ay][ax] = rootB;
            // System.out.println(counts);
        }
    }
}