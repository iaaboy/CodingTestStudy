package prog150366;

import java.util.*;

/* 표 병합
 * https://school.programmers.co.kr/learn/courses/30/lessons/150366
 */

public class MyMain {
    public static void main(String[] args) {
        String[][] commands = {
                { "UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c", "UPDATE 2 2 d", "MERGE 1 1 1 2", "MERGE 2 2 2 1",
                        "UPDATE d c",
                        "MERGE 2 1 1 1", "PRINT 1 1", "UNMERGE 2 2", "PRINT 1 1" },
                { "UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean",
                        "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle",
                        "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle",
                        "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4",
                        "PRINT 1 3", "PRINT 1 4" }
        };

        Solution mSol = new Solution();
        System.out.println(Arrays.toString(mSol.solution(commands[0])));
    }
}

class Solution {
    int[][] idMap = new int[51][51];
    HashMap<Integer, String> wordMap = new HashMap<>();

    public String[] solution(String[] commands) {
        ArrayList<String> ans = new ArrayList<>();

        for (int r = 0; r < idMap.length; r++) {
            for (int c = 0; c < idMap[0].length; c++) {
                idMap[r][c] = r * 51 + c; //id가 1부터 시작하므로, 50이 아니고 51임.
            }
        }

        for (String cmd : commands) {
            // System.out.println(cmd);
            String[] c = cmd.split(" ");
            if (c[0].charAt(0) == 'U') {
                if (c[0].charAt(1) == 'P') {
                    if (c.length == 3) {
                        Update(c[1], c[2]);
                    } else if (c.length == 4) {
                        Update(Integer.parseInt(c[1]), Integer.parseInt(c[2]), c[3]);
                    }
                } else if (c[0].charAt(1) == 'N') {
                    Unmerge(Integer.parseInt(c[1]), Integer.parseInt(c[2]));
                }
            } else if (c[0].charAt(0) == 'M') {
                Merge(Integer.parseInt(c[1]), Integer.parseInt(c[2]), Integer.parseInt(c[3]), Integer.parseInt(c[4]));
            } else if (c[0].charAt(0) == 'P') {
                ans.add(Print(Integer.parseInt(c[1]), Integer.parseInt(c[2])));
            }
            // printMap(2,2);
        }

        String[] answer = new String[ans.size()];
        int i = 0;
        for (String a : ans) {
            answer[i++] = a;
        }
        return answer;
    }

    void printMap(int r, int c) {
        for (int y = 1; y <= r; y++) {
            for (int x = 1; x <= c; x++) {
                System.out.print(idMap[y][x] + " ");
            }
            System.out.println();
        }
        System.out.println(wordMap);
    }

    int getWordId(int r, int c) {
        if (idMap[r][c] == r * 51 + c) {
            return r * 51 + c;
        } else {
            return getWordId(idMap[r][c] / 51, idMap[r][c] % 51);
        }
    }

    /*
     * "UPDATE r c value"
     * (r, c) 위치의 셀을 선택합니다.
     * 선택한 셀의 값을 value로 바꿉니다.
     */
    void Update(int r, int c, String val) {
        // System.out.println("update <" + r + "," + c + "> " + val);
        wordMap.put(getWordId(r, c), val);
    }

    /*
     * "UPDATE value1 value2"
     * value1을 값으로 가지고 있는 모든 셀을 선택합니다.
     * 선택한 셀의 값을 value2로 바꿉니다.
     */
    void Update(String a, String b) {
        // System.out.println("update " + a + "->" + b);
        for (int key : wordMap.keySet()) {
            if (wordMap.get(key).contentEquals(a)) { //주의1) String비교
                wordMap.put(key, b);
            }
        }
    }

    /*
     * "UNMERGE r c"
     * (r, c) 위치의 셀을 선택하여 해당 셀의 모든 병합을 해제합니다.
     * 선택한 셀이 포함하고 있던 모든 셀은 프로그램 실행 초기의 상태로 돌아갑니다.
     * 병합을 해제하기 전 셀이 값을 가지고 있었을 경우 (r, c) 위치의 셀이 그 값을 가지게 됩니다.
     */
    void Unmerge(int r, int c) {
        // System.out.println("Unmerge <" + r + "," + c + "> ");

        int targetId = getWordId(r, c);
        String cWord = "";
        if (wordMap.containsKey(targetId)) {
            cWord = wordMap.get(targetId);
            if (targetId != r * 51 + c) {
                wordMap.remove(targetId);
                wordMap.put(r * 51 + c, cWord);
            }
        }

        ArrayList<Integer> yCandi = new ArrayList<>();
        ArrayList<Integer> xCandi = new ArrayList<>();
        for (int y = 0; y < idMap.length; y++) {
            for (int x = 0; x < idMap[0].length; x++) {
                int unMergingId = getWordId(y, x);
                if (targetId == unMergingId) {
                    // idMap[y][x] = y * 51 + x; //주의2) unionfind의 id값을 미리 merge하면 다음에 못 찾아가는 case발생
                    yCandi.add(y);
                    xCandi.add(x);
                }
            }
        }
        for (int i = 0; i < xCandi.size(); i++) {
            int y = yCandi.get(i);
            int x = xCandi.get(i);
            idMap[y][x] = y * 51 + x;
        }
    }

    /*
     * "MERGE r1 c1 r2 c2"
     * (r1, c1) 위치의 셀과 (r2, c2) 위치의 셀을 선택하여 병합합니다.
     * 선택한 두 위치의 셀이 같은 셀일 경우 무시합니다.
     * 선택한 두 셀은 서로 인접하지 않을 수도 있습니다. 이 경우 (r1, c1) 위치의 셀과 (r2, c2) 위치의 셀만 영향을 받으며, 그
     * 사이에 위치한 셀들은 영향을 받지 않습니다.
     * 두 셀 중 한 셀이 값을 가지고 있을 경우 병합된 셀은 그 값을 가지게 됩니다.
     * 두 셀 모두 값을 가지고 있을 경우 병합된 셀은 (r1, c1) 위치의 셀 값을 가지게 됩니다.
     * 이후 (r1, c1) 와 (r2, c2) 중 어느 위치를 선택하여도 병합된 셀로 접근합니다.
     */
    void Merge(int r1, int c1, int r2, int c2) {
        int id1 = getWordId(r1, c1);
        int id2 = getWordId(r2, c2);

        // System.out.println("Merge <" + r1 + "," + c1 + "> " + " -> <" + r2 + "," + c2
        // + "> ");

        if (id1 == id2) {
            return;
        }
        if (wordMap.containsKey(id2) && !wordMap.containsKey(id1)) { // 둘중 2만 가지고 있을 경우
            int y = id1 / 51;
            int x = id1 % 51;
            idMap[y][x] = id2; //주의3) 값을 업데이트시 부모 노드 값을 찾아 업데이트해야함
            wordMap.remove(id1);
            // id1 <= id2;
        } else { // 둘다 가고 있을 경우
            // id2 <= id1;
            int y = id2 / 51;
            int x = id2 % 51;
            idMap[y][x] = id1;
            wordMap.remove(id2);
        }
    }

    /*
     * "PRINT r c"
     * (r, c) 위치의 셀을 선택하여 셀의 값을 출력합니다.
     * 선택한 셀이 비어있을 경우 "EMPTY"를 출력합니다.
     */
    String Print(int r, int c) {
        int wordId = getWordId(r, c);
        String result = "EMPTY";

        if (wordMap.containsKey(wordId)) {
            result = wordMap.get(wordId);
        } else {
        }
        // System.out.println("Print <" + r + "," + c + "> " + result);

        return result;
    }
}