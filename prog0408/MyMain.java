package prog0408;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        String[] players = { "mumu", "soe", "poe", "kai", "mine" };
        String[] calling = { "kai", "kai", "mine", "mine" };

        Solution mSol = new Solution();
        System.out.println(Arrays.toString(mSol.solution(players, calling)));
    }
}

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];

        Map<Integer, String> mapOdered = new TreeMap<>();// 정렬
        Map<String, Integer> nameMap = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            mapOdered.put(i + 1, players[i]);
            nameMap.put(players[i], i + 1);
        }

        for (int i = 0; i < callings.length; i++) {

            // 추월한 선수
            String passed = callings[i];
            int idx = nameMap.get(passed);

            // 뒤처진 선수
            String turnedOver = mapOdered.get(idx - 1);

            // nameMap 갱신
            nameMap.put(passed, idx - 1);
            nameMap.put(turnedOver, idx);

            // mapOdered 갱신
            mapOdered.put(idx - 1, passed);
            mapOdered.put(idx, turnedOver);
        }

        int idx = 0;
        for (int key : mapOdered.keySet()) {
            answer[idx++] = mapOdered.get(key);
        }
        return answer;
    }
}