package prog118669;

import java.util.*;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/118669
 */

public class MyMain {
    public static void main(String[] args) {
        // int n = 6;
        // int[][] paths = { { 1, 2, 3 }, { 2, 3, 5 }, { 2, 4, 2 }, { 2, 5, 4 }, { 3, 4,
        // 4 }, { 4, 5, 3 }, { 4, 6, 1 },
        // { 5, 6, 1 } };
        // int[] gates = { 1, 3 };
        // int[] summits = { 5 };

        int n = 7;
        int [][] paths = {{1, 2, 5}, {1, 4, 1}, {2, 3, 1}, {2, 6, 7}, {4, 5, 1}, {5,
        6, 1}, {6, 7, 1}};
        int[] gates = {3,7};
        int [] summits = {1,5};

        // int n = 5;
        // int[][] paths = { { 1, 3, 10 }, { 1, 4, 20 }, { 2, 3, 4 }, { 2, 4, 6 }, { 3,
        // 5, 20 }, { 4, 5, 6 } };
        // int[] gates = { 2 };
        // int[] summits = { 5 };

        // int n = 3;
        // int[][] paths = { { 1, 2, 5 }, { 1, 3, 1 }, { 3, 2, 3 } };
        // int[] gates = { 1 };
        // int[] summits = { 2 };

        // int n = 4;
        // int[][] paths = { { 1, 3, 1 }, { 1, 4, 1 }, { 4,2,1 } };
        // int[] gates = { 1 };
        // int[] summits = { 2,3,4 };

        Solution mSol = new Solution();
        System.out.println("answer" + Arrays.toString(mSol.solution(n, paths, gates, summits)));
    }
}

class Solution {
    Peak[] peaks;
    boolean isVisited[];
    int[] summits;
    int[] gates;
    int[] answer = new int[2];

    boolean isGate(int p) {
        boolean result = false;
        for(int g : gates) {
            if(g == p)
                return true;
        }
        return result;
    }
    boolean isPeak(int p) {
        boolean result = false;
        for(int s : summits) {
            if(s == p)
                return true;
        }
        return result;
    }

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        this.summits = summits;
        this.gates = gates;

        peaks = new Peak[n + 1];
        isVisited = new boolean[n + 1];

        for (int[] path : paths) {
            if (peaks[path[0]] == null) {
                peaks[path[0]] = new Peak();
            }
            if(!isPeak(path[0]) && !isGate(path[1])) {
                peaks[path[0]].mCo.add(new Coord(path[0], path[1], path[2]));
            }
            if (peaks[path[1]] == null) {
                peaks[path[1]] = new Peak();
            }
            if(!isPeak(path[1]) && !isGate(path[0])) {
                peaks[path[1]].mCo.add(new Coord(path[1], path[0], path[2]));
            }
        }

        for (Peak p : peaks) {
            if (p != null)
                p.sort();
        }

        answer[0] = Integer.MIN_VALUE;
        answer[1] = Integer.MAX_VALUE;
        for (int gate : gates) {
            for (int summit : summits) {
                int intens = climb(gate, summit);
                if(intens == Integer.MIN_VALUE)
                    continue;
                if (intens < answer[1]) {
                    answer[1] = intens;
                    answer[0] = summit;
                } else if (answer[1] == intens && answer[0] > summit) {
                    answer[1] = intens;
                    answer[0] = summit;
                }
            }
        }

        // System.out.println(Arrays.toString(peaks));

        return answer;
    }

    int climb(int gate, int summit) {
        Arrays.fill(isVisited, false);
        PriorityQueue<Vertex> mQ = new PriorityQueue<>();
        isVisited[gate] = true;

        for (int v : summits) {
            if (summit != v) {
                isVisited[v] = true;
            }
        }

        for (int g : gates) {
            if (gate != g) {
                isVisited[g] = true;
            }
        }

        int intensMax = Integer.MIN_VALUE;

        for (Coord cd : peaks[gate].mCo) {
            if (!isVisited[cd.ed] && answer[1] > cd.intens) {
                mQ.add(new Vertex(cd.ed, cd.intens));
            }
        }
        // System.out.println(peaks[4]);
        while (!mQ.isEmpty()) {
            // System.out.println("mq: " + mQ);
            Vertex curCoord = mQ.poll();
            isVisited[curCoord.p] = true;
            if (curCoord.p == summit) {
                intensMax = curCoord.intens;
                break;
            }
            // System.out.println("cur: " + curCoord +
            // Arrays.toString(isVisited));

            for (Coord nexCoord : peaks[curCoord.p].mCo) {
                int tempIntense = Math.max(nexCoord.intens, curCoord.intens);
                if (!isVisited[nexCoord.ed] && tempIntense < answer[1] ) {
                    mQ.add(new Vertex(nexCoord.ed, tempIntense));
                }
            }
        }

        // System.out.println(gate + "->" + summit + " intensMax: " + intensMax);
        return intensMax;
    }
}

class Peak {
    Vector<Coord> mCo;

    public Peak() {
        mCo = new Vector<>();
    }

    public void sort() {
        mCo.sort((a, b) -> {
            if (a.intens == b.intens) {
                return a.st - b.st;
            } else {
                return a.intens - b.intens;
            }
        });
    }

    @Override
    public String toString() {
        return mCo.toString();
    }
}

class Coord implements Comparable<Coord> {
    int st;
    int ed;
    int intens;

    public Coord(int st, int ed, int intens) {
        this.st = st;
        this.ed = ed;
        this.intens = intens;
    }

    @Override
    public int compareTo(Coord b) {
        if (intens == b.intens) {
            return st - b.st;
        } else {
            return intens - b.intens;
        }
    }

    @Override
    public String toString() {
        return st + "-" + ed + ":" + intens;
    }
}

class Vertex implements Comparable<Vertex> {
    int p;
    int intens;

    public Vertex(int p, int intens) {
        this.p = p;
        this.intens = intens;
    }

    @Override
    public int compareTo(Vertex b) {
        if (intens == b.intens) {
            return p - b.p;
        } else {
            return intens - b.intens;
        }
    }

    @Override
    public String toString() {
        return p + "-" + intens;
    }
}