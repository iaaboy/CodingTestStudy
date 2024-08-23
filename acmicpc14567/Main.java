package acmicpc14567;

import java.io.*;
import java.util.*;

/* 선수과목 (Prerequisite)
 * https://www.acmicpc.net/problem/14567
 */

public class Main {
    static Subject[] subjects;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        subjects = new Subject[N];
        for (int i = 0; i < subjects.length; i++) {
            subjects[i] = new Subject();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int preSub = Integer.parseInt(st.nextToken()) - 1;
            int sub = Integer.parseInt(st.nextToken()) - 1;
            subjects[sub].preSub.add(preSub);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < subjects.length; i++) {
            sb.append(getPresub(i, 1) + " ");
        }
        System.out.println(sb);
    }

    private static int getPresub(int s, int depth) {
        int result = depth;
        for (int nextS : subjects[s].preSub) {
            if (subjects[nextS].pNum == -1) {
                result = Math.max(result, getPresub(nextS, depth + 1));
            } else {
                result = Math.max(result, subjects[nextS].pNum + 1);
            }
        }
        subjects[s].pNum = result;
        return result;
    }

    static class Subject {
        ArrayList<Integer> preSub;
        int pNum = -1;

        public Subject() {
            this.preSub = new ArrayList<>();
        }
    }
}
