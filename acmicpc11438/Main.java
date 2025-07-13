package acmicpc11438;

import java.io.*;
import java.util.*;

/*
 * 풀이중
 */

public class Main {
    static Vertex[] v;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(bf.readLine());
        v = new Vertex[N + 1];
        for (int i = 0; i <= N; i++) {
            v[i] = new Vertex();
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int son = Integer.parseInt(st.nextToken());
            v[parent].node.add(son);
            v[son].node.add(parent);
        }

        StringBuilder debugSb = new StringBuilder();

        //0. parent를 set
        v[0].parent = 0;
        v[1].parent = 0;
        setParent(0, 1, 1);

        //1 깊이 구한다.
        //2 바로 위 부모노드 구한다.
        //  depth를 구할때 부모노드 array를 업데이트
        int depth = getDepth(1) - 1;
        debugSb.append("depth: " + depth + "\n");
        int dpSize = getDpSize(depth);
        debugSb.append("dpSize: " + dpSize + "\n");

        //3 부모노드 dp점화식 구하기.
        // P[K][N] = P[K-1][ P[K-1][N] ]

        //3-1 dp 초기값
        int [][]P = new int[dpSize][N + 1];
        for (int i = 0; i <= N; i++) {
            P[0][i] = v[i].parent;
            for (int k = 1; k < dpSize; k++) {
                P[k][i] = P[k-1][ P[k-1][i]];
            }
        }
        for (int i = 0; i < dpSize; i++) {
            for (int j = 0; j <= N; j++) {
                debugSb.append(P[i][j] + " ");
            }
            debugSb.append("\n");
        }
        


        int M = Integer.parseInt(bf.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int me = Integer.parseInt(st.nextToken());
            int you = Integer.parseInt(st.nextToken());


        }
        System.out.print(sb);
        System.out.print(debugSb);
    }

    private static void setParent(int parent, int current, int depth) {
        for (Integer node : v[current].node) {
            if (v[node].parent == -1) {
                v[node].parent = current;
                v[node].depth = depth;
                setParent(current, node, depth + 1);
            }
        }
    }

    private static int getDpSize(int depth) {
        int dpSize = 0;
        while (depth > 0) {
            depth  /= 2;
            dpSize++;
        }
        return dpSize;
    }

    private static int getDepth(int node) {
        int myRemainedDepth = 0;
      for (Vertex v : v) {
        myRemainedDepth = Math.max(myRemainedDepth, v.depth);
      }
        return myRemainedDepth + 1;
    }

    static class Vertex {
        int parent = -1;
        int depth = 0;
        ArrayList<Integer> node = new ArrayList<>();
    }
}
