package prog181188;

import java.util.*;

public class MyMain {
    // [[4,5],[4,8],[10,14],[11,13],[5,12],[3,7],[1,4]]
    public static void main(String[] args) {
        int[][] targets = { { 4, 5 }, { 4, 8 }, { 10, 14 }, { 11, 13 }, { 5, 12 }, { 3, 7 }, { 1, 4 } };
        // int[][] targets = {{1,3},{5,13},{7,8}, {9,10}};
        Solution mSol = new Solution();
        System.out.println(mSol.solution(targets));
    }
}

class Solution {
    public int solution(int[][] targets) {
        ArrayList<Target> target = new ArrayList<Target>();
        for (int[] tar : targets) {
            target.add(new Target(tar[0], tar[1]));
        }
        target.sort(null);

        System.out.println(target);

        int answer = 1;
        int end = target.get(0).end;

        for (Target tar : target) {
            if (tar.start >= end) {
                System.out.print(tar);
                end = tar.end;
                answer++;
            }
        }
        // System.out.println(count);

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