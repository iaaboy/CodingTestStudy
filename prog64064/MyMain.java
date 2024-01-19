package prog64064;

import java.util.*;

/* 불량 사용자
 * https://school.programmers.co.kr/learn/courses/30/lessons/64064
 */

public class MyMain {
    public static void main(String[] args) {
        String[][] user_ids = {
                { "frodo", "fradi", "crodo", "abc123", "frodoc" },
                { "frodo", "fradi", "crodo", "abc123", "frodoc" },
                { "frodo", "fradi", "crodo", "abc123", "frodoc" }
        };
        String[][] banned_id = {
                { "fr*d*", "abc1**" }, // 2
                { "*rodo", "*rodo", "******" }, // 2
                { "fr*d*", "*rodo", "******", "******" }// 3
        };

        Solution mSol = new Solution();
        for (int i = 0; i < 3; i++) {
            System.out.println(mSol.solution(user_ids[i], banned_id[i]));
        }
    }
}

class Solution {
    HashMap<Integer, ArrayList<Integer>> possbileUsers;
    int cntBann;

    public int solution(String[] user_id, String[] banned_id) {
        possbileUsers = new HashMap<>();
        cntBann = banned_id.length;
        savedArrs = new ArrayList<>();

        for (int b = 0; b < banned_id.length; b++) {
            for (int u = 0; u < user_id.length; u++) {
                if (user_id[u].matches(banned_id[b].replace("*", "."))) {
                    if (!possbileUsers.containsKey(b)) {
                        ArrayList<Integer> userList = new ArrayList<>();
                        userList.add(u);
                        possbileUsers.put(b, userList);
                    } else {
                        possbileUsers.get(b).add(u);
                    }
                }
            }
        }

        Integer[] keyArr = possbileUsers.keySet().toArray(new Integer[0]);
        Integer[] visited = new Integer[keyArr.length];
        Arrays.fill(visited, -1);

        int answer = permutation(keyArr, visited, 0);

        return answer;
    }

    private int permutation(Integer[] keyArr, Integer[] route, int curDepth) {

        int count = 0;
        if (curDepth == keyArr.length) {
            if (checkBans(route)) {
                return 1;
            } else {
                return 0;
            }
        }
        int key = keyArr[curDepth];

        for (int bId : possbileUsers.get(key)) {
            route[curDepth] = bId;
            boolean hasSameKey = false;

            for (int i = 0; i < curDepth; i++) {
                if (route[i] == bId) {
                    hasSameKey = true;
                    break;
                }
            }
            if (!hasSameKey)
                count += permutation(keyArr, route, curDepth + 1);
        }
        return count;
    }

    ArrayList<Integer[]> savedArrs;

    private boolean checkBans(Integer[] arr) {
        Integer[] savedArr = arr.clone();
        Arrays.sort(savedArr);
        for (Integer[] compare : savedArrs) {
            if (Arrays.equals(savedArr, compare)) {
                return false;
            }
        }

        savedArrs.add(savedArr);
        return true;
    }
}