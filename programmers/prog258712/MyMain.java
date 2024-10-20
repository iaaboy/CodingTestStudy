package prog258712;

import java.util.*;

/* 가장 많이 받은 선물
 * https://school.programmers.co.kr/learn/courses/30/lessons/258712
 */

public class MyMain {
    public static void main(String[] args) {
        String[][] freiendsList = {
                { "muzi", "ryan", "frodo", "neo" },
                { "joy", "brad", "alessandro", "conan", "david" },
                { "a", "b", "c" }
        };
        String[][] giftsList = {
                { "muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan",
                        "neo muzi" },
                { "alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david" },
                { "a b", "b a", "c a", "a c", "a c", "c a" }
        };

        Solution mSol = new Solution();
        for (int i = 0; i < 1; i++) {
            System.out.println("answer:" + mSol.solution(freiendsList[i], giftsList[i]));
        }
    }
}

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int fCount = friends.length;
        HashMap<String, Integer> nameMap = new HashMap<>();
        int[][] giftMap = new int[fCount][fCount];
        int[] presentIndex = new int[fCount];
        int[] presentNextMonth = new int[fCount];

        //이름 -> index로 변환
        for (int i = 0; i < fCount; i++) {
            nameMap.put(friends[i], i);
        }

        //주고 받은 선물표
        for (String g : gifts) {
            String[] names = g.split(" ");
            giftMap[nameMap.get(names[0])][nameMap.get(names[1])]++;
        }

        //선물 지수 계산
        for (int i = 0; i < fCount; i++) {
            for (int j = 0; j < fCount; j++) {
                presentIndex[i] += giftMap[i][j]; //i가 j에게 줌
                presentIndex[i] -= giftMap[j][i]; //i가 j로부터 받음
            }
        }

        for (int i = 0; i < fCount; i++) {
            for (int j = 0; j < fCount; j++) {
                if (giftMap[i][j] > giftMap[j][i]) {  //서로 주고받은 것 계산
                    presentNextMonth[i]++;
                } else if (i > j /* 두번 호출 방지 */ && giftMap[i][j] == giftMap[j][i]) { // 같을 때에는 선물 지수 비교
                    if (presentIndex[i] > presentIndex[j]) {
                        presentNextMonth[i]++;
                    } else if (presentIndex[i] < presentIndex[j]) {
                        presentNextMonth[j]++;
                    }
                }
            }
        }

        //최대값을 answer로
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < fCount; i++) {
            answer = Math.max(answer, i);
        }

        //디버깅
        for (int i = 0; i < fCount; i++) {
            System.out.println(friends[i].substring(0, 2) + ":" + Arrays.toString(giftMap[i]));
        }
        System.out.println();
        System.out.println(Arrays.toString(presentIndex));
        System.out.println(Arrays.toString(presentNextMonth));

        return answer;
    }
}