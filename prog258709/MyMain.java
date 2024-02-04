package prog258709;

import java.util.*;

/* 주사위 고르기
 * https://school.programmers.co.kr/learn/courses/30/lessons/258709
 */

public class MyMain {
    public static void main(String[] args) {
        int[][][] dices = {
                { { 1, 1, 4, 2, 8, 7 }, { 2, 5, 5, 6, 9, 9 }, { 2, 3, 4, 6, 6, 7 }, { 3, 4, 6, 7, 3, 5 } },
                { { 1, 2, 3, 4, 5, 6 }, { 3, 3, 3, 3, 4, 4 }, { 1, 3, 3, 4, 4, 4 }, { 1, 1, 4, 4, 5, 5 } }, // {1, 4}
                { { 1, 2, 3, 4, 5, 6 }, { 2, 2, 4, 4, 6, 6 } }, // {2}
                { { 40, 41, 42, 43, 44, 45 }, { 43, 43, 42, 42, 41, 41 }, { 1, 1, 80, 80, 80, 80 },
                        { 70, 70, 1, 1, 70, 70 } },// [1, 3]
        };

        Solution mSol = new Solution();
        for (int[][] dice : dices) {
            System.out.println(Arrays.toString(mSol.solution(dice)));
        }
    }
}

class Solution {
    Integer[][] dice;
    int diceNum;
    int[] answer;

    public int[] solution(int[][] dice) {
        this.dice = new Integer[dice.length][dice[0].length];
        for (int j = 0; j < dice.length; j++) {
            for (int i = 0; i < dice[0].length; i++) {
                this.dice[j][i] = dice[j][i];
            }
        }
        diceNum = dice.length;
        answer = new int[diceNum / 2];

        boolean[] visited = new boolean[diceNum];
        int[] arrIndex = new int[diceNum];
        for (int i = 0; i < diceNum; i++) {
            arrIndex[i] = i;
        }

        maxDiff = Integer.MIN_VALUE;
        combination(arrIndex, visited, 0, diceNum, diceNum / 2);

        int index = 0;
        for (int n : maxList) {
            answer[index++] = n + 1;
        }
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

    List<Integer> getSumList(List<Integer> curSum, int dIndex) {
        List<Integer> sumListNext = new ArrayList<>();
        for (int s : curSum) {
            for (int d : dice[dIndex]) {
                sumListNext.add(s + d);
            }
        }
        return sumListNext;
    }

    List<Integer> maxList;
    int maxDiff;

    private void compareDice(int[] arr, boolean[] visited, int n) {
        int myWin = 0;
        ArrayList<Integer> myDice = new ArrayList<>();
        ArrayList<Integer> yourDice = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                myDice.add(i);
            } else {
                yourDice.add(i);
            }
        }

        HashMap<Integer, Integer> myMap = new HashMap<>();
        List<Integer> mySumList = Arrays.asList(dice[myDice.get(0)]);
        for (int i = 1; i < myDice.size(); i++) {
            mySumList = getSumList(mySumList, myDice.get(i));
        }

        mySumList.sort(null);
        for (int s : mySumList) {
            if (!myMap.containsKey(s)) {
                myMap.put(s, 1);
            } else {
                myMap.put(s, myMap.get(s) + 1);
            }
        }

        HashMap<Integer, Integer> yourMap = new HashMap<>();
        List<Integer> yoursumList = Arrays.asList(dice[yourDice.get(0)]);
        for (int i = 1; i < yourDice.size(); i++) {
            yoursumList = getSumList(yoursumList, yourDice.get(i));
        }
        yoursumList.sort(null);

        for (int s : yoursumList) {
            if (!yourMap.containsKey(s)) {
                yourMap.put(s, 1);
            } else {
                yourMap.put(s, yourMap.get(s) + 1);
            }
        }

        for (int mySum : myMap.keySet()) {
            for (int yourSum : yourMap.keySet()) {
                if (mySum > yourSum) {
                    myWin += myMap.get(mySum) * yourMap.get(yourSum);
                }
            }
        }

        if (myWin > maxDiff) {
            maxDiff = myWin;
            maxList = myDice;
            // System.out.print("********** " + myDice + " vs ");
            // System.out.print(yourDice + " ");
            // System.out.println(myWin);
            // System.out.println(mySumList);
            // System.out.println(yoursumList);
            // System.out.println(myMap);
            // System.out.println(yourMap);
        }
    }
}