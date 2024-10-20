package prog250135;

import java.util.*;

/* [PCCP 기출문제] 3번
 * https://school.programmers.co.kr/learn/courses/30/lessons/250135
 */

public class MyMain {
    public static void main(String[] args) {
        int[] h1 = { 0, 12, 0, 11, 11, 1, 0 };
        int[] m1 = { 5, 0, 6, 59, 58, 5, 0 };
        int[] s1 = { 30, 0, 1, 30, 59, 5, 0 };
        int[] h2 = { 0, 12, 0, 12, 11, 1, 23 };
        int[] m2 = { 7, 0, 6, 0, 59, 5, 59 };
        int[] s2 = { 0, 0, 6, 0, 0, 6, 59 };
        // 2,1,0,1,1,2, 2852

        Solution mSol = new Solution();
        for (int i = 0; i < 7; i++)
            System.out.println(mSol.solution(h1[i], m1[i], s1[i], h2[i], m2[i], s2[i]));
    }
}

class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int count = 0;
        ;
        int tickStart = (h1 * 3600 + m1 * 60 + s1);
        int tickEnd = h2 * 3600 + m2 * 60 + s2;
        initHandDistance();
        HashMap<Integer, Integer> crossM = new HashMap<>(); // 초침 <-> 분침 지나침
        HashMap<Integer, Integer> crossH = new HashMap<>(); // 초침 <-> 시침 지나침
        HashMap<Integer, Integer> matchH = new HashMap<>(); // 초침 <-> 분침 or 시침 만남.

        int prevCross = -2; // 이전에 초침과 일치한 index
        for (int i = tickStart; i <= tickEnd; i++) {
            float current = i % 60;
            if (current == minutes[i]) {
                prevCross = i;
                // System.out.print(i + ": " + (current - minutes[i]) + "|");
                // System.out.println(minutes[i]);
                matchH.put(i, 1);
                continue;
            }
            current = current == 0 ? 60 : current;
            if ((current - minutes[i]) > 0 && (current - minutes[i]) < 1) {
                // System.out.print(i + ": " + (current - minutes[i]) + "|");
                // System.out.println(minutes[i]);
                if (tickStart != i && prevCross != i - 1) // 바로 이전에 초침과 일치한 index가 있으면 지나친 경우 무시
                    crossM.put(i, 1);
            }
        }
        prevCross = -2;
        for (int i = tickStart; i <= tickEnd; i++) {
            float current = i % 60;
            if (current == hours[i]) {
                prevCross = i;
                // System.out.print(i + ": " + (current - hours[i]) + "|");
                // System.out.println(hours[i]);
                if (matchH.containsKey(i)) {
                    matchH.put(i, 2);
                } else {
                    matchH.put(i, 1);
                }
                continue;
            }
            current = current == 0 ? 60 : current;
            if ((current - hours[i]) > 0 && (current - hours[i]) < 1) {
                // System.out.print(i + ": " + (current - hours[i]) + "|");
                // System.out.println(hours[i]);
                if (tickStart != i && prevCross != i - 1)
                    crossH.put(i, 1);
            }
        }

        // System.out.println("Minutes cross : " + crossM);
        // System.out.println("Hours cross: " + crossH);
        // System.out.println("Matchs: " + matchH);

        count = crossH.size() + crossM.size() + matchH.size();

        return count;
    }

    float[] minutes = new float[43200 * 2];
    float[] hours = new float[43200 * 2];

    void initHandDistance() { // 0시 0분으로부터 초당 갈 수 있는 거리 table초기화
        for (int i = 0; i < 43200 * 2; i++) {
            minutes[i] = (float) (i % 3600) / 60;
            hours[i] = (float) (i % 43200) / 720;
        }
    }
}