package acmicpc24511;

import java.io.*;
import java.util.*;

/* queuestack
 * https://www.acmicpc.net/problem/24511
Queue의 자리이면 숫자를 넣고 빼게되면 해당 자리의 숫자와 교환하는것.
Stack의 자리이면 숫자를 넣고 빼게되면 아무일도 일어나지 않는것.
Queue자리에 해당하는 숫자들을 Queue에 넣고,
입력을 받아서 Queue에 넣고, Queue에서 하나 빼서 출력한다.
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        boolean[] isQ = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (Integer.parseInt(st.nextToken()) == 0) {
                isQ[i] = true;
            }
        }
        Deque<Integer> q = new ArrayDeque<>();
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (isQ[i]) {
                q.addFirst(num);
            }
        }
        int M = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            q.add(num);
            sb.append(q.poll()).append(" ");
        }
        System.out.println(sb);
    }
}
