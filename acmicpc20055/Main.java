package acmicpc20055;

import java.io.*;
import java.util.*;

/* 컨베이어 벨트 위의 로봇
 * https://www.acmicpc.net/problem/20055
 */

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Convayer[] conv = new Convayer[2 * N];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 2 * N; i++) {
            conv[i] = new Convayer(Integer.parseInt(st.nextToken()));
        }

        int result = 0;
        while (true) {
            result++;

            // 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
            rotate(conv);

            // 2. 가장 먼저 벨트에 올라간 로봇부터,
            // 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다
            // 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
            for (int i = N - 2; i >= 0; i--) {
                if (conv[i].hasRobot && !conv[i + 1].hasRobot && conv[i + 1].durability >= 1) {
                    conv[i].hasRobot = false;
                    conv[i + 1].hasRobot = true;
                    conv[i + 1].durability--;
                }
            }
            conv[N - 1].hasRobot = false; // 내리는 위치

            // 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다
            if (conv[0].durability > 0 && !conv[0].hasRobot) {
                conv[0].hasRobot = true;
                conv[0].durability--;
            }

            // 4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
            int zeroCount = 0;
            for (Convayer d : conv) {
                if (d.durability == 0)
                    zeroCount++;
            }
            if (zeroCount >= K)
                break;
        }

        System.out.println(result);
    }

    static void rotate(Convayer[] conv) {
        // durability 회전 , robot 회전
        int last = conv[2 * N - 1].durability;
        for (int i = 2 * N - 1; i > 0; i--) {
            conv[i].durability = conv[i - 1].durability;
            if (i <= N - 1)
                conv[i].hasRobot = conv[i - 1].hasRobot;
        }
        conv[0].durability = last;

        conv[0].hasRobot = false;
        conv[N - 1].hasRobot = false; // 내리는 위치
    }

    static class Convayer {
        int durability;
        boolean hasRobot;

        public Convayer(int durability) {
            this.durability = durability;
        }
    }
}