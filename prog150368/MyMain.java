package prog150368;

import java.util.Arrays;

public class MyMain {
    public static void main(String[] args) {

        // int[][] users = { { 40, 10000 }, { 25, 10000 } };
        // int[] emoticons = { 7000, 9000 };
        int[][] users2 = { { 40, 2900 }, { 23, 10000 }, { 11, 5200 }, { 5, 5900 }, { 40, 3100 },
                { 27, 9200 }, { 32, 6900 } };
        int[] emoticons2 = { 1300, 1500, 1600, 4900 };

        Solution mSol = new Solution();
        System.out.println(Arrays.toString(mSol.solution(users2, emoticons2)));
    }
}

class Solution {
    int[] saleBase = { 10, 20, 30, 40 };
    int[] emoticons;
    int[][] users;

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        this.emoticons = emoticons;
        this.users = users;
        int[] r = new int[emoticons.length];
        permu(r, 0);

        answer[1] = maxTotal;
        answer[0] = maxSub;
        return answer;
    }

    void permu(int[] curRate, int depth) {
        if (depth == curRate.length) {
            // System.out.println(Arrays.toString(curRate));

            checkUsers(curRate);
            // System.out.println();
            return;
        }

        for (int i = 0; i < saleBase.length; i++) {
            curRate[depth] = saleBase[i];
            permu(curRate, depth + 1);
        }
    }

    int maxSub = Integer.MIN_VALUE;
    int maxTotal = Integer.MIN_VALUE;

    void checkUsers(int[] saleRate) {
        int subscriberCount = 0;
        int total = 0;
        for (int u = 0; u < users.length; u++) {
            int subTotal = 0;
            for (int i = 0; i < saleRate.length; i++) {
                if (saleRate[i] >= users[u][0]) {
                    // System.out.println("user[" + u + "] Buy it: " + i + ", sale rate: " +
                    // saleRate[i]
                    // + ", emozy price: " + emoticons[i] * (100 - saleRate[i]) / 100);
                    subTotal += emoticons[i] * (100 - saleRate[i]) / 100;
                } else {
                    // System.out.println("user[" + u + "] Not Buy it: " + i + ", sale rate: " +
                    // saleRate[i]);
                }

                if (subTotal >= users[u][1]) {
                    // System.out.println("user[" + u + "] Subscribe it: " + subTotal + ", users
                    // rate: " + users[u][1]);
                    subscriberCount++;
                    subTotal = 0;
                    break;
                }
            }

            total += subTotal;
        }
        // System.out.println("Sub count: " + subscriberCount + ", total : " + total);

        if (subscriberCount > maxSub) {
            maxSub = subscriberCount;
            maxTotal = total;
        } else if (subscriberCount == maxSub && total > maxTotal) {
            maxTotal = total;
        }
    }
}