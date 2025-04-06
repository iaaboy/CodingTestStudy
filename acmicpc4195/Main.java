package acmicpc4195;

import java.io.*;
import java.util.*;

/* 친구 네트워크
 * https://www.acmicpc.net/problem/4195
친구가 성리되변 union으로 묶는다. 
union으로 묶일때에 rootID 에 count값 저장.
합쳐질때에 rootId기준으로 count값 출력.
 */

public class Main {
    static int[] ids = new int[200001];
    static int[] counts = new int[200001];
    static HashMap<String, Integer> nameMap = new HashMap<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        for (int i = 0; i < ids.length; i++) {
            counts[i] = 1;
            ids[i] = i;
        }
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(bf.readLine());
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                String me = st.nextToken();
                String you = st.nextToken();
                int mId = getId(me);
                int yId = getId(you);
                int mRootId = getUnion(mId);
                int yRootId = getUnion(yId);
                if (mRootId != yRootId) {
                    setUnion(mRootId, yRootId);
                }
                sb.append(counts[getUnion(mRootId)]).append("\n");
                // printIds();
            }
            for (int i = 0; i < idCount; i++) {
                counts[i] = 1;
                ids[i] = i;
            }
            idCount = 0;
            nameMap.clear();
        }
        System.out.print(sb);
        // System.out.println(debugSb);
    }

    static StringBuilder debugSb = new StringBuilder();

    private static void printIds() {

        for (int j = 0; j < 10; j++) {
            debugSb.append(counts[j] + " ");
        }
        debugSb.append("\n");
        for (int j = 0; j < 10; j++) {
            debugSb.append(ids[j] + " ");
        }
        debugSb.append("\n");
    }

    static int idCount = 0;

    private static int getId(String me) {
        if (nameMap.containsKey(me)) {
            return nameMap.get(me);
        } else {
            nameMap.put(me, idCount);
            return idCount++;
        }
    }

    private static int getUnion(int from) {
        int f = from;
        while (ids[f] != f) {
            f = ids[f];
        }

        if (from != f) { // key !!! Union find 의 while loop를 줄임
            ids[from] = f;
        }

        return f;
    }

    private static void setUnion(int from, int to) {
        int f = from;
        while (ids[f] != f) {
            f = ids[f];
        }
        int t = to;
        while (ids[t] != t) {
            t = ids[t];
        }
        if (f > t) {
            ids[f] = t;
            counts[t] += counts[from];
        } else {
            ids[t] = f;
            counts[f] += counts[to];
        }
    }

}

