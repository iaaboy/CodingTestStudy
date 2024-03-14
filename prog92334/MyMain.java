package prog92334;

import java.util.*;

/* 신고 결과 받기
 * https://school.programmers.co.kr/learn/courses/30/lessons/92334
 */

public class MyMain {
    public static void main(String[] args) {
        String[] idList = { "muzi", "frodo", "apeach", "neo" };
        String[] report = {
                "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"
        };
        int k = 2;
        Solution mSol = new Solution();

        System.out.println(Arrays.toString(mSol.solution(idList, report, k)));
    }
}

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashSet<String> reportSet = new HashSet<>();
        for (String rpt : report) {
            reportSet.add(rpt);
        }

        HashMap<String, Integer> reportedCountMap = new HashMap<>();
        for (String rpt : reportSet) {
            String[] stList = rpt.split(" ");
            Integer cnt = reportedCountMap.get(stList[1]);
            reportedCountMap.put(stList[1], cnt != null ? cnt + 1 : 1);
        }
        // System.out.println(reportedCountMap);

        HashMap<String, Integer> countMap = new HashMap<>();
        for (String str : id_list) {
            countMap.put(str, 0);
        }

        for (String rpt : reportSet) {
            String[] stList = rpt.split(" ");
            if (reportedCountMap.get(stList[1]) >= k) {
                countMap.put(stList[0], countMap.get(stList[0]) + 1);
            }
        }
        // System.out.println(countMap);
        int[] answer = new int[id_list.length];
        int index = 0;
        for (int i = 0; i < id_list.length; i++) {
            answer[index++] = countMap.get(id_list[i]);
        }
        return answer;
    }
}