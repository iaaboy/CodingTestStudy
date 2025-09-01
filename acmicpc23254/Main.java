package acmicpc23254;

import java.io.*;
import java.util.*;

/* 나는 기말고사형 인간이야
 * https://www.acmicpc.net/problem/23254
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] currentScore = new int[M];
        int[] adds = new int[M];
        st = new StringTokenizer(bf.readLine());
        StringTokenizer st2 = new StringTokenizer(bf.readLine());

        PriorityQueue<Integer> priorityIndex = new PriorityQueue<>((a, b) -> adds[b] - adds[a]);
        for (int i = 0; i < M; i++) {
            currentScore[i] = Integer.parseInt(st.nextToken());
            adds[i] = Integer.parseInt(st2.nextToken());
            priorityIndex.add(i);
        }
        int remainedHour = N * 24;
        while (remainedHour > 0 && !priorityIndex.isEmpty()) {
            int c = priorityIndex.peek();
            int additionalScore = adds[c];
            if (currentScore[c] + additionalScore < 100) {
                currentScore[c] += additionalScore;
                remainedHour--;
            } else if (currentScore[c] + additionalScore == 100) {
                currentScore[c] += additionalScore;
                priorityIndex.poll();
                remainedHour--;
            } else if (currentScore[c] + additionalScore > 100) {
                priorityIndex.poll();
                // currentScore[c] = 100;
                adds[c] = 100 - currentScore[c];
                priorityIndex.add(c);
            }
        }
        // System.out.println(remainedHour + ":" + Arrays.toString(currentScore));
        // System.out.println(priorityIndex);
        // System.out.println(Arrays.toString(adds));
        long sum = 0;
        for (int i = 0; i < M; i++) {
            sum += currentScore[i];
        }
        System.out.println(sum);
    }
}
