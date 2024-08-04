package acmicpc21275;

import java.io.*;
import java.util.*;

/* 폰 호석만
 * https://www.acmicpc.net/problem/21275
 */

public class Main {
    static String num1Str;
    static String num2Str;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        num1Str = st.nextToken();
        num2Str = st.nextToken();

        ArrayList<essensePair> mList1 = new ArrayList<essensePair>();
        for (long i = 2; i <= 36; i++) {
            long newA = getNum2(num1Str, i);
            if (newA == -1 || newA >= Long.MAX_VALUE) {
                continue;
            }
            for (long j = 2; j <= 36; j++) {
                long newB = getNum2(num2Str, j);
                if (newB == -1 && newB >= Long.MAX_VALUE) {
                    continue;
                }
                if (newA == newB && i != j) {
                    mList1.add(new essensePair(i, j, newA));
                }
            }
        }

        if (mList1.size() == 0) {
            System.out.println("Impossible");
        } else if (mList1.size() == 1) {
            essensePair eP = mList1.get(0);
            System.out.println(Long.toString(eP.dec) + " " + Long.toString(eP.es1) + " " + Long.toString(eP.es2));
        } else {
            System.out.println("Multiple");
        }

    }

    static long getNum2(String num, long k) {
        long ans = 0;
        for (int i = 0; i < num.length(); i++) {
            int c = num.charAt(i);
            if ('0' <= c && c <= '9') {
                c -= '0';
                if (c >= k) {
                    return -1;
                }
            }
            if ('a' <= c && c <= 'z') {
                c -= ('a' - 10);
                if (c >= k) {
                    return -1;
                }
            }
            // ans Double 최대값 이상이면 Long Max 값으로 리턴됨.
            ans += c * Math.pow(k, num.length() - i - 1);
        }
        return ans;
    }

    static class essensePair {
        long es1;
        long es2;
        long dec;

        public essensePair(long es1, long es2, long dec) {
            this.es1 = es1;
            this.es2 = es2;
            this.dec = dec;
        }

        @Override
        public String toString() {
            return es1 + "," + es2 + ":" + dec;
        }
    }
}