package prog17676;

import java.time.*;
import java.util.*;

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
            long end = replyTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
            long start = end - processTime;
            // System.out.println(tToStr(start) + " -> " + tToStr(end));
            traffics[index++] = new TR(start, end);
        }

        Integer[] trStartAligned = new Integer[n];
        Integer[] trEndAligned = new Integer[n];
        for (int i = 0; i < n; i++) {
            trEndAligned[i] = i;
            trStartAligned[i] = i;
        }

        Arrays.sort(trStartAligned, (a, b) -> {
            if (traffics[a].start > traffics[b].start) {
                return 1;
            } else {
                return -1;
            }
        });
        Arrays.sort(trEndAligned, (a, b) -> {
            if (traffics[a].end > traffics[b].end) {
                return 1;
            } else {
                return -1;
            }
        });

        // System.out.println("start");
        // for (int i = 0; i < trStartAligned.length; i++) {
        // System.out.print(traffics[trStartAligned[i]].start + ", ");
        // }
        // System.out.println("\nend");
        // for (int i = 0; i < trEndAligned.length; i++) {
        // System.out.print(traffics[trEndAligned[i]].end + ", ");
        // }

        // 시작시간 기준 push하고,
        // 종료시간 기준 pQ에 넣어 처리
        PriorityQueue<Integer> pQ = new PriorityQueue<>((a, b) -> {
            if (traffics[a].end > traffics[b].end) {
                return 1;
            } else {
                return -1;
            }
        });

        int answer = 1;
        int startIndex = 0;
        for (int i = 0; i < trEndAligned.length; i++) {
            // System.out.println();
            long curTime = traffics[trEndAligned[i]].end;
            // q push
            for (int j = startIndex; j < trStartAligned.length; j++) {
                if (curTime > traffics[trStartAligned[j]].start) {
                    // System.out.print(curTime + " -> push: " + traffics[trStartAligned[j]].end +
                    // "/"
                    // + traffics[trStartAligned[j]].end + "\n");
                    pQ.add(trStartAligned[j]);
                } else {
                    startIndex = j;
                    break;
                }
            }
            // 종료된 것 처리
            while (!pQ.isEmpty() && curTime > traffics[pQ.peek()].end) {
                // System.out
                // .print(curTime + " -> poll: " + traffics[pQ.peek()].end + "/" +
                // traffics[pQ.peek()].end + "\n");
                pQ.poll();
            }

            // 남은 것 count
            int count = 0;
            for (int j = startIndex; j < trStartAligned.length; j++) {
                if (i == j)
                    continue;
                if (curTime + 1000 > traffics[trStartAligned[j]].start) {
                    // System.out.println("check: " + (curTime + 1000) + " vs " +
                    // traffics[trStartAligned[j]].start);
                    count++;
                } else {
                    // System.out.println("pass : " + (curTime + 1000) + " vs " +
                    // traffics[trStartAligned[j]].start);
                    break;
                }
            }
            answer = Math.max(answer, count + pQ.size());
            // System.out
            // .println("count: " + count + " , qSize: " + pQ.size() + " , " +
            // traffics[trStartAligned[i]].start);
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