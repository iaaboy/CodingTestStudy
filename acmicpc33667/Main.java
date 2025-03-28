package acmicpc33667;

import java.io.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/* 루미의 28번째 생일
 * https://www.acmicpc.net/problem/33667
년 / 달 / 월 로 구분된 날짜를 단위수로 변환하고, 
나머지는 초로 변환하여 계산.
년단위의 경우 double로 연산이 불가하므로 소수점이 아닌 분수로 표현하여 계산해야함.
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder debuSB = new StringBuilder();

        // String time = bf.readLine();
        // while (!time.isEmpty()) {
        //     System.out.println(getData(getTime(time), "Year"));
        //     System.out.println(getData(getTime(time), "Month"));
        //     System.out.println(getData(getTime(time), "Day"));
        //     time = bf.readLine();
        // }

        long T = Integer.parseInt(bf.readLine());
        StringBuilder answer = new StringBuilder();

        for (long i = 0; i < T; i++) {
            LocalDateTime start = getTime(bf.readLine());
            LocalDateTime end = getTime(bf.readLine());

            String unit = bf.readLine();

            CustomDate st = getData(start, unit);
            CustomDate ed = getData(end, unit);
            // debuSB.append(st + " - " + ed + " : ").append(ed.minus(st)).append("\n");
            answer.append(ed.minus(st)).append("\n");
        }

        System.out.print(answer);
        // System.out.print(debuSB);
    }

    private static CustomDate getData(LocalDateTime time, String unit) {
        LocalDateTime startSecondMask = null;
        long data = 0;
        long base = 24 * 60 * 60;
        if (unit.contentEquals("Year")) {
            startSecondMask = LocalDateTime.of(time.getYear(), 1, 1, 0, 0, 0);
            data = time.getYear();
            long year = time.getYear();
            long daysInYear = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) ? 366 : 365;
            base *= daysInYear;
        } else if (unit.contentEquals("Month")) {
            startSecondMask = LocalDateTime.of(time.getYear(), time.getMonthValue(), 1, 0, 0, 0);
            data = time.getYear() * 12 + time.getMonthValue();
            long month = time.getMonthValue();
            long year = time.getYear();
            long daysInMonth = (month == 2) ? (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0) ? 29 : 28)
                    : (month == 4 || month == 6 || month == 9 || month == 11 ? 30 : 31);
            base *= daysInMonth;
        } else {
            startSecondMask = LocalDateTime.of(time.getYear(), time.getMonthValue(), time.getDayOfMonth(), 0, 0, 0);
            data = ChronoUnit.DAYS.between(LocalDateTime.of(1, 1, 1, 0, 0, 0), time);
        }
        long pastSecond = ChronoUnit.SECONDS.between(startSecondMask, time);
        CustomDate customDate = new CustomDate(unit, data, pastSecond, base);
        return customDate;
    }

    static class CustomDate {
        long data;
        long secondOffset;
        long base;
        String type;

        public CustomDate(String type, long data, long secondOffset, long base) {
            this.secondOffset = secondOffset;
            this.type = type;
            this.data = data;
            this.base = base;
        }

        @Override
        public String toString() {
            return data + "(" + type + ") + " + secondOffset + "/" + base;
        }

        public long minus(CustomDate you) {
            if (this.type == you.type) {
                long mResult = secondOffset * you.base - you.secondOffset * base;
                if (mResult < 0) {
                    mResult = -1;
                } else {
                    mResult = 0;
                }
                return data - you.data + mResult;
            } else {
                System.out.println("Error: Type mismatch");
                return 0;
            }
        }
    }

    private static LocalDateTime getTime(String line) {
        StringTokenizer st = new StringTokenizer(line);
        String y = st.nextToken();
        String pattern = "y".repeat(y.length()) + " ";

        String M = st.nextToken();
        pattern += "M".repeat(M.length()) + " ";

        String d = st.nextToken();
        pattern += "d".repeat(d.length()) + " ";

        String H = st.nextToken();
        pattern += "H".repeat(H.length()) + " ";

        String m = st.nextToken();
        pattern += "m".repeat(m.length()) + " ";

        String s = st.nextToken();
        pattern += "s".repeat(s.length());

        DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime sd = LocalDateTime.parse(line, format);

        return sd;
    }
}
