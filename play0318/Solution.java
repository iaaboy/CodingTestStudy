package play0318;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

class Solution {
    class Node {
        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        int y;
        int x;
    }

    class Group {
        Group(int gId) {
            this.gId = gId;
            groupSum = 0;
            nodes = new Vector<>();
        }

        int gId;
        int groupSum;
        Vector<Node> nodes;
    }

    // 문제
    // https://school.programmers.co.kr/learn/courses/30/lessons/154540?language=java

    // Sample
    // String maps[] = {"X591X","XXX5X","X231X", "1XXX1"};

    int myArr[][];
    int groupIDs[][];
    Integer Idx;
    HashMap<Integer, Group> groups = new HashMap<>();

    public int[] solution(String[] maps) {

        myArr = new int[maps.length][maps[0].length()];
        groupIDs = new int[maps.length][maps[0].length()];
        Idx = 0;

        for (int y = 0; y < maps.length; y++) {
            for (int x = 0; x < maps[0].length(); x++) {
                int number = maps[y].toCharArray()[x] - '0';
                if (number >= 0 && number <= 9) {
                    myArr[y][x] = number;
                } else {
                    myArr[y][x] = -1;
                }
            }
        }

        // for (int[] line : myArr) {
        //     // System.out.println("mid result: " + Arrays.toString(line));
        // }

        for (int y = 0; y < myArr.length; y++) {
            for (int x = 0; x < myArr[y].length; x++) {
                boolean checkResult = false;
                if (myArr[y][x] == -1) {
                    groupIDs[y][x] = -1;
                    continue;
                }
                if (x != 0) {
                    checkResult = checkLeft(y, x);
                }
                if (y != 0) {
                    checkResult = checkTop(y, x) || checkResult;
                }
                if (!checkResult) {
                    Group g = new Group(++Idx);
                    Node nd = new Node(y, x);
                    g.nodes.add(nd);
                    g.groupSum = myArr[y][x];
                    groups.put(Idx, g);
                    groupIDs[y][x] = Idx;
                }
            }
        }

        ArrayList answerSet = new ArrayList<Integer>();
        int i = 0;
        int[] answer;

        groups.forEach((key, value) -> {
            answerSet.add(value.groupSum);
            value.nodes.clear();
        });
        groups.clear();
        Collections.sort(answerSet);

        // System.out.println("value.groupSum : " + answerSet);

        if (answerSet.size() > 0) {
            answer = new int[answerSet.size()];
            Iterator<Integer> iter = answerSet.iterator();
            // Returns an iterator over the elements
            while (iter.hasNext()) {
                answer[i] = iter.next();
                // System.out.println("value : " + answer[i] );
                i++;
            }

        } else {
            answer = new int[1];
            answer[0] = -1;
        }


        return answer;

    }

    boolean checkTop(int y, int x) {
        boolean result = false;

        if (myArr[y - 1][x] != -1) {
            if (groupIDs[y][x] == 0) {
                groupIDs[y][x] = groupIDs[y - 1][x];
                addToGroup(groupIDs[y - 1][x], new Node(y, x));
            } else {
                if (groupIDs[y][x] != groupIDs[y - 1][x])
                    combineToGroup(groupIDs[y][x], groupIDs[y - 1][x]);
            }
            result = true;
        }

        return result;
    }

    void combineToGroup(int gFrom, int gTo) {
        // from에 있는 아이들을 G로 바꾼다.

        for (Node n : groups.get(gFrom).nodes) {
            groupIDs[n.y][n.x] = gTo;
        }
        groups.get(gTo).groupSum += groups.get(gFrom).groupSum;
        groups.get(gFrom).nodes.clear();
        groups.remove(gFrom);
    }

    boolean checkLeft(int y, int x) {
        if (myArr[y][x - 1] != -1) {
            groupIDs[y][x] = groupIDs[y][x - 1];
            addToGroup(groupIDs[y][x - 1], new Node(y, x));
            return true;
        }

        return false;
    }

    void addToGroup(int gId, Node nd) {
        if (groups.get(gId) == null) {
            // System.out.println("Somthing wrong");
        }
        groups.get(gId).groupSum += myArr[nd.y][nd.x];
        groups.get(gId).nodes.add(nd);
    }

}
