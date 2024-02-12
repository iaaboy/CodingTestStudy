package prog72414;

import java.util.Arrays;

/* 광고 삽입
 * https://school.programmers.co.kr/learn/courses/30/lessons/72414
 */

public class MyMain {
    public static void main(String[] args) {
        String[] play_time = { "00:00:02", "02:03:55", "99:59:59", "50:00:00" };
        String[] adv_time = { "00:00:01", "00:14:15", "25:00:00", "50:00:00" };
        String[][] logSs = {
                { "00:00:00-00:00:02",
                        "00:00:01-00:00:02",
                        "00:00:00-00:00:01",
                },
                { "01:20:15-01:45:14",
                        "00:40:31-01:00:00",
                        "00:25:50-00:48:29",
                        "01:30:59-01:53:29",
                        "01:37:44-02:02:30" }, // "01:30:59"
                { "69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00" }, // "01:00:00"
                { "15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45" },
        };// "00:00:00"

        Solution mSol = new Solution();
        for (int i = 0; i < 3; i++) {
            System.out.println(mSol.solution(play_time[i], adv_time[i], logSs[i]));
            break;
        }
    }
}

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = getTime(play_time);
        int adTime = getTime(adv_time);

        if (playTime == adTime)
            return "00:00:00";

        double[] playSum = new double[playTime + 1];

        for (int i = 0; i < logs.length; i++) {
            String[] l = logs[i].split("-");
            int start = getTime(l[0]);
            int end = getTime(l[1]);
            playSum[start]++;
            playSum[end]--;
        }

        printSum(playSum);

        double curSum = 0;
        for (int i = 0; i < playSum.length; i++) {
            curSum += playSum[i];
            playSum[i] = curSum;
        }

        printSum(playSum);

        curSum = 0;
        double sumMax = Double.MIN_VALUE;
        int maxIdx = 0;

        for (int i = 0; i < adTime; i++) {
            curSum += playSum[i];
            if (sumMax < curSum) {
                sumMax = curSum;
                maxIdx = i;
            }
        }

        for (int i = adTime; i < playSum.length; i++) {
            curSum = curSum - playSum[i - adTime] + playSum[i];
            if (sumMax < curSum) {
                sumMax = curSum;
                maxIdx = i;
                // System.out.println("new max :" + maxIdx + " -> " + curSum);
            }
        }

        printSum(playSum);
        // System.out.println("\nsumMax - " + sumMax + ": " + intToTimeString(maxIdx -
        // adTime + 1));
        return intToTimeString(maxIdx - adTime + 1);
    }

    void printSum(double[] playSum) {
        // for (int i = 0; i < playSum.length; i++) {
        // System.out.println(intToTimeString(i) + "(" + i + "): " + playSum[i]);
        // }
    }

    private String intToTimeString(int t) {
        int hour = t / 3600;
        int minute = (t / 60) % 60;
        int second = t % 60;
        return hour / 10 + "" + hour % 10 + ":" + minute / 10 + "" + minute % 10 + ":" + second / 10 + "" + second % 10;
    }

    private int getTime(String time) {
        String[] t = time.split(":");
        int hour = Integer.parseInt(t[0]) * 60 * 60;
        int minute = Integer.parseInt(t[1]) * 60;
        int second = Integer.parseInt(t[2]);
        return hour + minute + second;
    }
}