package acmicpc11815;

import java.io.*;
import java.util.*;
import java.math.BigInteger;

/* 짝수? 홀수?
 * https://www.acmicpc.net/problem/11815
약수의 개수가 홀수인 수는 제곱인 수임.
결국 제곱인 수를 구하는 문제.
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String s = st.nextToken();
            BigInteger x = new BigInteger(s);
            BigInteger sqrtX = sqrt(x);
            if (sqrtX.multiply(sqrtX).equals(x)) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }
        System.out.println(sb);
    }

    // 정수의 제곱근을 구하는 함수 (Binary Search 방식)
    public static BigInteger sqrt(BigInteger n) {
        if (n.compareTo(BigInteger.ZERO) == 0 || n.compareTo(BigInteger.ONE) == 0) {
            return n;
        }

        BigInteger low = BigInteger.ZERO;
        BigInteger high = n;
        BigInteger mid;

        while (low.compareTo(high) <= 0) {
            mid = low.add(high).shiftRight(1); // mid = (low + high) / 2
            int cmp = mid.multiply(mid).compareTo(n);

            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                low = mid.add(BigInteger.ONE);
            } else {
                high = mid.subtract(BigInteger.ONE);
            }
        }

        return high; // 정수 제곱근의 floor 값
    }
}
