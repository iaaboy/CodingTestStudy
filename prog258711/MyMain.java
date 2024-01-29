package prog258711;

import java.util.*;
/* 도넛과 막대 그래프
 * https://school.programmers.co.kr/learn/courses/30/lessons/258711
 */

public class MyMain {
    public static void main(String[] args) {
        int[][][] edge = {
                { { 2, 3 }, { 4, 3 }, { 1, 1 }, { 2, 1 } },
                { { 4, 11 }, { 1, 12 }, { 8, 3 }, { 12, 7 }, { 4, 2 }, { 7, 11 }, { 4, 8 }, { 9, 6 }, { 10, 11 },
                        { 6, 10 }, { 3, 5 }, { 11, 1 }, { 5, 3 }, { 11, 9 }, { 3, 8 } }
        };
        Solution mSol = new Solution();
        for (int[][] edges : edge) {
            System.out.println(Arrays.toString(mSol.solution(edges)));
        }
    }
}

class Solution {
    HashMap<Integer, Vertex> vMap;

    public int[] solution(int[][] edges) {
        vMap = new HashMap<>();
        for (int[] e : edges) {
            if (!vMap.containsKey(e[0])) {
                vMap.put(e[0], new Vertex(e[0]));
            }
            if (!vMap.containsKey(e[1])) {
                vMap.put(e[1], new Vertex(e[1]));
            }
            vMap.get(e[0]).out++;
            vMap.get(e[1]).in++;
        }
        int hub = 0;
        for (int key : vMap.keySet()) {
            if (vMap.get(key).in == 0 && vMap.get(key).out > 1) {
                // System.out.println("hub: " + key);
                hub = key;
            }
        }

        for (int[] e : edges) {
            if (e[0] != hub) {
                if (vMap.get(e[0]).id == e[0]) {
                    // System.out.println(vMap);
                    vMap.get(e[0]).id = findRoot(vMap.get(e[1]).id);
                }
            } else {
                vMap.get(e[0]).out--;
                vMap.get(e[1]).in--;
            }
        }

        HashMap<Integer, GroupInfo> gMap = new HashMap<>();
        for (Vertex v : vMap.values()) {
            int gId = findRoot(v.id);
            if (gId == hub)
                continue;
            if (!gMap.containsKey(gId)) {
                gMap.put(gId, new GroupInfo());
            }
            if (v.in == 0 && v.out == 0) {
                gMap.get(gId).count00++;
            } else if (v.in == 1 && v.out == 0) {
                gMap.get(gId).count10++;
            } else if (v.in == 1 && v.out == 1) {
                gMap.get(gId).count11++;
            } else if (v.in == 2 && v.out == 2) {
                gMap.get(gId).count22++;
            }
        }
        int[] answer = new int[4];
        answer[0] = hub;
        for (GroupInfo g : gMap.values()) {
            if (g.count22 > 0) {
                answer[3]++; // count8++;
            } else if (g.count11 > 0 && g.count00 == 0 && g.count10 == 0 && g.count22 == 0) {
                answer[1]++; // countDonut++;
            } else {
                answer[2]++; // countStick++;
            }
        }
        // System.out.println(gMap);
        return answer;
    }

    int findRoot(int now) {
        if (vMap.get(now).id != now) {
            return findRoot(vMap.get(now).id);
        } else {
            return now;
        }
    }

    class GroupInfo {
        int count00;
        int count10;
        int count11;
        int count22;

        @Override
        public String toString() {
            return count00 + "," + count10 + "," + count11 + "," + count22;
        }
    }

    class Vertex {
        int id;
        int in;
        int out;

        public Vertex(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return findRoot(id) + ":" + in + "," + out;
        }
    }
}