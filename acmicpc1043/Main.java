package acmicpc1043;

import java.io.*;
import java.util.*;

/* 거짓말
 * https://www.acmicpc.net/problem/1043
 * 
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Member[] member = new Member[N];
        for (int i = 0; i < N; i++) {
            member[i] = new Member();
        }
        st = new StringTokenizer(bf.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            member[Integer.parseInt(st.nextToken()) - 1].isTruely = true;
        }
        int[][] parties = new int[M][];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            t = Integer.parseInt(st.nextToken());
            parties[i] = new int[t];
            for (int j = 0; j < t; j++) {
                int partyAttendee = Integer.parseInt(st.nextToken()) - 1;
                parties[i][j] = partyAttendee;
                member[partyAttendee].party.add(i);
            }
        }

        // pa update
        Queue<Integer> check = new ArrayDeque<>();
        for (int i = 0; i < parties.length; i++) {
            check.add(i);
        }

        while (!check.isEmpty()) {
            Integer c = check.poll();
            // System.out.println(c);
            boolean hasTruely = false;
            for (int pa : parties[c]) {
                if (member[pa].isTruely) {
                    hasTruely = true;
                    break;
                }
            }
            if (hasTruely) {
                ArrayList<Integer> newTruely = new ArrayList<>();
                for (int pa : parties[c]) {
                    if (!member[pa].isTruely) {
                        newTruely.add(pa);
                        member[pa].isTruely = true;
                    }
                }
                HashSet<Integer> newParty = new HashSet<>();
                for (Integer nt : newTruely) {
                    for (Integer party : member[nt].party) {
                        newParty.add(party);
                    }
                }
                for (Integer nt : newParty) {
                    check.add(nt);
                }
            }
        }

        int partyCount = 0;
        for (int i = 0; i < parties.length; i++) {
            boolean isAllTruely = true;
            for (int j = 0; j < parties[i].length; j++) {
                if (member[parties[i][j]].isTruely) {
                    isAllTruely = false;
                    break;
                }
            }
            if (isAllTruely) {
                partyCount++;
            }
        }
        System.out.println(partyCount);

        // System.out.println(Arrays.toString(member));
    }

    static class Member {
        boolean isTruely;
        HashSet<Integer> party = new HashSet<>();

        @Override
        public String toString() {
            return isTruely + " ";
        }
    }
}
