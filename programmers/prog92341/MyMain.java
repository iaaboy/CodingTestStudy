package prog92341;

import java.util.*;

/* 주차 요금 계산
 * https://school.programmers.co.kr/learn/courses/30/lessons/92341
 */
public class MyMain {
    public static void main(String[] args) {

        // 기본시간, 기본 요금, 단위 시간, 단위 요금
        int [] fees = {180, 5000, 10, 600};
        String [] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT","07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        // answer {14600, 34400, 5000}
        // int[] fees = { 120, 0, 60, 591 };
        // String[] records = { "16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN" };
        // answer {0, 591}
        // int [] fees = {1, 461, 1, 10};
        // String [] records = {"00:00 1234 IN"};
        // answer {14841}

        // int [] fees = {180, 5000, 10, 1000};
        // String [] records = {"20:39 0000 IN"};

        // [180, 5000, 10, 1000] / ["05:59 0000 IN", "05:59 1111 IN"] / [95000, 95000]

        Solution mSol = new Solution();
        System.out.println(Arrays.toString(mSol.solution(fees, records)));
    }
}

class Solution {
    int[] fees;

    public int[] solution(int[] fees, String[] records) {
        String[] rcd = {};
        int parkTime;
        int key;
        boolean inOut;
        HashMap<Integer, ParkInfo> pInfo = new HashMap<>();
        this.fees = fees;

        for (String r : records) {
            rcd = r.split(" ");
            String[] time = rcd[0].split(":");
            parkTime = 60 * Integer.parseInt(time[0]);
            parkTime += Integer.parseInt(time[1]);
            key = Integer.parseInt(rcd[1]);
            inOut = rcd[2].charAt(0) == 'I' ? true : false;

            if (!pInfo.containsKey(key)) {
                pInfo.put(key, new ParkInfo(0, parkTime));
            } else {
                if (inOut) { // In
                    pInfo.get(key).inTime = parkTime;
                } else { // Out
                    int inTime = pInfo.get(key).inTime;
                    int outTime = parkTime;
                    pInfo.get(key).total += outTime - inTime;
                    pInfo.get(key).inTime = -1;
                }
            }
        }

        for (ParkInfo p : pInfo.values()) {
            if (p.inTime != -1) {
                p.total += 24 * 60 - 1 - p.inTime;
            }
        }
        int[] answer = new int[pInfo.size()];
        TreeSet<Integer> kSet = new TreeSet<>();
        for (Integer k : pInfo.keySet()) {
            kSet.add(k);
        }

        int index = 0;
        for (int sortedKey : kSet) {
            answer[index] = fees[1];
            if (pInfo.get(sortedKey).total >= fees[0]) {
                answer[index] += fees[3] * ((pInfo.get(sortedKey).total - fees[0]) / fees[2]);
                if (((pInfo.get(sortedKey).total - fees[0]) % fees[2]) > 0)
                    answer[index] += fees[3];
            }
            index++;
        }

        // System.out.println(pInfo);

        return answer;
    }
}

class ParkInfo {
    int total;
    int inTime;

    public ParkInfo(int total, int inTime) {
        this.total = total;
        this.inTime = inTime;
    }

    @Override
    public String toString() {
        return "total:" + total + "in:" + inTime;
    }
}