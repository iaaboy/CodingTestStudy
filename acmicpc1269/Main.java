package acmicpc1269;

import java.io.*;
import java.util.*;

/* 대칭 차집합
 * https://www.acmicpc.net/problem/1269
  Hashmap사용하여 해당하지 않은 상대방집한 구성원 숫자를 센다.
  (양편에 대해 모두 해야 함.)
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;
        Set<Integer> setA = new HashSet();
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            setA.add(Integer.parseInt(st.nextToken()));
        }
        Set<Integer> setB = new HashSet();
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            setB.add((num));
            if (setA.contains(num)) {
                count++;
            }
        }
        int result = N - count;
        count = 0;
        for (int num : setA) {
            if (setB.contains(num)) {
                count++;
            }
        }
        result += M - count;
        System.out.println(result);
    }
}
