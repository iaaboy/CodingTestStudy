package prog42897;

public class MyMain {
    public static void main(String[] args) {
        int[] money = { 1, 2, 3 };

        // int[] money = new int[5];
        // Random rn = new Random();
        // for (int i = 0; i < money.length; i++) {
        // money[i] = rn.nextInt(10) + 1;
        // }

        Solution mSol = new Solution();
        System.out.println(mSol.solution(money));
    }
}

class Solution {
    public int solution(int[] money) {
        int answer = Integer.MIN_VALUE;

        int len = money.length;
        int[] dpBase = new int[len];
        int[] dpSecond = new int[len];

        dpBase[0] = money[0];
        dpBase[1] = money[0];
        dpSecond[0] = 0;
        dpSecond[1] = money[1];

        for (int i = 2; i < len; i++) {
            dpBase[i] = Math.max(dpBase[i - 1], dpBase[i - 2] + money[i]);
            dpSecond[i] = Math.max(dpSecond[i - 1], dpSecond[i - 2] + money[i]);
        }

        // System.out.println(Arrays.toString(dpBase));
        // System.out.println(Arrays.toString(dpSecond));

        answer = Math.max(dpBase[len - 2], dpSecond[len - 1]);

        return answer;
    }
}
