package acmicpc16165;

import java.io.*;
import java.util.*;

/* 걸그룹 마스터 준석이
 * https://www.acmicpc.net/problem/16165

1. 그룹이름 / 멤버 리스트 hashmap에 저장
2. 멤버이름 / 그룹이름 hashmap에 저장
3. 각 그룹의 멤버 리스트 정렬
4. 입력받은 이름이 멤버이름이면 그룹이름 출력
5. 입력받은 이름이 그룹이름이면 멤버이름 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, List<String>> map = new HashMap<>();
        HashMap<String, String> teamMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String teamName = bf.readLine();
            map.put(teamName, new ArrayList<>());

            int memberCount = Integer.parseInt(bf.readLine());
            for (int j = 0; j < memberCount; j++) {
                String memberName = bf.readLine();
                map.get(teamName).add(memberName);
                teamMap.put(memberName, teamName);
            }
        }
        for (List<String> members : map.values()) {
            Collections.sort(members);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String name = bf.readLine();
            if (bf.readLine().charAt(0) == '1') {
                sb.append(teamMap.get(name)).append("\n");
            } else {
                
                for (String member : map.get(name)) {
                    sb.append(member).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}
