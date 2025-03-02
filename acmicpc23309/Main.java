package acmicpc23309;

import java.io.*;
import java.util.*;

/* 철도 공사
 * https://www.acmicpc.net/problem/23309
 */

 /*
1. Linked list를 구현
2. 각 id별로 직접 접근 가능하도록 배열 관리 (map)
  */

public class Main {
    static Link[] links;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        links = new Link[1000001];
        st = new StringTokenizer(bf.readLine());
        int firstNum = Integer.parseInt(st.nextToken());
        links[firstNum] = new Link(firstNum);
        int prev = firstNum;
        int me = 0;
        for (int i = 1; i < N; i++) {
            me = Integer.parseInt(st.nextToken());
            links[me] = new Link(me);
            links[prev].next = links[me];
            links[me].prev = links[prev];
            prev = me;
        }
        links[me].next = links[firstNum];
        links[firstNum].prev = links[me];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            String cmd = st.nextToken();
            int m = Integer.parseInt(st.nextToken());
            int r;
            if (cmd.contentEquals("BN")) {
                int n = Integer.parseInt(st.nextToken());
                r = links[m].buildNext(n);
            } else if (cmd.contentEquals("BP")) {
                int p = Integer.parseInt(st.nextToken());
                r = links[m].buildPrev(p);
            } else if (cmd.contentEquals("CN")) {
                r = links[m].clearNext(m);
            } else { // CP
                r = links[m].clearPrev(m);
            }
            sb.append(r).append("\n");
        }
        System.out.print(sb);
    }

    static class Link {
        Link prev, next;
        int me;

        public Link(int me) {
            this.me = me;
        }

        public int buildNext(int n) {
            links[n] = new Link(n);

            next.prev = links[n];
            links[n].next = next;

            links[n].prev = this;
            this.next = links[n];

            return links[n].next.me;
        }

        public int buildPrev(int n) {
            links[n] = new Link(n);

            prev.next = links[n];
            links[n].prev = prev;

            links[n].next = this;
            this.prev = links[n];

            return links[n].prev.me;
        }

        public int clearNext(int n) {
            int cNum = next.me;
            delete(cNum);
            return cNum;
        }

        public int clearPrev(int n) {
            int cNum = prev.me;
            delete(cNum);
            return cNum;
        }

        private void delete(int d) {
            links[d].prev.next = links[d].next;
            links[d].next.prev = links[d].prev;
            links[d] = null;
        }
    }
}
