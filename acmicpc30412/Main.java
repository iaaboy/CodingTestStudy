package acmicpc30412;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        int[] t = new int[N];
        for (int i = 0; i < t.length; i++) {
            t[i] = Integer.parseInt(st.nextToken());
        }

        int minC = Integer.MAX_VALUE;
        // 사이드 확인
        minC = Math.min(minC, compareSide(t[0], t[1], X));
        // minC = Math.min(minC, compareSide(t[1], t[0], X));
        minC = Math.min(minC, compareSide(t[t.length - 1], t[t.length - 2], X));
        // minC = Math.min(minC, compareSide(t[t.length - 2], t[t.length - 1], X));

        for (int i = 1; i < t.length - 1; i++) {
            // 나를 높임
            minC = Math.min(minC, raiseMe(t[i - 1], t[i], t[i + 1], X));

            // 양 사이드를 높임
            minC = Math.min(minC, raiseNeighbor(t[i - 1], t[i], t[i + 1], X));
        }
        System.out.println(minC);
    }

    private static int raiseNeighbor(int left, int me, int right, int X) {
        //왼쪽 높임
        int result1 = 0;
        if(left <= me) {
            result1 = me - left + X;
        } else {
            if(left - me > X) {
                result1 = 0;
            } else {
                result1 = X - (left - me);
            }
        }
        //오늘쪽 높임
        int result2 = 0;
        if(right <= me) {
            result2 = me - right + X;
        } else {
            if(right - me > X) {
                result2 = 0;
            } else {
                result2 = X - (right - me);
            }
        }
        return Math.min(result1, result2);
    }

    private static int raiseMe(int left, int me, int right, int X) {
        int result = 0;
        int you = Math.max(left, right);
        if (me <= you) {
            result = you - me + X;
        } else {
            if (me > you + X) {
                result = 0;
            } else {
                result = X - (me - you);
            }
        }
        return result;
    }

    private static int compareSide(int me, int you, int X) {
        int result;
        // me 를 높임
        if (me > you) {
            result = Math.max(0, X - (me - you));
        } else {
            result = X + (you - me);
        }

        // you 를 높임
        int result2;
        if (me > you) {
            result2 = me - you + X;
        } else {
            result2 = Math.max(0, X - (you - me));
        }
        return Math.min(result, result2);
    }
}
