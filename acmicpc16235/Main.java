package acmicpc16235;

import java.io.*;
import java.util.*;

/*
 * 풀이중
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] currentNutri = new int[N][N];
        int[][] annualNutri = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                annualNutri[i][j] = Integer.parseInt(st.nextToken());
                currentNutri[i][j] = 5;
            }
        }
        Farm[][] f = new Farm[N][N];
        for (int i = 0; i < N * N; i++) {
            f[i / N][i % N] = new Farm();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            f[y][x].tr.add(new Tree(z, 1));
        }
        for (int i = 0; i < N * N; i++) {
            f[i / N][i % N].tr.sort((a, b) -> a.age - b.age);
        }

        while (K-- > 0) {
            // 봄
            // 나무가 자신의 나이만큼 양분을 먹고, 나이가 1 증가한다.
            // 각각의 나무는 나무가 있는 1×1 크기의 칸에 있는 양분만 먹을 수 있다.
            // 하나의 칸에 여러 개의 나무가 있다면, 나이가 어린 나무부터 양분을 먹는다.
            // 만약, 땅에 양분이 부족해 자신의 나이만큼 양분을 먹을 수 없는 나무는 양분을 먹지 못하고 즉시 죽는다.
            for (int i = 0; i < N * N; i++) {
                int y = i / N;
                int x = i % N;
                // 봄
                for (Tree t : f[y][x].tr) {
                    if (t.age <= currentNutri[y][x]) {
                        currentNutri[y][x] -= t.age;
                        t.age++;
                        if (t.age % 5 == 0) {
                            f[y][x].breedCount++;
                        }
                    } else {
                        t.isAlive = false;
                    }
                }
            }

            // 여름
            // 여름에는 봄에 죽은 나무가 양분으로 변하게 된다.
            // 각각의 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가된다.
            // 소수점 아래는 버린다.
            for (int i = 0; i < N * N; i++) {
                int y = i / N;
                int x = i % N;
                int nutriAdds = 0;
                while (!f[y][x].tr.isEmpty() && !f[y][x].tr.getLast().isAlive) {
                    nutriAdds += (f[y][x].tr.getLast().count * (int) (f[y][x].tr.getLast().age / 2));
                    f[y][x].tr.removeLast();
                }
                currentNutri[y][x] += nutriAdds;
            }

            // 가을
            // 가을에는 나무가 번식한다.
            // 번식하는 나무는 나이가 5의 배수이어야 하며,
            // 인접한 8개의 칸에 나이가 1인 나무가 생긴다.
            // 어떤 칸 (r, c)와 인접한 칸은 (r-1, c-1), (r-1, c), (r-1, c+1), (r, c-1), (r, c+1),
            // (r+1, c-1), (r+1, c), (r+1, c+1) 이다.
            // 상도의 땅을 벗어나는 칸에는 나무가 생기지 않는다.
            int[][] newTree = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int d = 0; d < 8; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx < 0 || ny < 0 || nx >= N || ny >= N)
                            continue;
                        newTree[ny][nx] += f[i][j].breedCount;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (newTree[i][j] > 0) {
                        f[i][j].tr.add(new Tree(1, newTree[i][j]));
                    }
                }
            }

            // 겨울
            // 겨울에는 S2D2가 땅을 돌아다니면서 땅에 양분을 추가한다.
            // 각 칸에 추가되는 양분의 양은 A[r][c]이고, 입력으로 주어진다.
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    currentNutri[i][j] += annualNutri[i][j];
                }
            }
        }

        int leftTreeCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(f[i][j].tr + " ");
                for (Tree t : f[i][j].tr) {
                    leftTreeCount += t.count;
                }
            }
            System.out.println();
        }
        System.out.println(leftTreeCount);
    }

    static int[] dx = { 1, 0, -1, 0, 1, 1, -1, -1 };
    static int[] dy = { 0, 1, 0, -1, 1, -1, 1, -1 };

    static class Farm {
        LinkedList<Tree> tr = new LinkedList<Tree>();
        int breedCount = 0;
    }

    static class Tree {
        int age;
        int count;
        boolean isAlive = true;

        public Tree(int age, int count) {
            this.age = age;
            this.count = count;
        }
        
        @Override
        public String toString() {
            return age + "," + count + "," + isAlive;
        }
    }
}
