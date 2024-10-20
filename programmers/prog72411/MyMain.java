package prog72411;

import java.util.*;

/* 메뉴 리뉴얼
 * https://school.programmers.co.kr/learn/courses/30/lessons/72411
 */

public class MyMain {
    public static void main(String[] args) {
        // String[] orders = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
        // int[] course = { 2, 3, 4 };
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = { 2, 3, 4 };

        Solution mSol = new Solution();
        System.out.println(Arrays.toString(mSol.solution(orders, course)));
    }
}

class Solution {
    public String[] solution(String[] orders, int[] course) {
        String[] answer;
        TreeSet<String> abc = new TreeSet<>();

        for (String order : orders) {
            TreeSet <Character> cc = new TreeSet<Character>();
            for(Character c : order.toCharArray()) {
                cc.add(c);
            }
        }


        for (int c : course) {
            for (String order : orders) {
                String aa = "";
                TreeSet <Character> cc = new TreeSet<Character>();
                for(Character ch : order.toCharArray()) {
                    cc.add(ch);
                }
                for(Character mm : cc) {
                    aa+=mm;
                }
                recordOrder(aa, c);

            }
    
            // for (String order : orders) {
            //     recordOrder(order, c);
            // }

            int maxCount = 1;
            for (Integer count : orderMap.values()) {
                if (count > maxCount)
                    maxCount = count;
            }

            if(maxCount == 1)
                continue;

            Iterator<String> keys = orderMap.keySet().iterator();
            while (keys.hasNext()) {
                String key = keys.next();
                if (orderMap.get(key) == maxCount)
                    abc.add(key);
            }
            // System.out.println(abc);

            orderMap.clear();
        }

        answer = new String[abc.size()];
        int idx = 0;
        for (String str : abc) {
            answer[idx++] = str;
        }

        return answer;
    }

    String currentOrder = "";
    HashMap<String, Integer> orderMap = new HashMap<>();

    private void recordOrder(String order, int len) {
        currentOrder = order;
        result = new int[10];
        combination(0, len, order.length());
        // System.out.println("=====\n" + orderMap);
    }

    static int[] target = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    static int[] result = new int[10];
    static boolean[] visited = new boolean[10];

    private void combination(int curIdx, int count, int totalLen) {
        // System.out.println("combi, curIdx: " + curIdx + " count: " + count + "totalLen: " + totalLen);
        if (curIdx == count) {
            for (int i = 1; i < curIdx; i++) {
                if (result[i] < result[i - 1]) {
                    return;
                }
            }
            String resultStr = "";
            for (int i = 0; i < curIdx; i++) {
                // System.out.print(currentOrder.charAt(result[i] - 1));
                resultStr += currentOrder.charAt(result[i] - 1);
            }
            
            System.out.println(resultStr);

            if (!orderMap.containsKey(resultStr)) {
                orderMap.put(resultStr, 1);
            } else {
                orderMap.put(resultStr, orderMap.get(resultStr) + 1);
            }
            return;
        }
        for (int i = curIdx; i < totalLen; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            result[curIdx] = target[i];
            combination(curIdx + 1, count, totalLen);
            visited[i] = false;
        }
    }
}
