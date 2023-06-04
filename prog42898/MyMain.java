package prog42898;

public class MyMain {
    public static void main(String[] args) {
        Solution mSol = new Solution();
        int[][] puddles = { { 2, 2 } };
        System.out.println(mSol.solution(4, 3, puddles));

    }
}

// 1,1부터 시작
// m 오른쪽
// n 아래쪽
class Solution {
    int[][] visited;

    public int solution(int m, int n, int[][] puddles) {
        visited = new int[m + 1][n + 1];

        visited[1][1] = 1;

        for (int[] pd : puddles) {
            visited[pd[0]][pd[1]] = -1;
        }

        for (int i = 2; i < m + n + 1; i++) {
            for (int k = 1; k < i; k++) {
                int myM = k;
                int myN = i - k;

                if (myN <= n && myM <= m) {
                    if (visited[myM][myN] != -1) {
                        // System.out.print("| m: " + myM + ", n: " + myN);

                        if (visited[myM - 1][myN] > 0) {
                            visited[myM][myN] += visited[myM - 1][myN];
                        }
                        if (visited[myM][myN - 1] > 0) {
                            visited[myM][myN] += visited[myM][myN - 1];
                        }

                        visited[myM][myN] = visited[myM][myN] % 1000000007;
                    }
                }
            }
            // System.out.println();
        }

        // for(int i = 0; i < m+1 ; i++){
        // System.out.println(Arrays.toString(visited[i]));
        // }

        // 결과
        // [0, 0, 0, 0]
        // [0, 1, 1, 1]
        // [0, 1, -1, 1]
        // [0, 1, 1, 2]
        // [0, 1, 2, 4]

        return visited[m][n] % 1000000007;
    }
}