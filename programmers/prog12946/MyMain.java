package prog12946;

import java.util.*;

/**
 * 하노이의 탑
 * https://school.programmers.co.kr/learn/courses/30/lessons/12946
 */

public class MyMain {
    public static void main(String[] args) {
        int n = 3;
        Solution mSol = new Solution();
        for (int[] a : mSol.solution(n)) {
            System.out.println(Arrays.toString(a));
        }
    }
}

class Solution {
    ArrayList<Stack<Integer>> hanoList = new ArrayList<>();
    int[][] answer;
    int index = 0;

    public int[][] solution(int n) {
        int count = (int) Math.pow(2, n);
        answer = new int[count - 1][2];

        for (int i = 0; i < 3; i++)
            hanoList.add(new Stack<>());
        for (int i = n; i > 0; i--)
            hanoList.get(0).add(i);

        hanoi(n, 0, 2, 1);

        return answer;
    }

    private void hanoi(int n, int from, int to, int aux) {
        if (n == 1) {
            move(from, to);
            return;
        }

        hanoi(n - 1, from, aux, to);

        move(from, to);

        hanoi(n - 1, aux, to, from);
    }

    private void move(int from, int to) {
        int num = hanoList.get(from).pop();
        hanoList.get(to).push(num);
        answer[index][0] = from + 1;
        answer[index++][1] = to + 1;
        // System.out.println(from + "->" + to + " " + hanoList);
    }
}