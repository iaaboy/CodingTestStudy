package prog150365;

/* 미로 탈출 명령어
 * https://school.programmers.co.kr/learn/courses/30/lessons/150365
 */

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        // n m x y r c k result
        // 3 4 2 3 3 1 5 "dllrl"
        // 2 2 1 1 2 2 2 "dr"
        // 3 3 1 2 3 3 4 "impossible"

        int[] n = { 3, 2, 3 };
        int[] m = { 4, 2, 3 };
        int[] x = { 2, 1, 1 };
        int[] y = { 3, 1, 2 };
        int[] r = { 3, 2, 3 };
        int[] c = { 1, 2, 3 };
        int[] k = { 5, 2, 4 };

        Solution mSol = new Solution();
        // for (int i = 0; i < 3; i++)
        int i = 0;
            System.out.println("result :" + mSol.solution(n[i], m[i], x[i], y[i], r[i], c[i], k[i]));
    }
}

/*
 * 1. 격자의 바깥으로는 나갈 수 없습니다.
 * 2. (x, y)에서 (r, c)까지 이동하는 거리가 총 k여야 합니다. 이때, (x, y)와 (r, c)격자를 포함해, 같은 격자를 두 번 이상 방문해도 됩니다.
 * 3. 미로에서 탈출한 경로를 문자열로 나타냈을 때, 문자열이 사전 순으로 가장 빠른 경로로 탈출해야 합니다.
 */
class Solution {
    int m, n;

    //n,m 가로 세로 길이
    //x,y 출발
    //r,c 종료
    int[] offsetX = {1, 0, 0, -1};
    int[] offsetY = {0, 1, -1, 0};
    char[] offsetChar = {'d','r','l','u'};
    int offsetMax = 4;
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        PriorityQueue <Route> mRoutes = new PriorityQueue<>();
        this.n = n;
        this.m = m;

        Set <String> isVisited = new HashSet<>();

        mRoutes.add(new Route("", x, y));

        Route curRoute;
        while(!mRoutes.isEmpty()) {
            //다음 가능하면 add
            curRoute = mRoutes.poll();
            int nxX, nxY;
            if(curRoute.curX == r && curRoute.curY == c && curRoute.routes.length() == k) {
                return curRoute.routes;
            }
            for(int i = 0; i< offsetMax ; i++) {
                nxX = curRoute.curX + offsetX[i];
                nxY = curRoute.curY + offsetY[i];
                //x가 범위 이내 && y가 범위 이내
                if((nxX > 0 && nxX <= n) && (nxY > 0 && nxY <= m)) {
                    if(curRoute.routes.length() < k && !isVisited.contains(curRoute.routes + offsetChar[i])) {
                        Route nextRoute = new Route(curRoute.routes + offsetChar[i], nxX, nxY);
                        System.out.println(nextRoute);
                        isVisited.add(curRoute.routes);
                        mRoutes.add(nextRoute);
                    }
                }
            }
        }
        return "impossible";
    }
}

class Route implements Comparable<Route> {
    String routes;
    int curX;
    int curY;

    public Route(String routes, int curX, int curY) {
        this.routes = routes;
        this.curX = curX;
        this.curY = curY;
    }

    @Override
    public int compareTo(Route o) {
        // if(this.routes.length() == o.routes.length()) {
        //     return this.routes.compareTo(o.routes);
        // } else {
        //     return this.routes.length() - o.routes.length();
        // }
        return this.routes.compareTo(o.routes);
    }

    @Override
    public String toString() {
        return "<" + curX + "," + curY+ ">" + routes;
    }
}