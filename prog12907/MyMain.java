package prog12907;

import java.util.Arrays;

class MyMain {
    public static void main(String[] args) {
        int n = 6;
        int[] money = { 1, 2, 3 };
        Solution mSol = new Solution();
        System.out.println(mSol.solution(n, money));
    }
}

class Solution {
    public int solution(int n, int[] money) {
        int [] usedCount = new int [money.length];
        checkRest(n, money, usedCount);

        int answer = 0;
        return answer;
    }

    private void checkRest(int n, int[] money, int[] usedCount) {
        if(n == 0) {
            System.out.println("solved" + Arrays.toString(usedCount));
        }

        for(int i = 0; i < money.length ; i++) {
            if(n - money[i] >= 0) {
                usedCount[i]++;
                checkRest(n - money[i], money, usedCount);
                usedCount[i]--;
            }
        }
    }
}