package acmicpc13414;

import java.io.*;
import java.util.*;

/* 수강신청
 * https://www.acmicpc.net/problem/13414
 */

 /*
1. 학번 / id를 hashmap에 저장.
2. id당 학번을 저장하는 array에 이름을 저장.
3. 중복된 학번이 올 경우 이전 id의 학번을 null로 변경하고 새로운 id를 해시맵에 저장.
4. id순서대로 최대 K개 출력, 모자를 경우 L까지만 출력.
  */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> nameMap = new HashMap<>();
        String [] idMap = new String[L];
        for (int i = 0; i < L; i++) {
            String name = bf.readLine();
            if (!nameMap.containsKey(name)) {
                nameMap.put(name, i);
                idMap[i] = name;
            } else {
                idMap[nameMap.get(name)] = null;
                nameMap.put(name, i);
                idMap[i] = name;
            }
        }
        int count = 0;
        for (int i = 0; count < K; i++) {
            if (i == L) {
                break;
            }
            if (idMap[i] != null) {
                System.out.println(idMap[i]);
                count++;
            }
        }
    }
}
