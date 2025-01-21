package acmicpc11656;

import java.io.*;
import java.util.*;

/* 접미사 배열
 * https://www.acmicpc.net/problem/11656
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String inStr = bf.readLine();
        ArrayList<String> inStrArr = new ArrayList<>();
        for (int i = 0; i < inStr.length(); i++) {
            inStrArr.add(inStr.substring(i, inStr.length()));
        }
        inStrArr.sort(null);
        StringBuilder sb = new StringBuilder();
        for (String string : inStrArr) {
            sb.append(string).append("\n");
        }
        System.out.print(sb);
    }
}
