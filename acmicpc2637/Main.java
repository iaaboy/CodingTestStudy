package acmicpc2637;

import java.io.*;
import java.util.*;

/* 장난감 조립
 * https://www.acmicpc.net/problem/2637
위상 정렬을 이용.
샘플의 예제를 보면
5는 기본 부품으로 가능 (linkedCount = 0)
6은 기본 부품에 5가 추가로 필요. (linkCount = 1)
7은 기보 부품에 5, 6 필요. (linkCount = 2)

loop:
q에 linkCount = 0; 넣고, 
q에서 하나씩 빼면서 linkedCount를 users가 있는 경우 하나씩 빼준다.
자식의 부품수를 내 subPart에 업데이트
linkedCount = 0 인것을 다시 q에 넣고, loop로 돌아감.

최종 N의 subpart를 가지고 pCount에 필요한 부품수를 업데이트하고
결과를 print.
 */

public class Main {
    static int[] pCount;
    static ArrayList<Part> pList = new ArrayList<>();
    static int[] linkCount;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());

        for (int i = 0; i <= N; i++) {
            pList.add(new Part(i, false));
        }

        linkCount = new int[N + 1];
        pCount = new int[N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int me = Integer.parseInt(st.nextToken());
            int partNum = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            pList.get(me).subPart.put(partNum, pList.get(me).subPart.getOrDefault(partNum, count));
            pList.get(partNum).users.add(me);
            linkCount[me]++;
        }
        // System.out.println(Arrays.toString(linkCount));
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (linkCount[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            Part c = pList.get(q.poll());
            // System.out.println(pList.get(c.pNum));

            // subpart를 합친다.
            HashMap<Integer, Integer> partsToCombine = new HashMap<>();
            for (Integer son : pList.get(c.pNum).subPart.keySet()) {
                boolean hasGrandSon = false;
                for (Integer grandSon : pList.get(son).subPart.keySet()) {
                    // sub의 sub part가 있다.
                    if (pList.get(son).subPart.get(grandSon) > 0) {
                        partsToCombine.put(grandSon,
                                partsToCombine.getOrDefault(grandSon, 0)
                                        + pList.get(son).subPart.get(grandSon) * pList.get(c.pNum).subPart.get(son));
                    }
                    hasGrandSon = true;
                }
                if (hasGrandSon) {
                    pList.get(c.pNum).subPart.put(son, 0);
                }
            }
            // System.out.println(partsToCombine);
            for (Integer subPart : partsToCombine.keySet()) {
                pList.get(c.pNum).subPart.put(subPart,
                        pList.get(c.pNum).subPart.getOrDefault(subPart, 0)
                                + pList.get(c.pNum).subPart.getOrDefault(partsToCombine, 1)
                                        * partsToCombine.get(subPart));
            }
            // System.out.println(pList.get(c.pNum));

            for (Integer u : c.users) {
                linkCount[u]--;
                if (linkCount[u] == 0) {
                    q.add(u);
                }
            }
        }
        for (Integer bp : pList.get(N).subPart.keySet()) {
            pCount[bp] += pList.get(N).subPart.get(bp);
        }

        // System.out.println(pList.get(N));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= N; i++) {
            if (pCount[i] != 0) {
                sb.append(i).append(" ").append(pCount[i]).append("\n");
            }
        }
        System.out.print(sb);
    }

    static class Part {
        int pNum;
        boolean isMain;

        public Part(int pNum, boolean isMain) {
            this.pNum = pNum;
            this.isMain = isMain;
        }

        // pNum , count
        HashMap<Integer, Integer> subPart = new HashMap<>();
        ArrayList<Integer> users = new ArrayList<>();

        @Override
        public String toString() {
            return pNum + "(" + (isMain ? "M" : "S") + ")" + subPart;
        }
    }
}
