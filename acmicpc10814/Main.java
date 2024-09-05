package acmicpc10814;

import java.io.*;
import java.util.*;

/* 나이순 정렬
 * https://www.acmicpc.net/problem/10814
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Member[] m = new Member[N];
        Integer[] idx = new Integer[N];
        for (int i = 0; i < N; i++) {
            String[] k = bf.readLine().split(" ");
            m[i] = new Member(Integer.parseInt(k[0]), k[1]);
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> {
            if (m[a].age == m[b].age) {
                return a - b;
            } else {
                return m[a].age - m[b].age;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < idx.length; i++) {
            sb.append(m[idx[i]].age + " " + m[idx[i]].name + "\n");
        }
        System.out.print(sb);
    }

    static class Member {
        Integer age;
        String name;

        public Member(Integer age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}
