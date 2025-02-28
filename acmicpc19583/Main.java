package acmicpc19583;

import java.io.*;
import java.util.*;

/* 싸이버개강총회
 * https://www.acmicpc.net/problem/19583
 */

/*
1. 입력 받은 시간을 분단위로 만드는 함수를 별도로 구현
2. 시간, 이름(key)
3. 개강총회를 시작하기 전
   hashmap에 등록하고,  value를 false로 설정.
4. 개강총회를 끝내고 나서, 스트리밍을 끝낼 때까록
   hashmap에 등록된 이름만 value를 true로 변경
5. value중 true를 카운트.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int startTime = getTime(st.nextToken());
        int gAEnd = getTime(st.nextToken());
        int gAStreamEnd = getTime(st.nextToken());
        HashMap<String, Boolean> nameMap = new HashMap<>();
        while (true) {
            String s = bf.readLine();
            if (s == null) {
                break;
            }
            st = new StringTokenizer(s);
            if (st.countTokens() == 0) {
                break;
            }
            int t = getTime(st.nextToken());
            String name = st.nextToken();
            if (t <= startTime) {
                nameMap.put(name, false);
            }
            if (t >= gAEnd && t <= gAStreamEnd) {
                if (nameMap.containsKey(name)) {
                    nameMap.put(name, true);
                }
            }
        }
        int count = 0;
        // System.out.println(nameMap);
        for (Boolean attend : nameMap.values()) {
            if (attend) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static int getTime(String tStr) {
        String[] tt = tStr.split(":");
        return 60 * Integer.parseInt(tt[0]) + Integer.parseInt(tt[1]);
    }
}