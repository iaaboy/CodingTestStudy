package prog250136_2;

import java.util.*;

/* [PCCP 기출문제] 2번 2번째
 * https://school.programmers.co.kr/learn/courses/30/lessons/250136
 */

public class MyMain {
    public static void main(String[] args) {
        int[][][] lands = {
                {{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}},
                {{1, 0, 1, 0, 1, 1}, {1, 0, 1, 0, 0, 0}, {1, 0, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 0}, {1, 0, 0, 1, 0, 1}, {1, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1}},

                {{0, 0, 0, 1, 1, 1, 1, 1},
                 {0, 0, 0, 0, 0, 0, 0, 1},
                 {1, 1, 1, 1, 1, 1, 1, 1},
                 {1, 1, 1, 0, 0, 0, 0, 0},
                 {1, 1, 1, 0, 0, 0, 1, 1}}

        };

        Solution mSol = new Solution();
        for (int[][] land : lands)
            System.out.println(mSol.solution(land));

    }
}

class Solution {
    int index;
    int maxX;
    int maxY;
    int[][] land;
    public int solution(int[][] land) {

        index = 2;
        maxX = land[0].length;
        maxY = land.length;
        this.land = land;

        for(int y = 0 ; y < maxY ; y++) {
            for(int x = 0; x < maxX ; x++) {
                if(land[y][x] == 1) {
                    setGroup(y, x, -2, -2);
                    index ++;
                }
            }
        }

        printAll();

        HashMap<Integer, Integer> idCount = new HashMap<>();
        for(int y = 0 ; y < maxY ; y++) {
            for(int x = 0; x < maxX ; x++) {
                if(land[y][x] == 0)
                    continue;

                if(!idCount.containsKey(land[y][x])) {
                    idCount.put(land[y][x], 1);
                } else {
                    idCount.put(land[y][x], idCount.get(land[y][x]) + 1);
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        for(int x = 0; x < maxX ; x++) {
            Set <Integer> indexSet = new HashSet<>();
            for(int y = 0 ; y < maxY ; y++) {
                if(land[y][x] != 0) {
                    indexSet.add(land[y][x]);
                }
            }
            int sum = 0;
            for (Integer integer : indexSet) {
                sum += idCount.get(integer);
                // System.out.print(integer + " ");
            }
            // System.out.println( ": " + sum);

            if(sum > answer) {
                answer = sum;
            }
        }

        return answer;
    }
    int[] offsetX = { 0, 1, -1, 0 };
    int[] offsetY = { 1, 0, 0, -1 };
    class NextPtr {
        int y;
        int x;
        int prevY;
        int prevX;
        public NextPtr(int y, int x, int prevY, int prevX) {
            this.y = y;
            this.x = x;
            this.prevY = prevY;
            this.prevX = prevX;
        }
    }
    private void setGroup(int y, int x, int prevY, int prevX) {

        if(land[y][x] == 1) {
            land[y][x] = index;
        }

        for(int i = 0; i < 4 ;i++) {
            int nextX = x + offsetX[i];
            int nextY = y + offsetY[i];
            if(nextX < 0 || nextX >= maxX || nextY < 0 || nextY >= maxY || (nextX == prevX && nextY == prevY))
                continue;
            
            if(land[nextY][nextX] == 1)
                setGroup(nextY, nextX, y, x);
        }
    }

    void printAll() {
        for (int[] l : land) {
            System.out.println(Arrays.toString(l));
        }
    }
}