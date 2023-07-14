package prog136797;

public class MyMain {
    public static void main(String[] args) {
        String myStr = "555";
        Solution mSol = new Solution();
        System.out.println(mSol.solution(myStr));
    }
}

class Solution {
    int[][] preset = { { 3, 1 }, { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 0 }, { 1, 1 }, { 1, 2 }, { 2, 0 }, { 2, 1 },
            { 2, 2 }, };
    int map[][] = new int[10][10];
    String numbers;
    int[][][] memo;

    public int solution(String numbers) {
        int answer = 0;
        this.numbers = numbers;
        for (int i = 0; i < 10; i++) {
            for (int j = i; j < 10; j++) {
                int dist = generateDistance(i, j);
                map[j][i] = map[i][j] = dist;
            }
        }

        // for (int i = 0; i < 10; i++) {
        // System.out.println(Arrays.toString(map[i]));
        // }

        // answer = caltDist();

        memo = new int[numbers.length() + 1][10][10];
        for (int i = 0; i < numbers.length() + 1; i++)
            for (int j = 0; j < 10; j++)
                for (int k = 0; k < 10; k++)
                    memo[i][j][k] = -1;
        answer = solve(0, 4, 6);

        return answer;
    }

    public int solve(int ind, int L, int R) {
        if (ind == numbers.length()) {
            return 0;
        }
        if (memo[ind][L][R] != -1)
            return memo[ind][L][R];

        int num = numbers.charAt(ind) - '0';
        int result = Integer.MAX_VALUE;

        if (num != R)
            result = Math.min(solve(ind + 1, num, R) + map[L][num], result);

        if (num != L)
            result = Math.min(solve(ind + 1, L, num) + map[R][num], result);
        memo[ind][L][R] = result;
        return memo[ind][L][R];
    }

    // int caltDist() {
    // int[][][] isVisit = new int[numbers.length() + 1][10][10];
    // int result = Integer.MAX_VALUE;
    // PriorityQueue<StateData> stateQ = new PriorityQueue<>();
    // stateQ.add(new StateData(0, 0, 6, 4));
    // isVisit[0][6][4] = 0;
    // int big = 0;
    // int small = 0;

    // for (int i = 0; i < numbers.length() + 1; i++)
    // for (int j = 0; j < 10; j++)
    // for (int k = 0; k < 10; k++)
    // isVisit[i][j][k] = Integer.MAX_VALUE;

    // while (!stateQ.isEmpty()) {
    // StateData curSt = stateQ.poll();

    // if (curSt.strIndex >= numbers.length()) {
    // // System.out.println(curSt);
    // if (curSt.distance < result) {
    // result = curSt.distance;
    // }
    // continue;
    // }

    // int curNumIndex = numbers.charAt(curSt.strIndex) - '0';

    // big = Math.max(curNumIndex, curSt.big);
    // small = Math.min(curNumIndex, curSt.big);

    // if (isVisit[curSt.strIndex + 1][big][small] > curSt.distance +
    // map[curSt.small][curNumIndex]) {
    // StateData a = new StateData(curSt.strIndex + 1, curSt.distance +
    // map[curSt.small][curNumIndex], big,
    // small);
    // // System.out.println(curSt.small + "-> " + curNumIndex + " : " +
    // // map[curSt.small][curNumIndex]);
    // // System.out.println("add: " + a);
    // isVisit[curSt.strIndex + 1][big][small] = a.distance;
    // stateQ.add(a);
    // } else {
    // // System.out.println("pass: " + a);
    // }

    // big = Math.max(curNumIndex, curSt.small);
    // small = Math.min(curNumIndex, curSt.small);

    // if (isVisit[curSt.strIndex + 1][big][small] > curSt.distance +
    // map[curSt.big][curNumIndex]) {
    // StateData b = new StateData(curSt.strIndex + 1, curSt.distance +
    // map[curSt.big][curNumIndex], big,
    // small);
    // // System.out.println(curSt.big + "-> " + curNumIndex + " : " +
    // // map[curSt.big][curNumIndex]);
    // // System.out.println("add: " + b);
    // isVisit[curSt.strIndex + 1][big][small] = b.distance;
    // stateQ.add(b);
    // } else {
    // // System.out.println("pass: " + b);
    // }
    // }

    // return result;
    // }

    int generateDistance(int from, int to) {

        int y = Math.abs(preset[from][0] - preset[to][0]);
        int x = Math.abs(preset[from][1] - preset[to][1]);

        int result = Math.min(y, x) * 3 + 2 * (Math.abs(y - x));
        if (from == to)
            result = 1;
        // System.out.println(from + "-> " + to + ": " + result);
        return result;
    }
}

// class StateData implements Comparable<StateData> {
// int strIndex;
// int distance;
// int big;
// int small;

// public StateData(int strIndex, int distance, int big, int small) {
// this.strIndex = strIndex;
// this.distance = distance;
// this.big = big;
// this.small = small;
// }

// @Override
// public int compareTo(StateData o) {
// return distance - o.distance;
// }

// @Override
// public String toString() {
// return "index: " + strIndex + ", dist: " + distance + " [" + big + "," +
// small + "]";
// }
// }