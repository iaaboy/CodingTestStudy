package acmicpc2529;

import java.io.*;
import java.util.*;

/* 부등호
 * https://www.acmicpc.net/problem/2529
 */

public class Main {

    static ArrayList<String> answers = new ArrayList<>();
    static int N;
    static boolean done;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        boolean[] sig = new boolean[N];
        for (int i = 0; i < N; i++) {
            sig[i] = st.nextToken().charAt(0) == '>';
        }
        boolean[] isUsed = new boolean[10];
        ArrayList<Integer> blanc = new ArrayList<Integer>();
        done = false;
        checkNum(isUsed, sig, blanc, true);
        done = false;
        Arrays.fill(isUsed, false);
        checkNum(isUsed, sig, blanc, false);
    }

    private static void checkNum(boolean[] isUsed, boolean[] sig, ArrayList<Integer> current, boolean fromLast) {
        if (done)
            return;
        if (current.size() == N + 1) {
            if (checkCur(current, sig)) {
                done = true;
                StringBuilder sb = new StringBuilder();
                for (Integer i : current) {
                    sb.append(i);
                }
                System.out.println(sb);
            }

            return;
        }
        if (!checkCur(current, sig)) {
            return;
        }
        if (fromLast) {
            for (int i = isUsed.length - 1; i >= 0; i--) {
                if (!isUsed[i]) {
                    isUsed[i] = true;
                    ArrayList<Integer> next = new ArrayList<>(current);
                    next.add(i);
                    checkNum(isUsed, sig, next, fromLast);
                    isUsed[i] = false;
                }
            }
        } else {
            for (int i = 0; i < isUsed.length; i++) {
                if (!isUsed[i]) {
                    isUsed[i] = true;
                    ArrayList<Integer> next = new ArrayList<>(current);
                    next.add(i);
                    checkNum(isUsed, sig, next, fromLast);
                    isUsed[i] = false;
                }
            }
        }

    }

    private static boolean checkCur(ArrayList<Integer> current, boolean[] sig) {
        if (current.size() < 2)
            return true;
        for (int i = 0; i < current.size() - 1; i++) {
            if (sig[i]) {
                if (current.get(i) < current.get(i + 1)) {
                    return false;
                }
            } else {
                if (current.get(i) > current.get(i + 1)) {
                    return false;
                }
            }
        }
        return true;
    }
}
