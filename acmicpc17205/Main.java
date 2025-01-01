package acmicpc17205;

import java.io.*;
import java.util.*;

/* 진우의 비밀번호
 * https://www.acmicpc.net/problem/17205
 */

public class Main {
    static ArrayList<String> numList = new ArrayList<>();
    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        String num = bf.readLine();

        setNum(0, "");
        numList.sort(null);
        int index = getNum(num);
        System.out.println(index);
    }

    private static int getNum(String num) {
        int idx = 1;
        for (String n : numList) {
            if (num.contentEquals(n)) {
                break;
            }
            idx++;
        }
        return idx;
    }

    private static void setNum(int n, String cur) {
        if (n == N) {
            return;
        }
        for (int i = 0; i < 26; i++) {
            char add = 'a';
            add += i;
            String nextStr = cur + add;
            numList.add(nextStr);
            setNum(n + 1, nextStr);
        }
    }
}
