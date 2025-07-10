package acmicpc5588;

import java.io.*;
import java.util.*;

/* 별자리 찾기
 * https://www.acmicpc.net/problem/5588
 * 좌표를 hash로 만들어서 비교하기
 */

public class Main {
    static int X = 0;
    static int Y = 1;
    static long Y_OFFSET = 100000000;
    static long REBASE_OFFSET = 10000000;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(bf.readLine());

        int[][] myStarMap = new int[m][2];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            myStarMap[i][X] = x;
            myStarMap[i][Y] = y;
        }
        int n = Integer.parseInt(bf.readLine());
        HashSet<Long> universeSet = new HashSet<>();
        int[][] universeMap = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            universeMap[i][X] = x;
            universeMap[i][Y] = y;
            long mapData = getMapData(x, y);
            universeSet.add(mapData);
        }

        for (int[] un : universeMap) {
            int xDiff = un[X] - myStarMap[0][X];
            int yDiff = un[Y] - myStarMap[0][Y];
            // long mapData = getMapData(xDiff, yDiff);
            // System.out.println(xDiff + " " + yDiff + " , mapData: " + mapData);
            boolean isMapping = true;
            for (int i = 0; i < myStarMap.length; i++) {
                int filteredX = myStarMap[i][X] + xDiff;
                int filteredY = myStarMap[i][Y] + yDiff;
                long filteredMapData = getMapData(filteredX, filteredY);
                if (!universeSet.contains(filteredMapData)) {
                    isMapping = false;
                }
            }
            if (isMapping) {
                System.out.println(xDiff + " " + yDiff);
                break;
            }
        }
    }

    private static long getMapData(int x, int y) {
        long xRebased = (long) x + REBASE_OFFSET;
        long yRebased = (long) y + REBASE_OFFSET;
        long mapData = (Y_OFFSET * (long) yRebased + (long) xRebased);
        return mapData;
    }
}
