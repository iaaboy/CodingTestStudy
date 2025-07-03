package acmicpc16235;

import java.io.*;
import java.util.*;

/*
 * 풀이중
 */

public class Main {
    static Farm[][] f;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        f = new Farm[N][N];
        for (int i = 0; i < N * N; i++) {
            f[i / N][i % N] = new Farm();
        }
        int[][] annualNutri = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                annualNutri[i][j] = Integer.parseInt(st.nextToken());
                f[i][j].nutri = 5;
            }
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
                    for (int j = 0; j < t.count; j++) {
                        if (t.age <= f[y][x].nutri) {
                            f[y][x].nutri -= t.age;
                        } else {
                            t.count--;
                            f[y][x].deadNutriAdds += t.age / 2;
                            if (t.count == 0) {
                                t.isAlive = false;
                            }
                        }
                    }
                    t.age++;
                }
            }

            // 여름
            // 여름에는 봄에 죽은 나무가 양분으로 변하게 된다.
            // 각각의 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가된다.
            // 소수점 아래는 버린다.
            for (int i = 0; i < N * N; i++) {
                int y = i / N;
                int x = i % N;
                while (!f[y][x].tr.isEmpty() && !f[y][x].tr.getLast().isAlive) {
                    f[y][x].tr.removeLast();
                }
                f[y][x].nutri += f[y][x].deadNutriAdds;
                f[y][x].deadNutriAdds = 0;
            }

            // 가을
            // 가을에는 나무가 번식한다.
            // 번식하는 나무는 나이가 5의 배수이어야 하며,
            // 인접한 8개의 칸에 나이가 1인 나무가 생긴다.
            // 어떤 칸 (r, c)와 인접한 칸은 (r-1, c-1), (r-1, c), (r-1, c+1), (r, c-1), (r, c+1),
            // (r+1, c-1), (r+1, c), (r+1, c+1) 이다.
            // 상도의 땅을 벗어나는 칸에는 나무가 생기지 않는다.

            for (int i = 0; i < N * N; i++) {
                int y = i / N;
                int x = i % N;
                // 봄
                for (Tree t : f[y][x].tr) {
                    if (t.age > 0 && t.age % 5 == 0) {
                        f[y][x].breedCount += t.count;
                    }
                }
            }

            printBreed();

            int[][] newTree = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (f[i][j].breedCount > 0) {
                        for (int d = 0; d < 8; d++) {
                            int nx = j + dx[d];
                            int ny = i + dy[d];
                            if (nx < 0 || ny < 0 || nx >= N || ny >= N)
                                continue;
                            newTree[ny][nx] += f[i][j].breedCount;
                        }
                        f[i][j].breedCount = 0;
                    }
                }
            }

            int treeCount = 0 ;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (newTree[i][j] > 0) {
                        f[i][j].tr.addFirst(new Tree(1, newTree[i][j]));
                    }
                    for (Tree t : f[i][j].tr) {
                        treeCount+= t.count;
                    }
                }
            }

            printFarm(K + " " + treeCount);

            // 겨울
            // 겨울에는 S2D2가 땅을 돌아다니면서 땅에 양분을 추가한다.
            // 각 칸에 추가되는 양분의 양은 A[r][c]이고, 입력으로 주어진다.
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    f[i][j].nutri += annualNutri[i][j];
                }
            }
        }

        int leftTreeCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (Tree t : f[i][j].tr) {
                    leftTreeCount += t.count;
                }
            }
        }

        System.out.println(leftTreeCount);
    }

    private static void printBreed() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(f[i][j].breedCount + " / ");
            }
            System.out.println();
        }
    }

    static void printFarm(String msg) {
        System.out.println(msg);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(f[i][j] + " / ");
            }
            System.out.println();
        }
    }

    static int[] dx = { 1, 0, -1, 0, 1, 1, -1, -1 };
    static int[] dy = { 0, 1, 0, -1, 1, -1, 1, -1 };

    static class Farm {
        LinkedList<Tree> tr = new LinkedList<Tree>();
        int breedCount = 0;
        int nutri = 0;
        int deadNutriAdds = 0;

        @Override
        public String toString() {
            return nutri + "<" + tr + ">";
        }
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
            return age + "," + count + "," + (isAlive? "T":"F");
        }
    }
}
