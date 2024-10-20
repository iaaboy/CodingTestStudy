package prog70129;

/* 이진 변환 반복하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/70129
 */

public class MyMain {
    public static void main(String[] args) {
        String s = "110010101001";
        // String s = "1111111";
        Solution mSol = new Solution();

        for (int a : mSol.solution(s))
            System.out.print(a + " ");
    }
}

class Solution {
    int removed0 = 0;

    public int[] solution(String s) {
        int[] answer = new int[2];
        answer[0] = convert(s, 0);
        answer[1] = removed0;
        return answer;
    }

    int convert(String s, int curDepth) {
        int count1 = 0;
        StringBuffer a = new StringBuffer();

        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                count1++;
            }
        }
        removed0 += s.length() - count1;

        if (count1 == 1)
            return curDepth + 1;

        while (count1 != 0) {
            a.append((count1 & 1) == 0 ? '0' : '1');
            count1 = count1 >> 1;
        }

        if (a.length() > 0)
            return convert(a.reverse().toString(), curDepth + 1);

        return curDepth + 1;
    }
}