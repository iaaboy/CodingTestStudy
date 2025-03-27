package acmicpc33667;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.YearMonth;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());
        StringBuilder answer = new StringBuilder();

        StringBuilder debuSB = new StringBuilder();
        for (int i = 0; i < T; i++) {
            LocalDateTime start = getTime(bf.readLine());
            LocalDateTime end = getTime(bf.readLine());
            
            long pastDay = ChronoUnit.DAYS.between(start, end);
            debuSB.append("pDay: " + pastDay).append("\n");

            String unit = bf.readLine();
            if (unit.contentEquals("Year")) {
                Double startYear = getYear(start);
                Double endYear = getYear(end);
                answer.append((long) (endYear - startYear)).append("\n");
            } else if (unit.contentEquals("Month")) {
                Double startMonth = getMonth(start);
                Double endMonth = getMonth(end);
                answer.append((long) (endMonth - startMonth)).append("\n");
            } else if (unit.contentEquals("Day")) {
                Double startDay = getDay(start);
                Double endDay = getDay(end);
                debuSB.append(startDay).append(" : ").append(endDay).append("\n");
                debuSB.append(endDay - startDay);
                Double result = (endDay - startDay);
                // long r = (long)Math.floor(result);
                long r = (long)(endDay - startDay);
                answer.append(r).append("\n");
            }
        }

        System.out.print(answer);
        // System.out.println(debuSB);;
    }

    private static Double getYear(LocalDateTime start) {
        LocalDateTime startMask = LocalDateTime.of(start.getYear(), 1, 1, 0, 0, 0);
        long pastSecond = ChronoUnit.SECONDS.between(startMask, start);
        long dayInYear = YearMonth.of(start.getYear(), start.getMonth()).lengthOfYear();
        Double yearVal = pastSecond / (dayInYear * 24 * 60 * 60.0) + start.getYear();
        return yearVal;
    }

    private static Double getMonth(LocalDateTime start) {
        LocalDateTime startMask = LocalDateTime.of(start.getYear(), start.getMonth(), 1, 0, 0, 0);
        long pastSecond = ChronoUnit.SECONDS.between(startMask, start);
        long daysInMonth = YearMonth.of(start.getYear(), start.getMonth()).lengthOfMonth();
        Double monthVal = pastSecond / (daysInMonth * 24 * 60 * 60.0)
                + (Double) (start.getYear() * 12.0) + getM(start);
        return monthVal;
    }

    private static Double getDay(LocalDateTime start) {
        LocalDateTime startMask = LocalDateTime.of(start.getYear(), start.getMonth(), start.getDayOfMonth(), 0,
                0, 0);
        long startOffsetSecond = ChronoUnit.SECONDS.between(startMask, start);
        Double startDay = startOffsetSecond / (24 * 60 * 60.0) + getD(start);
        return startDay;
    }

    private static double getD(LocalDateTime t) {
        LocalDateTime base = LocalDateTime.of(0, 1, 1, 0, 0, 0);
        return ChronoUnit.DAYS.between(base, t);
    }

    private static double getM(LocalDateTime t) {
        LocalDateTime base = LocalDateTime.of(0, 1, 1, 0, 0, 0);
        return ChronoUnit.MONTHS.between(base, t);
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

