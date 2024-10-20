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
    public int[] solution(String[] info, String[] query) {
        HashMap<String, Integer> keyMap = new HashMap<>();
        keyMap.put("Ljcp", 0);
        keyMap.put("Ljc", 1);
        keyMap.put("Ljp", 2);
        keyMap.put("Lcp", 3);
        keyMap.put("Lj", 4);
        keyMap.put("Lc", 5);
        keyMap.put("Lp", 6);
        keyMap.put("Jfb", 0);
        keyMap.put("Jf", 1);
        keyMap.put("Jb", 2);
        keyMap.put("Csj", 0);
        keyMap.put("Cs", 1);
        keyMap.put("Cj", 2);
        keyMap.put("Scp", 0);
        keyMap.put("Sc", 1);
        keyMap.put("Sp", 2);

        String[] LangKeys = { "Ljcp", "Ljc", "Ljp", "Lcp", "Lj", "Lc", "Lp" };
        String[] JobKeys = { "Jfb", "Jf", "Jb" };
        String[] CarrKeys = { "Csj", "Cs", "Cj" };
        String[] SoulFoodKeys = { "Scp", "Sc", "Sp" };

        List<Integer>[][][][] scoreMap = new List[7][3][3][3];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 3; j++) {
                for (int j2 = 0; j2 < 3; j2++) {
                    for (int k = 0; k < 3; k++) {
                        scoreMap[i][j][j2][k] = new LinkedList<>();
                    }
                }
            }
        }

        for (int i = 0; i < info.length; i++) {
            String[] member = info[i].split(" ");
            char chLang = member[0].charAt(0);
            char chjob = member[1].charAt(0);
            char chCarreer = member[2].charAt(0);
            char chSoulFood = member[3].charAt(0);
            int score = Integer.parseInt(member[4]);

            for (String lang : LangKeys) {
                if (hasChar(lang, chLang)) {
                    for (String job : JobKeys) {
                        if (hasChar(job, chjob)) {
                            for (String carr : CarrKeys) {
                                if (hasChar(carr, chCarreer)) {
                                    for (String soulfood : SoulFoodKeys) {
                                        if (hasChar(soulfood, chSoulFood)) {
                                            scoreMap[keyMap.get(lang)][keyMap.get(job)][keyMap.get(carr)][keyMap
                                                    .get(soulfood)].add(score);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 3; j++) {
                for (int j2 = 0; j2 < 3; j2++) {
                    for (int k = 0; k < 3; k++) {
                        scoreMap[i][j][j2][k].sort(null);
                        // if (scoreMap[i][j][j2][k].size() > 0)
                        // System.out.println(i + "," + j + "," + j2 + "," + k + "," +
                        // scoreMap[i][j][j2][k]);
                    }
                }
            }
        }

        int[] answer = new int[query.length];
        int index = 0;
        for (String q : query) {
            String[] qSepa = q.split(" ");
            String keyLang = "L" + (qSepa[0].charAt(0) == '-' ? "jcp" : qSepa[0].charAt(0));
            String keyJob = "J" + (qSepa[2].charAt(0) == '-' ? "fb" : qSepa[2].charAt(0));
            String keyCarr = "C" + (qSepa[4].charAt(0) == '-' ? "sj" : qSepa[4].charAt(0));
            String keySoulFood = "S" + (qSepa[6].charAt(0) == '-' ? "cp" : qSepa[6].charAt(0));
            Integer targetScore = Integer.parseInt(qSepa[7]);

            // System.out.println(keyLang + " " + keyJob + " " + keyCarr + " " + keySoulFood
            // + " " + targetScore);
            List<Integer> scoreList = scoreMap[keyMap.get(keyLang)][keyMap.get(keyJob)][keyMap.get(keyCarr)][keyMap
                    .get(keySoulFood)];
            int ub = lowerBound(scoreList, targetScore);
            // System.out.println(targetScore + ": " + ub + " ----> " + scoreList);
            answer[index] = scoreList.size() - ub;
            index++;
        }

        return answer;
    }

    private static int lowerBound(List<Integer> arr, int target) {
        int start = 0;
        int end = arr.size();

        while (start < end) {
            int mid = (start + end) / 2;

            if (arr.get(mid) >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

    private boolean hasChar(String string, char lang) {
        for (char ch : string.toCharArray()) {
            if (ch == lang) {
                return true;
            }
        }
        return false;
    }
}