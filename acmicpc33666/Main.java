package acmicpc33666;

import java.io.*;
import java.util.*;

/* 생일 멘션이 너무 많아
 * https://www.acmicpc.net/problem/33666
조건에 맞게 , count할때는 누적합.
msg오버랩되면 (isMacro == true) 매크로 판정하고, 출력.
 */

public class Main {
    static long[] message;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        double sum = 0;
        double count = 0;
        int[] arr = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > 1) {
                sum += arr[i];
                count++;
            }
        }
        double avg = count == 0 ? 0 : (sum / count);

        // System.out.println(sum + " , " + count + ", " + avg);

        message = new long[M + 2];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= avg) { // 이하
                // System.out.println("and under: " + arr[i]);
                sendMsg(arr[i]);
            } else { // 초과
                // System.out.println("over: " + arr[i]);
                sendMsg(1);
            }
        }
        // System.out.println(Arrays.toString(message));

        if (isMacro) {
            System.out.println(-1);
        } else {
            int msgCnt = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= M; i++) {
                msgCnt += message[i];
                message[i] = msgCnt;
                sb.append(message[i]).append(" ");
            }
            System.out.println(sb);
        }

        // System.out.println(Arrays.toString(message));
    }
    static boolean isMacro = false;
    private static void sendMsg(int cnt) {
        // System.out.println(cnt);
        if (cnt > M) {
            int mul = cnt / M;
            message[1] += mul;
            message[M + 1] -= mul;
            cnt %= M;
            isMacro = true;
        }

        message[1]++;
        message[cnt + 1]--;
    }
}
