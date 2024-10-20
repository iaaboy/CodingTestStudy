package prog155651;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        String[][] bTime = { { "09:10", "10:10" }, { "10:10", "12:20" } };
        // String[][] bTime = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20",
        // "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};

        Solution mSol = new Solution();
        mSol.solution(bTime);
    }
}

class Solution {
    public int solution(String[][] book_time) {
        ArrayList<TimeLog> timeLog = new ArrayList<TimeLog>();

        for (String[] bt : book_time) {
            timeLog.add(convertTime(bt[0], 1));
            timeLog.add(convertTime(bt[1], -1));
        }

        timeLog.sort((it, that) -> {
            if (it.time > that.time) {
                return 1;
            } else if (it.time == that.time) {
                if (it.sig < that.sig) {
                    return -1;
                } else
                    return 1;
            } else {
                return -1;
            }
        });

        int curMax = 0;
        int curDepth = 0;
        for (TimeLog tl : timeLog) {
            if (tl.sig > 0) {
                curDepth++;
                if (curDepth > curMax) {
                    curMax = curDepth;
                }
            } else {
                curDepth--;
            }
        }

        System.out.println(timeLog);
        System.out.println(curMax);

        return curMax;
    }

    private TimeLog convertTime(String time, int sig) {
        String[] numString = time.split(":");

        int hour = Integer.parseInt(numString[0]);
        int min = Integer.parseInt(numString[1]);
        int result = hour * 60 + min;
        if (sig == -1) {
            result += 10;
        }
        // System.out.println(result);
        return new TimeLog(result, sig);
    }
}

class TimeLog {
    int time; // 시작 시간
    int sig; // 시작(1)인지, 종료(-1)인지.

    public TimeLog(int time, int sig) {
        this.time = time;
        this.sig = sig;
    }

    @Override
    public String toString() {
        return time + "," + sig;
    }
}