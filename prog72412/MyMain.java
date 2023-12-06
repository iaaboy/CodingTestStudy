package prog72412;

import java.util.*;

/* 순위 검색
 * https://school.programmers.co.kr/learn/courses/30/lessons/72412
 */

public class MyMain {
    public static void main(String[] args) {
        String[] info = {
                "java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"
        };
        String[] query = {
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"
        };

        Solution mSol = new Solution();
        System.out.println(Arrays.toString(mSol.solution(info, query)));
    }
}
// Language [java, cpp, python ]
// Job [backend, frontend]
// Career [senior, junior]
// Soul food [chicken, pizza]

class Solution {
    Record[][][][] mRecord = new Record[3 + 1][2 + 1][2 + 1][2 + 1];

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        for (int a = 0; a < 3; a++)
            for (int b = 0; b < 2; b++)
                for (int c = 0; c < 2; c++)
                    for (int d = 0; d < 2; d++)
                        mRecord[a][b][c][d] = new Record();

        for (String str : info) {
            String[] s = str.split(" ");
            int score = Integer.parseInt(s[4]);
            int lang = 0;
            if (s[0].charAt(0) == 'c') {
                lang = 1;
            } else if (s[0].charAt(0) == 'p') {
                lang = 2;
            }
            int job = s[1].charAt(0) == 'f' ? 0 : 1;
            int carrier = s[2].charAt(0) == 's' ? 0 : 1;
            int soulFood = s[3].charAt(0) == 'c' ? 0 : 1;
            setScore(lang, job, carrier, soulFood, score);
        }

        for (int a = 0; a < 3; a++)
            for (int b = 0; b < 2; b++)
                for (int c = 0; c < 2; c++)
                    for (int d = 0; d < 2; d++) {
                        Collections.sort(mRecord[a][b][c][d].s);
                        // System.out.println(a + "," + b + "," + c + "," + d + ":" + mRecord[a][b][c][d].s);
                    }

        Set<Score> scores = new HashSet<>();
        int answerIdx = 0;
        for (String str : query) {
            scores.clear();
            str = str.replace("and ", "");
            String[] s = str.split(" ");
            int lang = 0;
            if (s[0].charAt(0) == 'c') {
                lang = 1;
            } else if (s[0].charAt(0) == 'p') {
                lang = 2;
            } else if (s[0].charAt(0) == '-') {
                lang = 10;
            }
            int job = s[1].charAt(0) == 'f' ? 0 : 1;
            if (s[1].charAt(0) == '-') {
                job = 10;
            }
            int carrier = s[2].charAt(0) == 's' ? 0 : 1;
            if (s[2].charAt(0) == '-') {
                carrier = 10;
            }
            int soulFood = s[3].charAt(0) == 'c' ? 0 : 1;
            if (s[3].charAt(0) == '-') {
                soulFood = 10;
            }

            for (int a = 0; a < 3; a++) {
                for (int b = 0; b < 2; b++) {
                    for (int c = 0; c < 2; c++) {
                        for (int d = 0; d < 2; d++) {
                            // System.out.println(a + "," + b + "," + c + "," + d);
                            if ((a == lang || lang == 10) && (job == b || job == 10)
                                    && (carrier == c || carrier == 10) && (soulFood == d || soulFood == 10)) {
                                scores.addAll(mRecord[a][b][c][d].s);
                            }
                        }
                    }
                }
            }
            Set <Integer> nums = new HashSet<>();
            int num = Integer.parseInt(s[4]);

            
            for(Score sc : scores) {
                if(sc.s < num) {
                    break;
                }
                nums.add(sc.index);
            }
            answer[answerIdx++] = nums.size();
        }



        return answer;
    }

    // Language [java, cpp, python ]
    // Job [backend, frontend]
    // Career [senior, junior]
    // Soul food [chicken, pizza]
    int scoreIndex = 1;

    void setScore(int lang, int job, int career, int soufFood, int score) {
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 2; b++) {
                for (int c = 0; c < 2; c++) {
                    for (int d = 0; d < 2; d++) {
                        // System.out.println(a + "," + b + "," + c + "," + d);
                        if (a == lang && job == b && career == c && soufFood == d) {
                            mRecord[a][b][c][d].s.add(new Score(scoreIndex++, score));
                        }
                    }
                }
            }
        }
    }
}

class Record {
    Vector<Score> s = new Vector<>();
}

class Score implements Comparable<Score> {
    int index;
    int s;

    public Score(int index, int s) {
        this.index = index;
        this.s = s;
    }

    @Override
    public boolean equals(Object obj) {
        return index == ((Score) obj).index;
    }

    @Override
    public int compareTo(Score o) {
        if (s == o.s) {
            return index - o.index;
        }
        return s - o.s;
    }

    @Override
    public int hashCode() {
        return index;
    }

    @Override
    public String toString() {
        return index + "," + s;
    }
}