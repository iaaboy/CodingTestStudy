package acmicpc15665;

import java.io.*;
import java.util.*;

/* N과 M (11)
 * https://www.acmicpc.net/problem/15665
입력 Array를 Set으로 받아서 중복 제거
Set을 Array로 변경하고 정렬.
중복제거, 정렬된 Array의 순열을 출력.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<Integer> arr = new HashSet<>();
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        ArrayList<Integer> numList = new ArrayList<>(arr);
        numList.sort(null);
        int[] index = new int[M];
        visitNext(index, numList, 0);
        System.out.print(sb);
    }

    static StringBuilder sb = new StringBuilder();

    private static void visitNext(int[] index, ArrayList<Integer> numList, int depth) {
        if (depth == index.length) {
            for (Integer i : index) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (Integer next : numList) {
            index[depth] = next;
            visitNext(index, numList, depth + 1);
        }
    }
}
