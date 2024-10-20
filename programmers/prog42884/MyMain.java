package prog42884;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        int[][] routes = { { -20, -15 }, { -14, -5 }, { -18, -13 }, { -5, -3 } };

        Solution mSol = new Solution();

        System.out.println(mSol.solution(routes));
    }
}

class Solution {
    public int solution(int[][] routes) {
        ArrayList<Target> target = new ArrayList<Target>();
        for (int[] tar : routes) {
            target.add(new Target(tar[0], tar[1]));
        }
        target.sort(null);

        // System.out.println(target);

        int answer = 1;
        int end = target.get(0).end;

        for (Target tar : target) {
            if (tar.start > end) {
                // System.out.print(tar);
                end = tar.end;
                answer++;
                // System.out.println("ed:" + end);
            }
        }

        return answer;
    }
}

class Target implements Comparable<Target> {
    int start;
    int end;

    public Target(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Target o) {
        if (end == o.end) {
            return start - o.start;
        } else
            return end - o.end;
    }

    @Override
    public String toString() {
        return "(" + start + "," + end + ")";
    }
}