package acmicpc10981;

import java.io.*;
import java.util.*;

/* HEADING TO WORLD FINALS
 * https://www.acmicpc.net/problem/10981
 * 정렬
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String [] univercity = new String[N];
        String [] team = new String[N];
        int [] solved = new int[N];
        int [] penalty = new int[N];
        Integer [] index = new Integer[N];
        for (int i = 0; i < N; i++) {
            index[i] = i;
            st = new StringTokenizer(bf.readLine());
            univercity[i] = st.nextToken();
            team[i] = st.nextToken();
            solved[i] = Integer.parseInt(st.nextToken());
            penalty[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(index, (a, b) -> {
            if (solved[a] == solved[b]) {
                return penalty[a] - penalty[b];
            } else {
                return solved[b] - solved[a];
            }
        });
        HashSet <String> advanced = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (Integer n : index) {
            if (advanced.size() >= K) {
                break;
            }
            if (advanced.contains(univercity[n])) {
                continue;
            }
            advanced.add(univercity[n]);
            sb.append(team[n]).append("\n");
        }
        System.out.print(sb);
    }
}

/*
 10 3
KAIST OriGoGi 10 1184
KAIST Let_Myungwoo_go_WF 10 1323

Seoul_Univ cpp 10 1148

Seoul_Univ Wook_Norris 8 594

Yonsei_Univ Underwood 8 806
Seoul_Univ crazy_bus_driver 8 1065
Peking_Univ Nornir 8 837
Seoul_Univ KimChiWarrior 8 836
Hanyang_Univ StyleShare 8 1109
POSTECH CHOCOLATE 8 1085
 */
