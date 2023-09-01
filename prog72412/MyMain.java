package prog72412;

import java.util.Arrays;

public class MyMain {
    public static void main(String[] args) {
        String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
                "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
                "python backend senior chicken 50" };
        String[] query = { "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };

        Solution mSol = new Solution();
        System.out.println(Arrays.toString(mSol.solution(info, query)));
    }
}

class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Condition[] information = new Condition[info.length];

        int index = 0;
        for (String str : info) {
            String[] s = str.split(" ");
            information[index++] = new Condition(s[0].charAt(0), s[1].charAt(0), s[2].charAt(0), s[3].charAt(0),
                    Integer.parseInt(s[4]));
        }

        index = 0;
        for (String str : query) {
            str = str.replace("and ", "");
            String[] s = str.split(" ");
            int count = 0;
            for (Condition c : information) {
                if ((s[0].charAt(0) == '-' || c.lang == s[0].charAt(0))
                        && (s[1].charAt(0) == '-' || c.jobGroup == s[1].charAt(0))
                        && (s[2].charAt(0) == '-' || c.exp == s[2].charAt(0))
                        && (s[3].charAt(0) == '-' || c.soulFood == s[3].charAt(0))
                        && (s[4].charAt(0) == '-' || c.score >= Integer.parseInt(s[4]))) {
                    count++;
                }
            }
            answer[index++] = count;
        }
        return answer;
    }
}

class Condition {
    Character lang;
    Character jobGroup;
    Character exp;
    Character soulFood;
    int score;

    public Condition(Character lang, Character jobGroup, Character exp, Character soulFood, int score) {
        this.lang = lang;
        this.jobGroup = jobGroup;
        this.exp = exp;
        this.soulFood = soulFood;
        this.score = score;
    }
}