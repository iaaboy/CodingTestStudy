package prog258709;

import java.util.*;

/* 주사위 고르기
 * https://school.programmers.co.kr/learn/courses/30/lessons/258709
 */

public class MyMain {
    public static void main(String[] args) {
        int[][][] dicesStatic = {
                { { 12, 21, 61, 84, 30, 69 },
                        { 75, 61, 83, 20, 54, 18 } }

        };

        Solution mSol = new Solution();

        for (int[][] dice : dicesStatic) {
            System.out.println(Arrays.toString(mSol.solution(dice)));
        }
    }
}

class Solution {
    int[][] dice;

    public int[] solution(int[][] dice) {
        int diceCount = dice.length;
        int[] arr = new int[diceCount];
        boolean[] visited = new boolean[diceCount];
        this.dice = dice;
        maxWin = Integer.MIN_VALUE;
        combi(arr, visited, 0, 0, diceCount / 2);
        int[] answer = finalWin.stream().mapToInt(i -> i + 1).toArray();
        return answer;
    }

    int maxWin;
    ArrayList<Integer> finalWin;

    private void combi(int[] arr, boolean[] visited, int start, int depth, int r) {
        if (depth == r) {
            ArrayList<Integer> mine = new ArrayList<>();
            ArrayList<Integer> yours = new ArrayList<>();
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    mine.add(i);
                } else {
                    yours.add(i);
                }
            }
            int curWin = checkWinRate(mine, yours);
            if (curWin >= 0) {
                if (curWin > maxWin) {
                    maxWin = curWin;
                    finalWin = mine;
                }
            } else if (curWin < 0) {
                curWin = -curWin;
                if (curWin > maxWin) {
                    maxWin = curWin;
                    finalWin = yours;
                }
            }
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combi(arr, visited, i + 1, depth + 1, r);
                visited[i] = false;
            }
        }
    }

    private int checkWinRate(ArrayList<Integer> mine, ArrayList<Integer> yours) {
        HashMap<Integer, Integer> mySums = new HashMap<>();
        HashMap<Integer, Integer> yourSums = new HashMap<>();

        int myWin = 0;
        int yourWin = 0;

        genNum(mine, 0, 0, mySums);
        genNum(yours, 0, 0, yourSums);

        for (int m : mySums.keySet()) {
            for (int y : yourSums.keySet()) {
                if (m > y) {
                    myWin += (yourSums.get(y) * mySums.get(m));
                } else if (y > m) {
                    yourWin += (yourSums.get(y) * mySums.get(m));
                }
            }
        }
        System.out.println(mine);
        System.out.println(yours);
        System.out.println("my: " + mySums);
        System.out.println("yr: " + yourSums);
        System.out.println(myWin + " vs " + yourWin);
        return myWin - yourWin;
    }

    void genNum(ArrayList<Integer> idx, int curSum, int depth, HashMap<Integer, Integer> sums) {
        if (depth == idx.size()) {
            if (!sums.containsKey(curSum)) {
                sums.put(curSum, 1);
            } else {
                sums.put(curSum, sums.get(curSum) + 1);
            }
            return;
        }

        for (int n : dice[idx.get(depth)]) {
            genNum(idx, curSum + n, depth + 1, sums);
        }
    }
}