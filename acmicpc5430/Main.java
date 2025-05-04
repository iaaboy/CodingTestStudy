package acmicpc5430;

import java.io.*;
import java.util.*;

/* AC
 * https://www.acmicpc.net/problem/5430
 * ArrayDeque 응용.
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder answer = new StringBuilder();
        for (int t = 0; t < T; t++) {
            char[] cmd = bf.readLine().toCharArray();
            int N = Integer.parseInt(bf.readLine());
            StringTokenizer st = new StringTokenizer(bf.readLine(), "[|,|]");
            ArrayDeque<Integer> dq = new ArrayDeque<>();
            for (int i = 0; i < N; i++) {
                dq.add(Integer.parseInt(st.nextToken()));
            }
            boolean directionRight = true;
            boolean hasNoError = true;
            for (char c : cmd) {
                if (c == 'R') {
                    directionRight = !directionRight;
                } else {
                    if (dq.isEmpty()) {
                        answer.append("error").append("\n");
                        hasNoError = false;
                        break;
                    } else {
                        if (directionRight) {
                            dq.removeFirst();
                        } else {
                            dq.removeLast();
                        }
                    }
                }
            }
            if (hasNoError) {
                answer.append("[");
                while (!dq.isEmpty()) {
                    if (directionRight) {
                        answer.append(dq.pollFirst());
                    } else {
                        answer.append(dq.pollLast());
                    }
                    if (!dq.isEmpty()) {
                        answer.append(",");
                    }
                }
                answer.append("]\n");
            }
        }
        System.out.print(answer);
    }
}
