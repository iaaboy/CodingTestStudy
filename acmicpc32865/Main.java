package acmicpc32865;

import java.io.*;
import java.util.*;

/* 컴소인의 크리스마스
 * https://www.acmicpc.net/problem/32865
stack에 풀 문제를 저장
 * 실패의 경우는 stack에 custom으로 카운트를 저장.
pop하면서 교차해서 풀 문제 id를 출력.
fail을 pop할 때 count-- 하고, 마지막에 data전체를 pop,이후 성공 stack에 저장.

 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Stack<Integer> solveStack = new Stack<>();
        Stack<failInfo> failStack = new Stack<>();
        long failCount = 0;
        long successCount = 0;
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(bf.readLine());
            if (num == 0) {
                solveStack.push(i);
            } else {
                failStack.push(new failInfo(num, i));
                failCount += num;
            }
            successCount++;
        }
        long diff = successCount - failCount;
        if (diff == 1) {
            boolean prevSolved = false;
            StringBuilder sb = new StringBuilder();
            long i = 0;
            while (i < successCount + failCount) {
                if (prevSolved) {
                    sb.append(failStack.peek().index).append("\n");
                    // System.out.println(failStack.peek().index + " : " + failStack.peek().failCount);
                    if (failStack.peek().failCount == 1) {
                        solveStack.add(failStack.peek().index);
                        failStack.pop();
                    } else {
                        failStack.peek().failCount--;
                    }
                } else {
                    sb.append(solveStack.pop()).append("\n");
                    // System.out.println(solveStack.pop());
                }
                prevSolved = !prevSolved;
                i++;
            }
            System.out.print(sb);
        } else {
            System.out.println("-1");
        }
    }

    static class failInfo {
        int failCount;
        int index;

        public failInfo(int failCount, int index) {
            this.failCount = failCount;
            this.index = index;
        }
    }
}
