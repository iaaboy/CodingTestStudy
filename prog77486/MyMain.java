package prog77486;

import java.util.*;

/* 다단계 칫솔 판매
 * https://school.programmers.co.kr/learn/courses/30/lessons/77486
 */

public class MyMain {
    public static void main(String[] args) {
        String[][] enrols = {
                { "john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young" },
                { "john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young" },
        };
        String[][] referrals = {
                { "-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward" },
                { "-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward" }
        };
        String[][] sellers = {
                { "young", "john", "tod", "emily", "mary" },
                { "sam", "emily", "jaimie", "edward" }
        };
        int[][] amounts = {
                { 12, 4, 2, 5, 10 }, // [360, 958, 108, 0, 450, 18, 180, 1080]
                { 2, 3, 5, 4 },// [0, 110, 378, 180, 270, 450, 0, 0]
        };
        Solution mSol = new Solution();
        for (int i = 0; i < 2; i++) {
            System.out.println(Arrays.toString(mSol.solution(enrols[i], referrals[i], sellers[i], amounts[i])));
        }
    }
}

class Solution {
    HashMap<String, Enroll> nMap;

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        nMap = new HashMap<>(); // (key : 이름 , data Enroll)
        for (int i = 0; i < enroll.length; i++) {
            nMap.put(enroll[i], new Enroll(referral[i], 0));
        }
        nMap.put("-", new Enroll(".", 0)); // center

        for (int i = 0; i < seller.length; i++) {
            updateAmount(seller[i], amount[i] * 100);
        }

        System.out.println("Map: " + nMap);

        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = nMap.get(enroll[i]).amount;
        }

        return answer;
    }

    private void updateAmount(String me, int rest) { // 부모를 찾아가면서 값을 업데이트
        int tribute = rest / 10;
        int myRest = rest - tribute;
        Enroll myEnroll = nMap.get(me);
        if (me.equals("-")) {// 센터에 도달하면, 더이상 부모를 찾을 필요 없음
            myRest = rest;
            tribute = 0;
            myEnroll.amount += myRest;
            return;
        }

        myEnroll.amount += myRest;
        if (tribute > 0)
            updateAmount(myEnroll.parent, tribute);
    }

    class Enroll {
        String parent;
        int amount;

        public Enroll(String parent, int amount) {
            this.parent = parent;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return " <" + parent + "," + amount + "> \n";
        }
    }
}