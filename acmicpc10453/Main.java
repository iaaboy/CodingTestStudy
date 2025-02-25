package acmicpc10453;

import java.io.*;
import java.util.*;

/* 문자열 변환
 * https://www.acmicpc.net/problem/10453
 */

/*
1. -1이 되는 조건을 먼저 검사한다.
  (첫번째 스트링과 두번째 스트링의 길이가 다를 경우력
  (첫번째 스트링, 두번째 스크링간 a의 개수 혹은 b의 개수가 다를 경우)
2. 왼쪽부터 문자가 서로 다른 경우 가장 가까운 오른쪽 반대 문자와 치환한다.
   치환된 문자 위치간 차이를 리턴
   리턴된 값을 누적하여 합하고, 이를 끝까지 반복.
3. 누적된 합을 출력
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            char[] first = st.nextToken().toCharArray();
            char[] second = st.nextToken().toCharArray();
            int aSize = countChar(first, 'a');
            int bSize = countChar(second, 'a');
            if (aSize != bSize || first.length != second.length) {
                sb.append(-1).append("\n");
                continue;
            }
            int result = countSwap(first, second);
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }

    private static int countSwap(char[] first, char[] second) {
        int index = 0;
        int count = 0;
        while (index < first.length) {
            if (first[index] != second[index]) {
                int replace = index + 1;
                for (; replace < second.length; replace++) {
                    if (first[index] != first[replace]) {
                        break;
                    }
                }
                count += swap(first, index, replace);
            }
            index++;
        }
        return count;
    }

    private static int swap(char[] cList, int me, int you) {
        char temp = cList[me];
        cList[me] = cList[you];
        cList[you] = temp;
        return you - me;
    }

    static int countChar(char[] cList, char ch) {
        int count = 0;
        for (int i = 0; i < cList.length; i++) {
            if (cList[i] == ch) {
                count++;
            }
        }
        return count;
    }
}
