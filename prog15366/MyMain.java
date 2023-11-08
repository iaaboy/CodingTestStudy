package prog15366;

import java.util.*;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/150366
 */

public class MyMain {
    public static void main(String[] args) {
        String[] commands = { "UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c", "UPDATE 2 2 d", "MERGE 1 1 1 2", "MERGE 2 2 2 1", "MERGE 2 1 1 1", "PRINT 1 1", "UNMERGE 2 2", "PRINT 1 1"};

        Solution mSol = new Solution();
        System.out.println(Arrays.toString(mSol.solution(commands)));
    }
}

class Solution {
    HashMap<Integer, String> wordMap;
    HashMap<Integer, Vector<Point>> keyMap;
    int[][] table;
    int index;

    public String[] solution(String[] commands) {
        ArrayList<String> ans = new ArrayList<>();
        wordMap = new HashMap<>();
        keyMap = new HashMap<>();
        table = new int[51][51];
        index = 1;

        for (String cmd : commands) {
            String[] c = cmd.split(" ");
            if (c[0].charAt(0) == 'U') {
                if (c[0].charAt(1) == 'P') {
                    if (c.length == 3) {
                        update(c[1], c[2]);
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

            System.out.println(cmd);
            printMaps(4);
            System.out.println();
        }

        String[] answer = new String[ans.size()];
        int i = 0;
        for (String a : ans) {
            answer[i++] = a;
        }
        return answer;
    }

    void printMaps(int mx) {
        mx++;
        for (int i = 0; i < mx; i++) {
            for (int k = 0; k < mx; k++) {
                System.out.print(table[i][k] + " ");
                if(table[i][k] == 0) {
                    System.out.print("---" + " ");
                } else {
                    System.out.print(wordMap.get(table[i][k]) + " ");
                }
            }
            System.out.println();
        }
        System.out.println("words: " + wordMap);
        System.out.println("keyMap: " + keyMap);
    }

    /*
     * "UPDATE r c value"
     * (r, c) 위치의 셀을 선택합니다.
     * 선택한 셀의 값을 value로 바꿉니다.
     */
    void Update(int r, int c, String val) {
        if (table[r][c] == 0) {
            wordMap.put(index, val);
            table[r][c] = index;
            keyMap.put(index, new Vector<>());
            keyMap.get(index).add(new Point(r, c));
            index++;
        } else {
            wordMap.put(table[r][c], val);
        }
    }

    /*
     * "UPDATE value1 value2"
     * value1을 값으로 가지고 있는 모든 셀을 선택합니다.
     * 선택한 셀의 값을 value2로 바꿉니다.
     */
    void update(String a, String b) {
        for (Integer key : wordMap.keySet()) {
            if (wordMap.get(key).contentEquals(a)) {
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
        int key = table[r][c];
        if (key != 0) {
            for (Point eachKey : keyMap.get(key)) {
                if (eachKey.r == r && eachKey.c == c)
                    continue;
                table[eachKey.r][eachKey.c] = 0;
            }
            keyMap.get(key).clear();
            keyMap.get(key).add(new Point(r, c));
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
        if (r1 == r2 && c1 == c2) {
            return;
        }
        // 두셀 중 한 셀만 가지고 있을 경우
        if (table[r1][c1] == 0 && table[r2][c2] == 0) {
            Update(r1, c1, "Empty");
            Merge(r1, c1, r2, c2);
        } else if (table[r1][c1] == 0) {
            table[r1][c1] = table[r2][c2];
            keyMap.get(table[r2][c2]).add(new Point(r1, c1));
        } else if (table[r2][c2] == 0) {
            table[r2][c2] = table[r1][c1];
            keyMap.get(table[r1][c1]).add(new Point(r2, c2));
        } else { // 2 -> 1
            int rmKey = table[r2][c2];
            wordMap.remove(rmKey);
            for (Point vector : keyMap.get(table[r2][c2])) {
                table[vector.r][vector.c] = table[r1][c1];
                keyMap.get(table[r1][c1]).add(new Point(vector.r, vector.c));
            }
            keyMap.remove(rmKey);
        }
    }

    /*
     * "PRINT r c"
     * (r, c) 위치의 셀을 선택하여 셀의 값을 출력합니다.
     * 선택한 셀이 비어있을 경우 "EMPTY"를 출력합니다.
     */
    String Print(int r, int c) {
        if (table[r][c] == 0)
            return "EMPTY";
        return wordMap.get(table[r][c]);
    }

    class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return r + "," + c;
        }
    }
}