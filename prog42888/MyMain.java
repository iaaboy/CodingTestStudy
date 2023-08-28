package prog42888;

import java.util.*;

/* 오픈채팅방
 * https://school.programmers.co.kr/learn/courses/30/lessons/42888
 */

public class MyMain {
    public static void main(String[] args) {
        String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
                "Change uid4567 Ryan" };

        Solution mSol = new Solution();
        System.out.println(Arrays.toString(mSol.solution(record)));
    }
}

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> idNameMap = new HashMap<>();
        ArrayList<String> uids = new ArrayList<>();
        ArrayList<Character> enterExit = new ArrayList<>();

        for (String r : record) {
            String[] subset = r.split(" ");
            if (subset[0].charAt(0) == 'E') {
                idNameMap.put(subset[1], subset[2]);
                uids.add(subset[1]);
                enterExit.add('E');
            } else if (subset[0].charAt(0) == 'L') {
                uids.add(subset[1]);
                enterExit.add('L');
            } else if (subset[0].charAt(0) == 'C') {
                idNameMap.put(subset[1], subset[2]);
            }
        }

        String[] answer = new String[uids.size()];

        for (int i = 0; i < uids.size(); i++) {
            StringBuilder answerS = new StringBuilder();
            answerS.append(idNameMap.get(uids.get(i)));
            answerS.append("님이 ");
            if (enterExit.get(i) == 'L') {
                answerS.append("나갔습니다.");
            } else {
                answerS.append("들어왔습니다.");
            }
            answer[i] = answerS.toString();
        }

        return answer;
    }
}