package prog118669;

import java.util.*;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/118669
 */

public class MyMain {
    public static void main(String[] args) {
        int n = 4;
        int[][] paths = { { 1, 3, 1 }, { 1, 4, 1 }, { 4, 2, 1 } };
        int[] gates = { 1 };
        int[] summits = { 2, 3, 4 };

        Solution mSol = new Solution();
        System.out.println("answer" + Arrays.toString(mSol.solution(n, paths, gates, summits)));
    }
}

class Solution {
    Peak[] peaks;
    int[] summits;
    int[] gates;
    int[] answer = new int[2];
    int n;
    int[] intenses;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        this.summits = summits;
        this.gates = gates;
        this.n = n;

        peaks = new Peak[n + 1];

        for (int[] path : paths) {
            if (peaks[path[0]] == null) {
                peaks[path[0]] = new Peak();
            }
            if (!isPeak(path[0]) && !isGate(path[1])) {
                peaks[path[0]].mCo.add(new Coord(path[0], path[1], path[2]));
            }
            if (peaks[path[1]] == null) {
                peaks[path[1]] = new Peak();
            }
            if (!isPeak(path[1]) && !isGate(path[0])) {
                peaks[path[1]].mCo.add(new Coord(path[1], path[0], path[2]));
            }
        }

        climb();

        answer[0] = Integer.MAX_VALUE;
        answer[1] = Integer.MAX_VALUE;

        Arrays.sort(summits);

        for (int sum : summits) {
            if (intenses[sum] < answer[1]) {
                answer[0] = sum;
                answer[1] = intenses[sum];
            }
        }

        return answer;
    }

    boolean isGate(int p) {
        boolean result = false;
        for (int g : gates) {
            if (g == p)
                return true;
        }
        return result;
    }

    boolean isPeak(int p) {
        boolean result = false;
        for (int s : summits) {
            if (s == p)
                return true;
        }
        return result;
    }

    void climb() {
        Queue<Vertex> mQ = new LinkedList<>();
        intenses = new int[n + 1];
        Arrays.fill(intenses, Integer.MAX_VALUE);

        for (int g : gates) {
            mQ.add(new Vertex(g, 0));
            intenses[g] = 0;
        }

        while (!mQ.isEmpty()) {
            // System.out.println("mq: " + mQ);
            Vertex curCoord = mQ.poll();
            if (intenses[curCoord.p] < curCoord.intens)
                continue;

            for (Coord nexCoord : peaks[curCoord.p].mCo) {
                int tempIntense = Math.max(nexCoord.intens, curCoord.intens);
                if (intenses[nexCoord.ed] > tempIntense) {
                    intenses[nexCoord.ed] = tempIntense;
                    mQ.add(new Vertex(nexCoord.ed, tempIntense));
                }
            }
        }
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