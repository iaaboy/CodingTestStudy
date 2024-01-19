package prog258709;

import java.util.*;

/* 주사위 고르기
 * https://school.programmers.co.kr/learn/courses/30/lessons/258709
 */

public class MyMain {
    public static void main(String[] args) {
        int[][][] dices = {
                // {{1,2,3},{4,5,6},{1,2,3},{4,7,6},{2,5,5},{7,4,7}
                // },
                { { 1, 2, 3, 4, 5, 6 }, { 3, 3, 3, 3, 4, 4 }, { 1, 3, 3, 4, 4, 4 }, { 1, 1, 4, 4, 5, 5 } }, // {1, 4}
                { { 1, 2, 3, 4, 5, 6 }, { 2, 2, 4, 4, 6, 6 } }, // {2}
                { { 40, 41, 42, 43, 44, 45 }, { 43, 43, 42, 42, 41, 41 }, { 1, 1, 80, 80, 80, 80 },
                        { 70, 70, 1, 1, 70, 70 } },// [1, 3]
        };

        Solution mSol = new Solution();
        for (int[][] dice : dices) {
            System.out.println(Arrays.toString(mSol.solution(dice)));
            // break;
        }
    }
}

class Solution {
    int[][] dice;
    int diceNum;
    int[] answer;

    public int[] solution(int[][] dice) {
        this.dice = dice;
        diceNum = dice.length;
        answer = new int[diceNum / 2];

        boolean[] visited = new boolean[diceNum];
        int[] arrIndex = new int[diceNum];
        for (int i = 0; i < diceNum; i++) {
            arrIndex[i] = i;
        }

        combination(arrIndex, visited, 0, diceNum, diceNum / 2);

        Arrays.sort(answer);
        return answer;
    }

    void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            compareDice(arr, visited, n);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    private void compareDice(int[] arr, boolean[] visited, int n) {
        ArrayList<Integer> mySumSet = new ArrayList<>();
        ArrayList<Integer> newSumSet;
        ArrayList<Integer> yourSumSet = new ArrayList<>();

        int index;
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                index = arr[i];
                newSumSet = new ArrayList<>();
                for (int dNum : dice[index]) {
                    if (mySumSet.size() == 0) {
                        newSumSet.add(dNum);
                    }
                    for (int pSum : mySumSet) {
                        newSumSet.add(pSum + dNum);
                    }
                }
                mySumSet = newSumSet;

            } else {
                index = arr[i];
                newSumSet = new ArrayList<>();
                for (int dNum : dice[index]) {
                    if (yourSumSet.size() == 0) {
                        newSumSet.add(dNum);
                    }
                    for (int pSum : yourSumSet) {
                        newSumSet.add(pSum + dNum);
                    }
                }
                yourSumSet = newSumSet;
            }
        }

        HashMap<Integer, Integer> myMap = new HashMap<>();
        HashMap<Integer, Integer> yourMap = new HashMap<>();

        for (int a : mySumSet) {
            if (!myMap.containsKey(a)) {
                myMap.put(a, 1);
            } else {
                myMap.put(a, myMap.get(a) + 1);
            }
        }
        for (int a : yourSumSet) {
            if (!yourMap.containsKey(a)) {
                yourMap.put(a, 1);
            } else {
                yourMap.put(a, yourMap.get(a) + 1);
            }
        }

        int myWinCount = 0;
        int yourWinCount = 0;
        for (int m : myMap.keySet()) {
            for (int y : yourMap.keySet()) {
                if (m > y) {
                    myWinCount += (myMap.get(m) * yourMap.get(y));
                } else if (y > m) {
                    yourWinCount += (myMap.get(m) * yourMap.get(y));
                }
            }
        }

        if (myWinCount >= yourWinCount) {
            if (myWinCount - yourWinCount > maxWin) {
                // update
                int idx = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (visited[i]) {
                        answer[idx++] = arr[i] + 1;
                    }
                }
                maxWin = myWinCount - yourWinCount;
            }
        } else if (myWinCount < yourWinCount) {
            if (yourWinCount - myWinCount > maxWin) {
                // update
                int idx = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (!visited[i]) {
                        answer[idx++] = arr[i] + 1;
                    }
                }
                maxWin = yourWinCount - myWinCount;
            }
        }

        // System.out.println("me " + ": " + mySumSet);
        // System.out.println("you " + ": " + yourSumSet);
        // System.out.println("MyMap: " + myMap);
        // System.out.println("YourMap: " + yourMap);
        // System.out.println(myWinCount + " " + yourWinCount + " done\n");
    }

    int maxWin = Integer.MIN_VALUE;
}