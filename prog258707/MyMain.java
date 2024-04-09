package prog258707;

import java.util.Arrays;

/* n + 1 카드게임
 * https://school.programmers.co.kr/learn/courses/30/lessons/258707
 */

public class MyMain {
    public static void main(String[] args) {
        int[] coins = { 1, 4, 3, 2, 10 };
        int[][] cards = {
                { 1, 2, 3, 9, 4, 6, 7, 8, 5, 10, 11, 12, }, // 5
                { 3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4 }, // 5
                { 1, 2, 3, 4, 5, 8, 6, 7, 9, 10, 11, 12 }, // 2
                { 5, 8, 1, 2, 9, 4, 12, 11, 3, 10, 6, 7 }, // 4
                { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18 },// 1
        };

        Solution mSol = new Solution();
        for (int i = 0; i < 1; i++) {
            System.out.println(mSol.solution(coins[i], cards[i]));
        }
    }
}

class Solution {
    public int solution(int coin, int[] cards) {
        int n = cards.length;
        int[] cardIndex = new int[n + 1];
        int[] needs = new int[n];
        Arrays.fill(needs, -1);
        Arrays.fill(cardIndex, -1);

        for (int i = 0; i < cards.length; i++) {
            int jackPartner = n + 1 - cards[i];
            if (cardIndex[jackPartner] != -1) {
                if (i < n / 3) {
                    needs[i] = 0;
                } else {
                    if (cardIndex[jackPartner] < n / 3) {
                        needs[i] = 1;
                    } else {
                        needs[i] = 2;
                    }
                }
            } else {
                cardIndex[cards[i]] = i;
            }
        }

        int[] needSum = new int[3];
        for (int i = 0; i < n / 3 + 1; i++) {
            if (needs[i] != -1) {
                needSum[needs[i]]++;
            }
        }

        System.out.println(Arrays.toString(needs));
        System.out.println(Arrays.toString(needSum));

        int round = 1;
        for (int i = n / 3 + 1; i < n; i++) {
            if (needs[i] != -1) {
                needSum[needs[i]]++;
            }
            if (i % 2 == 1) {
                boolean canProceed = false;
                for (int coinCnt = 0; coinCnt < needSum.length; coinCnt++) {
                    if (needSum[coinCnt] > 0) {
                        coin -= coinCnt;
                        needSum[coinCnt]--;
                        canProceed = true;
                        break;
                    }
                }
                if (!canProceed) {
                    return round;
                }
                if (coin < 0) {
                    return round;
                }
                round++;
            }
        }
        return round;
    }
}