package acmicpc1340;

import java.io.*;
import java.util.*;

/* 연도 진행바
 * https://www.acmicpc.net/problem/1340
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " |,|:");
        String[] monthMap = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        int month = 0;
        String monthString = st.nextToken();
        int day = Integer.parseInt(st.nextToken());
        int year = Integer.parseInt(st.nextToken());
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());

        boolean isLeapYear = (year % 400 == 0) | (year % 4 == 0 && year % 100 != 0);
        int[] dateOfMonth;
        if (isLeapYear) {
            dateOfMonth = new int[] { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        } else {
            dateOfMonth = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        }
        long passedDay = 0;
        for (int i = 0; i < monthMap.length; i++) {
            if (monthString.equals(monthMap[i])) {
                break;
            }
            passedDay += dateOfMonth[i];
        }
        passedDay += day - 1;
        long totalMinute = isLeapYear ? 366 * 24 * 60 : 365 * 24 * 60;
        long passedMinute = passedDay * 24 * 60 + hour * 60 + minute;
        double percent = 100 * (double) passedMinute / (double) totalMinute;
        System.out.println(percent);
    }
}
