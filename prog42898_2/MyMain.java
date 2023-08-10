package prog42898_2;

/* 등굣길
 * https://school.programmers.co.kr/learn/courses/30/lessons/42898
 * 
 * 1. m x n 크기의 격자모양
 * 2. m, n과 물이 잠긴 지역의 좌표를 담은 2차원 배열 puddles이 매개변수로 주어집니다
 * 3. 오른쪽과 아래쪽으로만 움직여 집에서 학교까지 갈 수 있는 최단경로
 * 
 * 격자의 크기 m, n은 1 이상 100 이하인 자연수
 * 물에 잠긴 지역은 0개 이상 10개 이하입니다.
 * 
 * 잘못된 입력은 없음
 */

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = { { 2, 2 } };

        Solution mSol = new Solution();
        System.out.print(mSol.solution(m, n, puddles));
    }
}

// class Solution {
//     public int solution(int m, int n, int[][] puddles) {
//         int answer = 0;
//         int[][] map = new int[n + 1][m + 1];
//         int devider = 1000000007;

//         for (int[] p : puddles)
//             map[p[1]][p[0]] = -1; // 웅덩이

//         map[1][1] = 1;

//         for (int y = 1; y <= n; y++)
//             for (int x = 1; x <= m; x++) {
//                 if ((x == 1 && y == 1) || (map[y][x] == -1))
//                     continue;
//                 if (map[y][x - 1] != -1)
//                     map[y][x] += map[y][x - 1];
//                 if (map[y - 1][x] != -1)
//                     map[y][x] += map[y - 1][x];
//                 map[y][x] = map[y][x] % devider;
//             }

//         answer = map[n][m];
//         return answer;
//     }
// }

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        int[][] dp = new int[n+1][m+1];
        boolean[][] visited = new boolean[n+1][m+1];
        
        // 방향순서 : 상 -> 하 -> 좌 -> 우
        int[] dy = new int[]{ +1, 0};
        int[] dx = new int[]{ 0, +1};
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 1});
        
        for(int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;    // dp배열에 물웅덩이 표시
        }

        // bfs
        while(!q.isEmpty()) {
            int[] poll = q.poll();
            int y = poll[0];
            int x = poll[1];
            
            for(int i = 0; i < dy.length; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny >= 1 && ny <= n && nx >= 1 && nx <= m) {
                    if(dp[ny][nx] == -1) continue;  // 물웅덩이인 경우 continue
                   
                    if(!visited[ny][nx]) {
                        dp[ny][nx] = (dp[y][x] + 1) % 1000000007;
                        visited[ny][nx] = true;
                        q.offer(new int[]{ny, nx});   
                        System.out.println(nx + ", " + ny);
                    }
                    
                }
            }
            
        }

        for(int i = 0; i< dp.length ; i++)
            System.out.println(Arrays.toString(dp[i]));
        
        return dp[n][m] - 1;
    }
}