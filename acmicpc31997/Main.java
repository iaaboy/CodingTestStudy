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
        int N = Integer.parseInt(st.nextToken()); //사람수
        int M = Integer.parseInt(st.nextToken()); //친한 정보 개수
        int K = Integer.parseInt(st.nextToken()); //시간

        P[] p = new P[N];
        Leg[] legs = new Leg[N*2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            p[i] = new P(start, end,
                    false, new HashSet<Integer>());
            legs[i*2] = new Leg(start, true);
            legs[i*2 + 1] = new Leg(end, false);
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

        int [] enjoyChat = new int[K];

        for (Leg leg : legs) {
            if (leg.isStart) {
                
            } else {
                
            }
        }

        StringBuilder sb = new StringBuilder();
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
    static class Leg {
        int timestamp;
        boolean isStart;
        public Leg(int timestamp, boolean isStart) {
            this.timestamp = timestamp;
            this.isStart = isStart;
        }
    }
}
