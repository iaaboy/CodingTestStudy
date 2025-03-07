package acmicpc20920;

import java.io.*;
import java.util.*;

/* 영단어 암기는 괴로워
 * https://www.acmicpc.net/problem/20920
 */

/*
자주 나오는 단어일수록 앞에 배치한다.
해당 단어의 길이가 길수록 앞에 배치한다.
알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다
Count를 저장하고, 
조건에 맞게 sorting.
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<String> words = new ArrayList<>();
        HashMap<String, Integer> wMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String a = bf.readLine();
            if (a.length() >= M) {
                if (!wMap.containsKey(a)) {
                    wMap.put(a, 1);
                    words.add(a);
                } else {
                    wMap.put(a, wMap.get(a) + 1);
                }
            }
        }
        words.sort((a, b) -> {
            int aA = wMap.get(a);
            int aB = wMap.get(b);
            if (aA == aB) {
                if (a.length() == b.length()) {
                    return a.compareTo(b);
                } else {
                    return b.length() - a.length();
                }
            } else {
                return aB-aA;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            sb.append(w).append("\n");
        }
        System.out.print(sb);
    }
}

