package acmicpc17453;

import java.io.*;
import java.util.*;

/* 두 개의 문
 * https://www.acmicpc.net/problem/17453
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        BitSet bs = new BitSet(N);
        char[] inStr = bf.readLine().toCharArray();
        for (int i = 0; i < N; i++) {
            if (inStr[i] == '1') {
                bs.set(i);
            }
        }
        BitSet[] button = new BitSet[M];
        for (int j = 0; j < M; j++) {
            inStr = bf.readLine().toCharArray();
            button[j] = new BitSet(N);
            for (int i = 0; i < N; i++) {
                if (inStr[i] == '1') {
                    button[j].set(i);
                }
            }
        }

        int loopMax = (int) Math.pow(2, M);
        HashMap<Integer, ArrayList<Integer>> numSet = new HashMap<>();
        for (int i = 0; i < loopMax; i++) {
            BitSet curBs = (BitSet) bs.clone();
            for (int j = 0; j < M; j++) {
                if ((i & (1 << j)) > 0) {
                    curBs.xor(button[j]);
                }
            }
            int oneCount = curBs.cardinality();
            int zeroCount = N - oneCount;
            int year = oneCount - zeroCount;
            if (!numSet.containsKey(year)) {
                ArrayList<Integer> buttons = new ArrayList<>();
                for (int j = 0; j < M; j++) {
                    if ((i & (1 << j)) > 0) {
                        buttons.add(j + 1);
                    }
                }
                numSet.put(year, buttons);
            }

        }

        StringBuilder sb = new StringBuilder();
        for (int j = -N; j <= N; j++) {
            if (numSet.containsKey(j)) {
                sb.append(numSet.get(j).size());
                for (Integer num : numSet.get(j)) {
                    sb.append(" ").append(num);
                }
            } else {
                sb.append(-1);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}