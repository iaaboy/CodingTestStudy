package prog87946;

public class MyMain {
    public static void main(String[] args) {
        int[][] dungeons = { { 80, 20 }, { 50, 40 }, { 30, 10 } };

        Solution mSol = new Solution();
        System.out.println(mSol.solution(80, dungeons));
    }
}

class Solution {
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        return visitNext(dungeons, 0, visited, k);
    }

    private int visitNext(int[][] dungeons, int curDepth, boolean[] visited, int k) {
        int maxCnt = -1;
        System.out.println("curDepth: " + curDepth + ", k:" + k);
        if (k <= 0)
            return curDepth;
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                int count = visitNext(dungeons, curDepth + 1, visited, k - dungeons[i][1]);
                visited[i] = false;
                if (count > maxCnt) {
                    maxCnt = count;
                }
            }
        }
        if (maxCnt >= 0)
            return maxCnt;
        return curDepth;
    }
}