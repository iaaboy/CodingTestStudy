package prog42861;

import java.util.*;

//최소 비용으로 모든 섬을 도달시 비용을 구함.
//가장 비용이 작은 이웃을 찾는다.
//프림 알고리즘 사용.

public class MyMain {
    public static void main(String[] args) {
        int[][] costs = { { 0, 1, 1 }, { 3, 1, 1 }, { 0, 2, 2 }, { 0, 3, 2 }, { 0, 4, 100 } };
        int n = 5;

        Solution mSol = new Solution();
        System.out.println(mSol.solution(n, costs));
    }
}

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;

        int[][] links = new int[n][n];
        for (int[] c : costs) {
            links[c[0]][c[1]] = c[2];
            links[c[1]][c[0]] = c[2];
        }

        Set<Integer> myGroup = new HashSet<>();

        myGroup.add(costs[0][0]);

        while (myGroup.size() < n) {
            int curMin = Integer.MAX_VALUE;
            int idx = 0;
            int myVer = 0;
            for (int ver : myGroup) {
                for (int i = 0; i < n; i++) {
                    if (links[ver][i] != 0 && links[ver][i] < curMin) {
                        if (!myGroup.contains(i)) {
                            curMin = links[ver][i];
                            idx = i;
                            myVer = ver;
                        }
                    }
                }
            }
            myGroup.add(idx);
            System.out.println("s" + myVer + "e" + idx + myGroup);
            answer += links[myVer][idx];
        }

        System.out.println(myGroup);
        return answer;
    }
}