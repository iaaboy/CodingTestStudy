package prog17678;

import java.util.PriorityQueue;

/* [1차] 셔틀버스
 * https://school.programmers.co.kr/learn/courses/30/lessons/17678
 */

public class MyMain {
    public static void main(String[] args) {
        int[] n = { 1, 2, 2, 1, 1, 10 };
        int[] t = { 1, 10, 1, 1, 1, 60 };
        int[] m = { 5, 2, 2, 5, 1, 45 };
        String[][] timeTables = {
                { "08:00", "08:01", "08:02", "08:03" }, // "09:00"
                { "09:10", "09:09", "08:00" }, // "09:09"
                { "09:00", "09:00", "09:00", "09:00" }, // "08:59"
                { "00:01", "00:01", "00:01", "00:01", "00:01" }, // "00:00"
                { "23:59" }, // "09:00"
                { "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59",
                        "23:59", "23:59", "23:59", "23:59", "23:59" }// "18:00"
        };

        Solution mSol = new Solution();
        for (int i = 0; i < 6; i++) {
            System.out.println(mSol.solution(n[i], t[i], m[i], timeTables[i]));
        }
    }
}

class Solution {
    static int initialBus = 9 * 60;

    public String solution(int n, int t, int m, String[] timetable) {
        // n 운행 회수, //t 운행 간격, //m 셔틀당 최대 크루수
        PriorityQueue<Integer> timeQ = new PriorityQueue<>();

        for (String table : timetable) {
            String[] tbls = table.split(":");
            int hour = Integer.parseInt(tbls[0]);
            int minute = Integer.parseInt(tbls[1]);
            timeQ.add(hour * 60 + minute);
        }

        int lastRideCount = 0;
        int busArrivaltime = 0;
        int lastCrueArrival = 0;
        for (int i = 0; i < n; i++) {
            busArrivaltime = initialBus + i * t;
            // System.out.print("Ride Bus " + busArrivaltime + ":");
            lastRideCount = 0;
            for (int j = 0; j < m; j++) {
                if (!timeQ.isEmpty() && timeQ.peek() <= busArrivaltime) {
                    lastRideCount++;
                    lastCrueArrival = timeQ.poll();
                    // System.out.print(lastCrueArrival + " ");
                }
            }
            // System.out.println();
        }

        String answer = "";
        if (timeQ.isEmpty()) {
            // System.out.println("Ride All: " + m + ", " + lastRideCount + ", " +
            // busArrivaltime + ", " + timeQ.size());
            if (m > lastRideCount) {
                // 자리 남음
                answer = minuteToString(busArrivaltime);
            } else {
                // 자리 없음
                answer = minuteToString(lastCrueArrival - 1);
            }
        } else {
            if (m > lastRideCount) {
                // 자리 남음
                answer = minuteToString(busArrivaltime);
            } else {
                // 자리 없음
                answer = minuteToString(lastCrueArrival - 1);
            }
            // System.out.println("Ride Some: " + m + ", " + lastRideCount + ", " +
            // busArrivaltime + ", " + timeQ.size());
        }
        return answer;
    }

    private String minuteToString(int m) {
        int hour = m / 60;
        int h1 = hour / 10;
        int h2 = hour % 10;
        int min = m % 60;
        int m1 = min / 10;
        int m2 = min % 10;
        return (h1) + "" + (h2) + ":" + (m1) + "" + (m2);
    }
}