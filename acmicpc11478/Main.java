package acmicpc11478;

import java.io.*;
import java.util.HashMap;

/* 서로 다른 부분 문자열의 개수
 * https://www.acmicpc.net/problem/11478
 
 sub문자열 모든 경우에 대해 hashmap에 저장
 hashmap 크기 출력 (== 서로 다른 부분 문자열의 개수)
 */

public class Main {
    static char[] inStr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String inStr = bf.readLine();
        HashMap<String, Integer> subMap = new HashMap<>();
        for (int i = 0; i < inStr.length(); i++) {
            for (int j = i + 1; j < inStr.length() + 1; j++) {
                String subStr = inStr.substring(i, j);
                subMap.put(subStr, subMap.getOrDefault(subStr, 1) + 1);
            }
        }
        System.out.println(subMap.size());
    }
}