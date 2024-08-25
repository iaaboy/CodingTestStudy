package acmicpc31997;

import java.io.*;
import java.util.*;

/* TODO
https://www.acmicpc.net/problem/31997
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken()); // 사람수
        int M = Integer.parseInt(st.nextToken()); // 친한 정보 개수
        int K = Integer.parseInt(st.nextToken()); // 시간

        P[] p = new P[N];
        Leg[] legs = new Leg[N * 2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            p[i] = new P(start, end,
                    false, new HashSet<Integer>());
            legs[i * 2] = new Leg(i, start, true);
            legs[i * 2 + 1] = new Leg(i, end, false);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int r2 = Integer.parseInt(st.nextToken()) - 1;
            p[r1].relations.add(r2);
            p[r2].relations.add(r1);
        }

        Arrays.sort(legs, (a, b) -> {
            return a.timestamp - b.timestamp;
        });

        // System.out.println(Arrays.toString(p));

        int[] enjoyChat = new int[K];

        ArrayList<Integer> meetMembers = new ArrayList<>();
        for (int i = 0; i < legs.length; i++) {
            Leg leg = legs[i];
            if (leg.isStart) {
                meetMembers.add(leg.index);
                p[leg.index].onMeeting = true;
            } else {
                p[leg.index].onMeeting = false;
                meetMembers.remove((Integer) leg.index);
            }
            if (i < legs.length - 1 && leg.timestamp != legs[i + 1].timestamp) {
                for (Integer memIndex : meetMembers) {
                    for (Integer rel : p[memIndex].relations) {
                        if (p[rel].onMeeting) {
                            enjoyChat[leg.timestamp]++;
                        }
                    }
                }
            }
        }

        // System.out.println(Arrays.toString(enjoyChat));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < enjoyChat.length; i++) {
            sb.append((enjoyChat[i] / 2) + "\n");
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

        @Override
        public String toString() {
            return st + "->" + ed + ":" + relations;
        }
    }

    static class Leg {
        int index;
        int timestamp;
        boolean isStart;

        public Leg(int index, int timestamp, boolean isStart) {
            this.timestamp = timestamp;
            this.isStart = isStart;
            this.index = index;
        }
    }
}
