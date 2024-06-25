package acmicpc31997;

import java.io.*;
import java.util.*;

//TODO

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        P[] p = new P[N];
        Integer[] sIndex = new Integer[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            p[i] = new P(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    false, new HashSet<Integer>());
            sIndex[i] = i;
        }
        Arrays.sort(sIndex, (a, b) -> {
            return p[a].st - p[b].st;
        });
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int r2 = Integer.parseInt(st.nextToken()) - 1;
            p[r1].relations.add(r2);
            p[r2].relations.add(r1);
        }

        PriorityQueue<Integer> pQ = new PriorityQueue<>((a, b) -> {
            return p[a].ed - p[b].ed;
        });

        int ptr = 0;
        int talk = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            while (ptr < N && p[sIndex[ptr]].st == i) {
                int me = sIndex[ptr];
                p[me].onMeeting = true;
                pQ.add(me);
                for (Integer friend : p[me].relations) {
                    if (p[friend].onMeeting && p[friend].relations.contains(me)) {
                        talk++;
                    }
                }
                ptr++;
            }
            while (!pQ.isEmpty() && p[pQ.peek()].ed <= i) {
                int me = pQ.poll();
                for (Integer friend : p[me].relations) {
                    if (p[friend].onMeeting && p[friend].relations.contains(me)) {
                        talk--;
                    }
                }
                p[me].onMeeting = false;
            }
            sb.append(talk + "\n");
        }
        System.out.print(sb);
    }

    static class P {
        int st;
        int ed;
        boolean onMeeting;
        HashSet<Integer> relations;

        public P(int st, int ed, boolean onMeeting, HashSet<Integer> relations) {
            this.st = st;
            this.ed = ed;
            this.onMeeting = onMeeting;
            this.relations = relations;
        }
    }
}
