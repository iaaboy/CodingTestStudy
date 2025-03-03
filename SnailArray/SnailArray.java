package SnailArray;

public class SnailArray {
    static int getSnailValue(int N, int y, int x) {
        // 현재 좌표가 속한 layer 계산
        int layer = Math.min(Math.min(x, y), Math.min(N - 1 - x, N - 1 - y));
        //System.out.print(layer + " "); //ok
        // 시작숫자 바깥쪽부터 안쪽으로 1, 9, 25, 49, 81, 121, 169
        int start = N * N - (N - 2 * layer) * (N - 2 * layer);
        int num = start;
        // System.out.print(start + " ");// ok
        // 방향 1: →, 2: ↓, 3: ←, 4: 향
        int dir = 0;
        int lineLength = N - 2 * layer;
        int[] startInSqare = { 0, lineLength, lineLength + lineLength - 1,
                lineLength + lineLength - 1 + lineLength - 1 };
        int option = 0;
        if (N - 1 - y == N - 1 - layer) { // 상단(→ 방향)
            option = x + 1 - layer;
            dir = 0;
        } else if (x == N - 1 - layer) { // 오른쪽(↓ 방향)
            option = y - layer;
            dir = 1;
        } else if (N - 1 - y == layer) { // 하단(← 방향)
            option = N - 1 - x - layer;
            dir = 2;
        } else { // 왼쪽(↑ 방향)
            option = N - 1 - y - layer;
            dir = 3;
        }
        // System.out.print(dir + " ");//ok
        // System.out.print(startInSqare[dir] + " ");
        // System.out.print(option + " ");//ok
        num += option;
        num += startInSqare[dir];
        // System.out.print(num + " ");// ng
        // System.out.print(option + " ");

        return num;
    }

    // 역함수: 값(num) → 좌표(x, y)
    static int[][] arr7 = {
        { 1, 2, 3, 4, 5, 6, 7 },
        { 24, 25, 26, 27, 28, 29, 8 },
        { 23, 40, 41, 42, 43, 30, 9 },
        { 22, 39, 48, 49, 44, 31, 10 },
        { 21, 38, 47, 46, 45, 32, 11 },
        { 20, 37, 36, 35, 34, 33, 12 },
        { 19, 18, 17, 16, 15, 14, 13 }
    };
    static int[][] arr5 = {
            { 1, 2, 3, 4, 5 },
            { 16, 17, 18, 19, 6 },
            { 15, 24, 25, 20, 7 },
            { 14, 23, 22, 21, 8 },
            { 13, 12, 11, 10, 9 }
    };
    static int[][] arr3 = {
        { 1, 2, 3 },
        { 8, 9, 4 },
        { 7, 6, 5 }
    };
    public static int[] getSnailCoordinates(int N, int num) {
        int layer = N - 1;
        int layersLastNum = 0;
        for (; layer > 0; layer -= 2) {
            layersLastNum += layer * 4;
            if (num <= layersLastNum) {
                break;
            }
        }
        layer /= 2;
        layer = N/2 - layer;
        int lineLength = N - 2 * layer;
        int[] startInSqare = { 0, lineLength, lineLength + lineLength - 1, lineLength + lineLength - 1 + lineLength - 1 };
        int dir = 0;
        int start = N * N - (N - 2 * layer) * (N - 2 * layer);
        for (; dir < startInSqare.length; dir++) {
            if (num <= start + startInSqare[dir]) {
                break;
            }
        }
        dir--;

        int x = 0, y = 0;
        int diff = num - start;
        int option = diff - startInSqare[dir];
        if (dir == 0) { // 상단(→)
            x = layer + option - 1;
            y = layer;
        } else if (dir == 1) { // 오른쪽(↓)
            x = N - 1 - layer;
            y = layer + option;
        } else if (dir == 2) { // 하단(←)
            x = N - 1 - layer - option;
            y = N - 1 - layer;
        } else { // 왼쪽(↑)
            x = layer;
            y = N - 1 - layer - option;
        }

        // System.out.print(y + " ");

        return new int[]{x, y};
    }

    public static void main(String[] args) {
        int N = 5;
        for (int x = 0 ; x < N ; x++) {
            for (int y = 0; y < N; y++) {
                // System.out.printf("%3d ", getSnailValue(N, x, y));
                getSnailValue(N, x, y);
            }
            System.out.println();
        }
        // System.out.println("\n" + getSnailValue(N, 1, 0));

        // checkSnail(7, arr7);
        // checkSnail(5, arr5);
        // checkSnail(3, arr3); 
    }

    static void checkSnail(int N, int [][] arr) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                int[] coords = getSnailCoordinates(N, arr[x][y]);
                // System.out.printf("Value %2d -> Coordinates (%d, %d)\n", arr[i][j], coords[0], coords[1]);
                System.out.printf("%d.%d ", coords[0], coords[1]);
            }
            System.out.println();
        }
    }
}
