package prog12951;

/* JadenCase 문자열 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12951
 */

public class MyMain {
    public static void main(String[] args) {
        String[] ss = {
                "abc def geh",
                "3people unFollowed me",
                "for the last week"
        };
        Solution mSol = new Solution();
        for (String s : ss) {
            System.out.println(mSol.solution(s));
        }
    }

}

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) {
            sb.replace(i, i + 1, Character.toString(Character.toLowerCase(sb.charAt(i))));
            if (sb.charAt(i) >= 'a' && sb.charAt(i) <= 'z' && (i == 0 || sb.charAt(i - 1) == ' ')) {
                sb.replace(i, i + 1, Character.toString(Character.toUpperCase(sb.charAt(i))));
            }
        }

        return sb.toString();
    }
}