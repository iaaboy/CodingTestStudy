package acmicpc25977;

import java.io.*;
import java.util.*;

/* k개 사과 트리 노드만으로 배를 최대로 수확하기
 * https://www.acmicpc.net/problem/25977
가능한 노드 개수가 최대 16개이므로, 완전 탐색.
비트연산 for문을 이용해 모든 경우를 listup.
트리에서 방문 가능한 조합인지 확인.
방문 가능할 경우 사과, 배의 수 계산.
K이하개의 사과 수확한 결과중 배의 수 max update
 */

public class Main {
    static Node[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(bf.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int son = Integer.parseInt(st.nextToken());
            nodes[parent].subNode.add(son);
            nodes[son].parent = parent;
        }
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            nodes[i].fruit = Integer.parseInt(st.nextToken());
        }

        int totalSubset = (int) Math.pow(2, N);
        int minPear = 0;
        for (int i = 0; i < totalSubset; i++) {
            // ArrayList<Integer> checkList = new ArrayList<>();
            boolean[] checkList = new boolean[N];
            for (int j = 0; j < N; j++) {
                // i의 j번째 비트가 1인지 확인
                int num = i & (1 << j);
                if (num > 0) {
                    // checkList.add(j);
                    checkList[j] = true;
                }
            }
            // 가능한 노드인지?
            if (isPossible(checkList)) {

                // for (int j = 0; j < N; j++) {
                // if (checkList[j]) {
                // System.out.print(j + " ");
                // }
                // }

                // 계산
                int apple = 0;
                int pear = 0;
                for (int j = 0; j < N; j++) {
                    if (checkList[j]) {
                        if (nodes[j].fruit == 1) {
                            apple++;
                        } else if (nodes[j].fruit == 2) {
                            pear++;
                        }
                    }
                }

                // System.out.println(" " + apple + "/" + pear);

                // 최소값 업데이트
                if (apple <= K) {
                    minPear = Math.max(minPear, pear);
                }
            }
        }
        System.out.println(minPear);
    }

    private static boolean isPossible(boolean[] checkList) {
        if (!checkList[0]) {
            return false;
        }

        for (int id = 0; id < checkList.length; id++) {
            if (checkList[id]) {
                int p = nodes[id].parent;
                if (!checkList[p]) {
                    return false;
                }
            }
        }
        return true;
    }

    static class Node {
        int fruit;
        int parent;
        ArrayList<Integer> subNode = new ArrayList<>();
    }
}
