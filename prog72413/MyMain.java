package prog72413;

/* 합승 택시
https://school.programmers.co.kr/learn/courses/30/lessons/72413 
 */

public class MyMain {
    public static void main(String[] args) {
        int[] n = { 6, 7, 6 };
        int[] s = { 4, 3, 4 };
        int[] a = { 6, 4, 5 };
        int[] b = { 2, 1, 6 };
        int[][][] fares = {
                { { 4, 1, 10 }, { 3, 5, 24 }, { 5, 6, 2 },
                        { 3, 1, 41 }, { 5, 1, 24 }, { 4, 6, 50 },
                        { 2, 4, 66 }, { 2, 3, 22 }, { 1, 6, 25 } },
                { { 5, 7, 9 }, { 4, 6, 4 }, { 3, 6, 1 }, { 3, 2, 3 }, { 2, 1, 6 } },
                { { 2, 6, 6 }, { 6, 3, 7 }, { 4, 6, 7 }, { 6, 5, 11 },
                        { 2, 5, 12 }, { 5, 3, 20 }, { 2, 4, 8 }, { 4, 3, 9 } }
        };
        Solution mSol = new Solution();
        for (int i = 0; i < 3; i++) {
            System.out.println("ans: " + mSol.solution(n[i], s[i], a[i], b[i], fares[i]));
        }
    }
}

class Solution {
    static int INF = 2000000;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] costFlo = new int[n + 1][n + 1];
        for (int from = 1; from <= n; from++) {
            for (int to = 1; to <= n; to++) {
                if (from != to)
                    costFlo[from][to] = INF;
            }
        }

        for (int[] fare : fares) {
            costFlo[fare[0]][fare[1]] = fare[2];
            costFlo[fare[1]][fare[0]] = fare[2];
        }

        for (int stop = 1; stop <= n; stop++) {
            for (int from = 1; from <= n; from++) {
                for (int to = 1; to <= n; to++) {
                    if ((costFlo[from][stop] != INF && costFlo[stop][to] != INF))
                        costFlo[from][to] = Math.min(costFlo[from][to], costFlo[from][stop] + costFlo[stop][to]);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        answer = costFlo[s][b] + costFlo[s][a];
        for (int mid = 1; mid <= n; mid++) {
            if (costFlo[s][mid] != INF && costFlo[mid][a] != INF && costFlo[mid][b] != INF)
                answer = Math.min(answer, costFlo[s][mid] + costFlo[mid][a] + costFlo[mid][b]);
        }
        return answer;
    }
}