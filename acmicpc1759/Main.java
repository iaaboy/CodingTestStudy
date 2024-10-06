package acmicpc1759;

import java.io.*;
import java.util.*;

/* 암호 만들기
 * https://www.acmicpc.net/problem/1759
 */

public class Main {
    static char[] ch;
    static ArrayList<StringBuilder> pw = new ArrayList<>();
    static Set<Character> vowel = Set.of('a', 'e', 'i', 'o', 'u');
    static int L;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        ch = bf.readLine().replace(" ", "").toCharArray();
        Arrays.sort(ch);
        boolean[] visited = new boolean[C];

        combi(visited, 0, L);
        StringBuilder answer = new StringBuilder();
        for (StringBuilder b : pw) {
            answer.append(b).append("\n");
        }
        System.out.print(answer);
    }

    private static void combi(boolean[] visited, int start, int depth) {
        if (depth == 0) {
            StringBuilder b = new StringBuilder();
            int vCount = 0;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    if (vowel.contains(ch[i])) {
                        vCount++;
                    }
                    b.append(ch[i]);
                }
            }
            if (vCount >= 1 && L - vCount >= 2) {
                // System.out.println(b);
                pw.add(b);
            }

            return;
        }
        for (int i = start; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combi(visited, i + 1, depth - 1);
                visited[i] = false;
            }
        }
    }
}
