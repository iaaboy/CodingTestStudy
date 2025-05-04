package acmicpc4881;

import java.io.*;
import java.util.*;

/* 자리수의 제곱
 * https://www.acmicpc.net/problem/4881
 * HashSet에 조건(자리수의 제곱)에 맞게 숫자 저장, 처음 공통으로 나타나는 index를 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        while (A != 0 && B != 0) {
            HashSet<Num> aSet = getASet(A);
            HashSet<Num> bSet = getASet(B);

            // System.out.println(aSet);
            // System.out.println(bSet);

            int minLen = Integer.MAX_VALUE;
            for (Num a : aSet) {
                for (Num b : bSet) {
                    if (a.num == b.num) {
                        minLen = Math.min(minLen, a.index + b.index);
                    }
                }
            }
            if (minLen == Integer.MAX_VALUE) {
                minLen = 0;
            }
            sb.append(A).append(" ").append(B).append(" ");
            sb.append(minLen).append("\n");

            st = new StringTokenizer(bf.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
        }

        System.out.print(sb);
    }

    private static HashSet<Num> getASet(int A) {
        HashSet<Num> aSet = new HashSet<>();
        int index = 1;
        Num me = new Num(index, A);
        while (!aSet.contains(me)) {
            aSet.add(me);
            A = getNum(A);
            me = new Num(++index, A);
        }
        return aSet;
    }

    private static int getNum(int a) {
        int result = (a % 10) * (a % 10);
        while (a != 0) {
            a /= 10;
            result += (a % 10) * (a % 10);
        }
        return result;
    }

    static class Num {
        int index;
        int num;

        public Num(int index, int num) {
            this.index = index;
            this.num = num;
        }

        @Override
        public boolean equals(Object obj) {
            Num o = (Num) obj;
            return this.num == o.num;
        }

        @Override
        public int hashCode() {
            return num;
        }

        @Override
        public String toString() {
            return num + "(" + index + ")";
        }
    }
}