package acmicpc1173;

import java.io.*;
import java.util.*;

/* 운동
 * https://www.acmicpc.net/problem/1173
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());// 운동회수 목표
        int m = Integer.parseInt(st.nextToken());// 초기체력
        int M = Integer.parseInt(st.nextToken());// max
        int T = Integer.parseInt(st.nextToken());// 운동시 +
        int R = Integer.parseInt(st.nextToken());// 휴식시 -

        int pulse = m;
        int healthCount = 0;
        int count = 0;
        if (M - m < T) {
            System.out.println(-1);
        } else {
            while (true) {
                if (healthCount >= N) {
                    System.out.println(count);
                    break;
                }
                if (M >= pulse + T) {
                    pulse += T;
                    healthCount++;
                } else if (M < pulse + T) {
                    pulse -= R;
                    if (pulse < m) {
                        pulse = m;
                    }
                }
                count++;
            }
        }
    }
}
