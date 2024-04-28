package prog17676;

import java.time.*;

/* [1차] 추석 트래픽
 * https://school.programmers.co.kr/learn/courses/30/lessons/17676
 */

public class MyMain {
    public static void main(String[] args) {
        String[][] lines = {
                { "2016-09-15 23:59:59.999 0.001s" },
                { "2016-09-15 01:00:04.001 2.0s",
                        "2016-09-15 01:00:07.000 2s" },
                { "2016-09-15 01:00:04.002 2.0s",
                        "2016-09-15 01:00:07.000 2s" },
                { "2016-09-15 20:59:57.421 0.351s",
                        "2016-09-15 20:59:58.233 1.181s",
                        "2016-09-15 20:59:58.299 0.8s",
                        "2016-09-15 20:59:58.688 1.041s",
                        "2016-09-15 20:59:59.591 1.412s",
                        "2016-09-15 21:00:00.464 1.466s",
                        "2016-09-15 21:00:00.741 1.581s",
                        "2016-09-15 21:00:00.748 2.31s",
                        "2016-09-15 21:00:00.966 0.381s",
                        "2016-09-15 21:00:02.066 2.62s" }
        };
        Solution mSol = new Solution();
        for (int i = 0; i < lines.length; i++) {
            System.out.println(mSol.solution(lines[i]));
        }
    }
}

class Solution {
    int n;
    TR[] traffics;

    public int solution(String[] lines) {
        n = lines.length;
        traffics = new TR[n];
        int index = 0;
        for (String s : lines) {
            String[] separated = s.split(" ");
            LocalDateTime replyTime = LocalDateTime.parse(separated[0] + "T" + separated[1]);
            long processTime = 0;
            String processT = separated[2].replace("s", "");
            if (!processT.contains(".")) {
                processTime = Integer.parseInt(processT) * 1000;
            } else {
                processT = processT.replace(".", "");
                processTime = Integer.parseInt(processT) * ((int) Math.pow(10, 4 - processT.length()));
            }
            processTime--;
            long end = replyTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();// - 1473868800000l;
            long start = end - processTime;
            // System.out.println(tToStr(start) + " -> " + tToStr(end));
            traffics[index++] = new TR(start, end);
        }

        Integer[] trStartIdx = new Integer[n];
        Integer[] trEndIdx = new Integer[n];
        for (int i = 0; i < n; i++) {
            trEndIdx[i] = i;
            trStartIdx[i] = i;
        }

        // System.out.println("start");
        // for (int i = 0; i < trStartIdx.length; i++) {
        // System.out.print(traffics[trStartIdx[i]].start + ", ");
        // }
        // System.out.println("\nend");
        // for (int i = 0; i < trEndIdx.length; i++) {
        // System.out.print(traffics[trEndIdx[i]].end + ", ");
        // }
        // System.out.println();

        int answer = 0;

        // 시작 ~ 끝
        for (int i = 0; i < n; i++) {
            long startRange = traffics[trStartIdx[i]].start;
            long endRange = startRange + 999;

            int count = 0;
            for (int j = 0; j < n; j++) {
                if (traffics[j].start <= endRange && traffics[j].end >= startRange) {
                    count++;
                }
            }
            answer = Math.max(answer, count);
            // System.out.println(startRange + ": " + count);
        }

        // 시작 ~ 끝
        for (int i = 0; i < n; i++) {
            long startRange = traffics[trEndIdx[i]].end;
            long endRange = startRange + 999;

            int count = 0;
            for (int j = 0; j < lines.length; j++) {
                if (traffics[j].start <= endRange && traffics[j].end >= startRange) {
                    count++;
                }
            }
            answer = Math.max(answer, count);
            // System.out.println(startRange + ": " + count);
        }

        return answer;
    }

    String tToStr(long time) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault()).toString();
    }

    class TR {
        long start;
        long end;

        public TR(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }
}