package acmicpc11729;

import java.io.*;

/* 하노이 탑 이동 순서
 * https://www.acmicpc.net/problem/11729

재귀로 하노이의 탑을 구현하되, 
원반을 옮기는 포인트에서 from -> to 를 프린트함.

 */

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int count = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        hanoi(N, 1, 2, 3);
        sb.insert(0, count + "\n");
        System.out.print(sb);
    }

    /*
     * 첫 번째 단계: 가장 큰 원반을 A에서 C로 이동하기 위해, 먼저 A에서 B로 n-1개의 원반을 옮깁니다.
     * 두 번째 단계: 가장 큰 원반을 A에서 C로 직접 옮깁니다.
     * 세 번째 단계: B에 있는 n-1개의 원반을 C로 옮기기 위해, B에서 C로 n-1개의 원반을 옮깁니다. 이 과정에서 A는 보조 기둥
     * 역할을 합니다.
     */
    public static void hanoi(int n, int from, int aux, int to) {
        if (n == 1) {
            count++;
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }
        hanoi(n - 1, from, to, aux);
        count++;
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(n - 1, aux, from, to);
    }
}
