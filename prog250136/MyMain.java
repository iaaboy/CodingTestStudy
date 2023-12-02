package prog250136;

import java.util.*;

/* [PCCP 기출문제] 2번
 * https://school.programmers.co.kr/learn/courses/30/lessons/250136
 */

public class MyMain {
    public static void main(String[] args) {
        int[][][] lands = {
                { { 0, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 1, 1, 0, 0 }, { 1, 1, 0, 0, 0, 1, 1, 0 },
                        { 1, 1, 1, 0, 0, 0, 0, 0 }, { 1, 1, 1, 0, 0, 0, 1, 1 } }
        };

        Solution mSol = new Solution();
        for (int[][] land : lands)
            System.out.println(mSol.solution(land));

    }
}

class Solution {
    int[][] land;
    int v, h;

    HashMap<Integer, Integer> oilMap;

    public int solution(int[][] land) {
        this.land = land;
        v = land.length;
        h = land[0].length;
        oilMap = new HashMap<>();

        int gId = 2;
        for (int y = 0; y < v; y++)
            for (int x = 0; x < h; x++) {
                if (land[y][x] == 1) {
                    setGroup(y, x, gId++);
                }
            }

        for (int y = 0; y < v; y++)
            for (int x = 0; x < h; x++) {
                if (land[y][x] == 0) {
                    // idMap[y][x] = -1;
                } else {
                    if (!oilMap.containsKey(land[y][x])) {
                        oilMap.put(land[y][x], 1);
                    } else {
                        oilMap.put(land[y][x], oilMap.get(land[y][x]) + 1);
                    }
                }
            }

        HashSet<Integer> mSet = new HashSet<>();
        int answer = Integer.MIN_VALUE;
        for (int x = 0; x < h; x++) {
            mSet.clear();
            for (int y = 0; y < v; y++) {
                if (land[y][x] != 0) {
                    mSet.add(land[y][x]);
                }
            }

            int totalCount = 0;
            for (int m : mSet) {
                totalCount += oilMap.get(m);
            }
            answer = Math.max(answer, totalCount);
        }

        printAll();

        return answer;
    }

    int[] offsetX = { 0, 1, -1, 0 };
    int[] offsetY = { 1, 0, 0, -1 };

    void setGroup(int y, int x, int gId) {
        land[y][x] = gId;
        for (int i = 0; i < 4; i++) {
            int nextX = x + offsetX[i];
            int nextY = y + offsetY[i];
            if (nextX < 0 || nextX >= h || nextY < 0 || nextY >= v) {
                continue;
            }
            if (land[nextY][nextX] == 1) {
                setGroup(nextY, nextX, gId);
            }
        }
    }

    void printAll() {
        // for (int[] m : idMap) {
        // System.out.println(Arrays.toString(m));
        // }
        System.out.println(oilMap);
        for (int[] l : land) {
            System.out.println(Arrays.toString(l));
        }
    }
}